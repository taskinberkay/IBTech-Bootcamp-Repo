package composition.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import composition.entities.Cart;
import composition.entities.Product;

public class ProductManager extends BaseManager<Product> {

	public ProductManager(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public List<Product> getAllProducts() throws Exception {
		String sql = "select * from Products p join Categories c on p.categoryid = c.categoryid";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		return productList;
	}

	public Product findByProductId(long productId) throws Exception {
		Product product = null;
		String sql = "select * from Products p join Categories c on p.categoryid = c.categoryid where productid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			product = parse(resultSet);
			return product;
		}
		disconnect();
		return product;
	}
	public List<Product> findByCategoryId(long categoryId) throws Exception {
		String sql = "select * from Products where categoryid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, categoryId);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		return productList;
	}
	
	public boolean insert(Product product) throws Exception {
		String sql = "insert into Products(productname,salesprice,categoryid,imgpath) values (?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalesPrice());
		statement.setLong(3, product.getCategoryId());
		statement.setString(4, product.getImgPath());
		int affected = statement.executeUpdate();
		System.out.println("Etkileniş: " + affected);
		return affected > 0;
	}
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String query = "select * from products where productid=?";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setLong(1, item.getProductId());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setProductId(rs.getLong("productid"));
                        row.setProductName(rs.getString("productname"));
                        row.setCategoryId(rs.getLong("categoryid"));
                        row.setSalesPrice(rs.getDouble("salesprice")*item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String query = "select salesprice from products where productid=?";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setLong(1, item.getProductId());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("salesprice")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }
	

	protected Product parse(ResultSet resultSet) throws SQLException {
		long productId = resultSet.getLong("productId");
		String productName = resultSet.getString("productName");
		double salesPrice = resultSet.getDouble("salesPrice");
		long categoryId = resultSet.getLong("categoryId");
		String imgPath = resultSet.getString("imgPath");
		Product product = new Product(productId, productName, salesPrice, categoryId, imgPath);
		return product;
	}

}
