package HW_04_02;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeManager extends BaseManager<Employee> {

	public List<Employee> list() throws Exception {
		connect();
		String sql = "select * from Employee e join department d on e.departmentid = d.departmentid";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Employee> employeeList = parseList(resultSet);
		disconnect();
		return employeeList;
	}

	public Employee find(long employeeId) throws Exception {
		Employee employee = null;
		connect();
		String sql = "select * from Employee e join Department d on e.departmentid = d.departmentid where employeeid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, employeeId);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			employee = parse(resultSet);
			connection.close();
			return employee;
		}
		disconnect();
		return employee;

	}

	protected Employee parse(ResultSet resultSet) throws SQLException {
		long employeeId = resultSet.getLong("employeeId");
		String employeeName = resultSet.getString("employeeName");
		double monthlySalary = resultSet.getDouble("monthlySalary");
		Employee employee = new Employee(employeeId, employeeName, monthlySalary);
		employee.setDepartment(new Department(resultSet.getLong("departmentId"), resultSet.getString("departmentname")));
		return employee;
	}

}
