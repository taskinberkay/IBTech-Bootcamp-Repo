package HW_04_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract public class BaseManager <E>{
	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "7534286";
	private String driver = "org.postgresql.Driver";
	protected Connection connection;

	public BaseManager() {
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
		if(connection!=null) {
			connection.close();
		}
	}
	
	protected List<E> parseList(ResultSet resultSet) throws Exception{
		List<E> entityList = new ArrayList<>();
		while(resultSet.next()) {
			E entity = parse(resultSet);
			entityList.add(entity);
		}
		return entityList;
	}
	protected abstract E parse(ResultSet resultSet) throws SQLException;
}
