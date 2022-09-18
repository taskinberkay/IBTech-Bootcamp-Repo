package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static String url = "jdbc:postgresql://localhost/dbgodoro";
	private static String user = "postgres";
	private static String password = "7534286";
	private static String driver = "org.postgresql.Driver";
	private static Connection connection = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			System.out.print("connected");
		}
		return connection;
	}
}
