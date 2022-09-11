package HW_04_01;

import java.util.List;

public class TestList {
	public static void main(String[] args) {
		CustomerManager pm = new CustomerManager();
		try {
			List<Customer> customerList = pm.list();
			for(Customer customer : customerList) {
				System.out.println(customer.getCustomerId() + "  " + customer.getCustomerName()+ "  "  + customer.getTotalDebit());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
