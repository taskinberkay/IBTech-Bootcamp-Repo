package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestDelete {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:postgresql://localhost/dbgodoro";
		String user = "postgres";
		String password = "7534286";
		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "delete from Product where productId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, 2);
		int affected = statement.executeUpdate();
		connection.close();
		System.out.println("Etkilenmiş: " + affected);

	}
}
