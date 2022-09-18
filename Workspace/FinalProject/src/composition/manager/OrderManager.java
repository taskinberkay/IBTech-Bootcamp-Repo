package composition.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import composition.entities.Order;
import composition.entities.Product;

public class OrderManager extends BaseManager<Order> {

	public OrderManager(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public List<Order> userOrders(long userid) throws Exception {
		String sql = "select * from orders where userid=? order by orders.orderid desc";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, userid);
		ResultSet resultSet = statement.executeQuery();
		List<Order> productList = parseList(resultSet);
		return productList;
	}

	public boolean insertOrder(Order order) {
		String sql = "insert into orders (productid, userid, orderquantity, orderdate) values(?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, order.getProductId());
			statement.setLong(2, order.getUserid());
			statement.setInt(3, order.getQuantity());
			statement.setDate(4, order.getDate());
			int affected = statement.executeUpdate();
			return affected > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
		
	}

	public boolean cancelOrder(int orderid) {
        boolean result = false;
        try {
            String query = "delete from orders where orderid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderid);
            statement.execute();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return result;
    }
	
	protected Order parse(ResultSet resultSet) {
		Order order = new Order();
		ProductManager pm = new ProductManager(connection);
		int pId;
		try {
			pId = resultSet.getInt("productid");
			Product product;
			try {
				product = pm.findByProductId(pId);
				order.setOrderId(resultSet.getInt("orderid"));
				order.setProductId(pId);
				order.setProductName(product.getProductName());
				order.setCategoryId(product.getCategoryId());
				order.setSalesPrice(product.getSalesPrice() * resultSet.getInt("orderquantity"));
				order.setQunatity(resultSet.getInt("orderquantity"));
				order.setDate(resultSet.getDate("orderdate"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return order;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return order;

	}

}
