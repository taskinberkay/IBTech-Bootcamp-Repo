package HW_04_01;

import java.util.List;

public class TestFilter {
	public static void main(String[] args) {
		CustomerManager pm = new CustomerManager();
		try {
			List<Customer> customerList = pm.filter(5003);
			for(Customer customer : customerList) {
				System.out.println(customer.getCustomerId() + "  " + customer.getCustomerName()+ "  "  + customer.getTotalDebit());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
