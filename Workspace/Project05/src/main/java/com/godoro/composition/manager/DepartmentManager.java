package com.godoro.composition.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.godoro.composition.entity.Department;

public class DepartmentManager extends BaseManager<Department>{
	protected Department parse(ResultSet resultSet) throws SQLException {
		long departmentId = resultSet.getLong("departmentId");
		String departmentName = resultSet.getString("departmentName");
		Department department = new Department(departmentId, departmentName);
		return department;
	}

}
