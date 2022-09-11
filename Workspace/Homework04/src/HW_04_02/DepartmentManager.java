package HW_04_02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentManager extends BaseManager<Department>{
	protected Department parse(ResultSet resultSet) throws SQLException {
		long departmentId = resultSet.getLong("departmentId");
		String departmentName = resultSet.getString("departmentName");
		Department department = new Department(departmentId, departmentName);
		return department;
	}

}
