package com.godoro.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
	String url = "jdbc:postgresql://localhost/dbgodoro";
	String user = "postgres";
	String password = "7534286";
	String driver = "org.postgresql.Driver";

	public ProductManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insert(Product product) throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "insert into Product(productName,salePrice) values (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalePrice());
		int affected = statement.executeUpdate();
		connection.close();
		System.out.println("Etkileniş: " + affected);
		return affected > 0;
	}

	public boolean update(Product product) throws Exception {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "update Product set productName = ?, salePrice = ? where productId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalePrice());
		statement.setLong(3, product.getProductId());
		int affected = statement.executeUpdate();
		connection.close();
		return affected > 0;
	}

	public boolean delete(Product product) throws Exception {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "delete from Product where productId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, product.getProductId());
		int affected = statement.executeUpdate();
		connection.close();
		return affected > 0;
	}

	public List<Product> list() throws Exception {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "select * from Product";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		connection.close();
		return productList;
	}

	public Product find(long productId) throws Exception {
		Product product = null;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "select * from Product where productid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			product=parse(resultSet);
			connection.close();
			return product;
		}
		connection.close();
		return product;

	}
	
	public List<Product> filter(double salePriceMin) throws Exception {
		Product product = null;
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "select * from Product where saleprice >= ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, salePriceMin);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);
		connection.close();
		return productList;

	}
	
	private List<Product> parseList(ResultSet resultSet) throws Exception{
		List<Product> productList = new ArrayList<>();
		while(resultSet.next()) {
			Product product = parse(resultSet);
			productList.add(product);
		}
		return productList;
	}
	
	private Product parse(ResultSet resultSet) throws Exception {
		long productId = resultSet.getLong("productId");
		String productName = resultSet.getString("productName");
		double salesPrice = resultSet.getDouble("salePrice");
		Product product = new Product(productId, productName, salesPrice);
		return product;
	}

}
