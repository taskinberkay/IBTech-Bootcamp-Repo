package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionTest {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:postgresql://localhost/dbgodoro";
		String user = "postgres";
		String password = "7534286";
		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		
		String sql = "insert into Product(productName,salePrice) values (?,?)";
		
		PreparedStatement statement1 = connection.prepareStatement(sql);
		statement1.setString(1, "Şarj Aleti");
		statement1.setDouble(2, 150);
		int affected1 = statement1.executeUpdate();
		
		PreparedStatement statement2 = connection.prepareStatement(sql);
		statement2.setString(1, "Hızlı Şarj Aleti");
		statement2.setDouble(2, 200);
		int affected2 = statement2.executeUpdate();
		
		PreparedStatement statement3 = connection.prepareStatement(sql);
		statement3.setString(1, "Kablosuz Şarj Aleti");
		statement3.setDouble(2, 500);
		int affected3 = statement3.executeUpdate();
		
		connection.commit();
		
		
		
		connection.close();
		System.out.println("Etkilenmiş 1" + affected1 + "\n" + "Etkilenmiş 2" + affected2 + "\n" + "Etkilenmiş 3" + affected3);

	}

}
