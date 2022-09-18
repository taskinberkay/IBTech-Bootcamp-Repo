package com.godoro.composition.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.godoro.composition.entity.Category;

public class PlayerManager extends BaseManager<Category> {
	
	public List<Category> list() throws Exception {
		String sql = "select * from Employee";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Category> playerList = parseList(resultSet);
		return playerList;
	}
	
	public Category find(long playerId) throws Exception {
		Category player = null;
		connect();
		String sql = "select * from Player where playerid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, playerId);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			player=parse(resultSet);
			connection.close();
			return player;
		}
		disconnect();
		return player;

	}
	
	protected Category parse(ResultSet resultSet) throws SQLException {
		long playerId = resultSet.getLong("playerId");
		String employeeName = resultSet.getString("playerName");
		double monthlySalary = resultSet.getDouble("score");
		Category player = new Category(playerId, employeeName, monthlySalary);
		return player;
	}
	
	
	
}
