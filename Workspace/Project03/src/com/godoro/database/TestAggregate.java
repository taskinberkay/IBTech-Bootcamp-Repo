package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestAggregate {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:postgresql://localhost/dbgodoro";
		String user = "postgres";
		String password = "7534286";
		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "select * from Product where productId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, 3);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			long productId = resultSet.getLong("productId");
			String productName = resultSet.getString("productName");
			long salePrice = resultSet.getLong("salePrice");
			System.out.println(
					productId + " " +
					productName + " " +
					salePrice);
		}
		connection.close();

	}
}
