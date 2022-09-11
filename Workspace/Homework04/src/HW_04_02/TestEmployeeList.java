package HW_04_02;

import java.util.List;

public class TestEmployeeList {
	public static void main(String[] args) throws Exception {
		EmployeeManager em = new EmployeeManager();
		List<Employee> employeeList = em.list();
		for(Employee employee: employeeList) {
			System.out.println(
					employee.getEmployeeId()+"; "+
					employee.getEmployeeName()+"; "+
					employee.getMonthlySalary()+"; "+
					employee.getDepartment().getDepartmentId()+"; "+
					employee.getDepartment().getDepartmentName());
		}
		
	}
}
