package composition.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract public class BaseManager<E> {

	protected Connection connection;

	public BaseManager(Connection connection) {
		this.connection = connection;
	}

	protected void disconnect() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	protected List<E> parseList(ResultSet resultSet) throws Exception {
		List<E> entityList = new ArrayList<>();
		while (resultSet.next()) {
			E entity = parse(resultSet);
			entityList.add(entity);
		}
		return entityList;
	}

	protected abstract E parse(ResultSet resultSet) throws SQLException;
}
