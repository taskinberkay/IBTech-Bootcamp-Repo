package composition.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import composition.entities.Category;

public class CategoryManager extends BaseManager<Category> {
	
	public CategoryManager(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public List<Category> list() throws Exception {
		String sql = "select * from Categories";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Category> categoryList = parseList(resultSet);
		return categoryList;
	}
	
	public boolean insert(Category category) throws Exception {
		String sql = "insert into categories(categoryname) values (?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, category.getCategoryName());
		int affected = statement.executeUpdate();
		System.out.println("Etkileniş: " + affected);
		return affected > 0;
	}
	
	protected Category parse(ResultSet resultSet) throws SQLException {
		long categoryId = resultSet.getLong("categoryId");
		String categoryName = resultSet.getString("categoryName");
		Category category = new Category(categoryId, categoryName);
		return category;
	}
	
}
