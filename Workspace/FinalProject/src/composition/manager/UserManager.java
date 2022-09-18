package composition.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import composition.entities.User;

public class UserManager extends BaseManager<User> {

	public UserManager(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public User userLogin(String username, String password) {
		User user = null;
		try {
			String query = "select * from users where username=? and password=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				user = parse(rs);
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		return user;
	}

	public boolean register(User user) {
		String sql = "insert into users (username, password) values(?,?)";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			int affected = statement.executeUpdate();
			return affected > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	protected User parse(ResultSet rs) {
		User user = new User();
		try {
			user.setId(rs.getInt("userid"));
			user.setName(rs.getString("username"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;

	}

}
