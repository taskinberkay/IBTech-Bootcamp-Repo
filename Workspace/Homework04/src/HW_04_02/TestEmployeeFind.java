package HW_04_02;

import java.util.List;

public class TestEmployeeFind {
	public static void main(String[] args) throws Exception {
		EmployeeManager em = new EmployeeManager();
		Employee employee = em.find(3);
		System.out.println(employee.getEmployeeId() + "; " + employee.getEmployeeName() + "; "
				+ employee.getMonthlySalary() + "; " + employee.getDepartment().getDepartmentId() + "; "
				+ employee.getDepartment().getDepartmentName());

	}
}
