package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "7534286";
	private String driver = "org.postgresql.Driver";
	protected Connection connection;

	public UserManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void connect() throws SQLException {
		connection = DriverManager.getConnection(url, user, password);
	}

	protected void disconnect() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public boolean insertUser(String username, String password) throws SQLException {
		connect();
		String sql = "insert into Users(username,password) values (?, ?) ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		int affected = statement.executeUpdate();
		if (affected > 0) {
			connection.close();
			disconnect();
			return true;
		}
		connection.close();
		disconnect();
		return false;

	}

	public User find(String username, String password) throws Exception {
		User user = null;
		connect();
		String sql = "select * from users where username = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			user = parse(resultSet);
			connection.close();
			return user;
		}
		connection.close();
		disconnect();
		return user;

	}

	protected User parse(ResultSet resultSet) throws SQLException {
		long userId = resultSet.getLong("userId");
		String userName = resultSet.getString("username");
		String password = resultSet.getString("password");
		User user = new User(userId, userName, password);
		return user;
	}

}
