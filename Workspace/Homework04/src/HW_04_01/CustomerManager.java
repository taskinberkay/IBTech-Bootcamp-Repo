package HW_04_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
	String url = "jdbc:postgresql://localhost/dbgodoro";
	String user = "postgres";
	String password = "7534286";
	String driver = "org.postgresql.Driver";

	public CustomerManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insert(Customer customer) throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "insert into Customer(customername,totaldebit) values (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalDebit());
		int affected = statement.executeUpdate();
		connection.close();
		System.out.println("Etkileniş: " + affected);
		return affected > 0;
	}

	public boolean update(Customer customer) throws Exception {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "update customer set customername = ?, totaldebit = ? where customerid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalDebit());
		statement.setLong(3, customer.getCustomerId());
		int affected = statement.executeUpdate();
		connection.close();
		return affected > 0;
	}

	public boolean delete(Customer customer) throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "delete from customer where customerid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, customer.getCustomerId());
		int affected = statement.executeUpdate();
		connection.close();
		return affected > 0;
	}

	public List<Customer> list() throws Exception {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "select * from Customer";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Customer> customerList = parseList(resultSet);
		connection.close();
		return customerList;
	}

	public Customer find(long customerId) throws Exception {
		Customer customer = null;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "select * from customer where customerid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, customerId);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			customer=parse(resultSet);
			connection.close();
			return customer;
		}
		connection.close();
		return customer;

	}
	
	public List<Customer> filter(double totalDebitMin) throws Exception {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "select * from Customer where totaldebit >= ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, totalDebitMin);
		ResultSet resultSet = statement.executeQuery();
		List<Customer> customerList = parseList(resultSet);
		connection.close();
		return customerList;

	}
	
	private List<Customer> parseList(ResultSet resultSet) throws Exception{
		List<Customer> customerList = new ArrayList<>();
		while(resultSet.next()) {
			Customer customer = parse(resultSet);
			customerList.add(customer);
		}
		return customerList;
	}
	
	private Customer parse(ResultSet resultSet) throws Exception {
		long customerId = resultSet.getLong("customerid");
		String customerName = resultSet.getString("customername");
		double totalDebit = resultSet.getDouble("totaldebit");
		Customer customer = new Customer(customerId, customerName, totalDebit);
		return customer;
	}

}
