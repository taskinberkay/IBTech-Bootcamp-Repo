package com.godoro.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestRelationList {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:postgresql://localhost/dbgodoro";
		String user = "postgres";
		String password = "7534286";
		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "select * from employee e \r\n"
				+ "left join department d on e.departmentid = d.departmentid";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			long employeeId = resultSet.getLong("employeeId");
			String employeeName = resultSet.getString("employeeName");
			double monthlySalary = resultSet.getDouble("monthlySalary");
			System.out.println(
					employeeId + " " +
							employeeName + " " +
							monthlySalary);
		}
		connection.close();

	}

}
