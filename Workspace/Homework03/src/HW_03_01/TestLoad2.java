package HW_03_01;

import java.util.ArrayList;
import java.util.List;

public class TestLoad2 {
	public static void main(String[] args) {
		try {
			String filePath = "..\\..\\IO\\Customer.txt";
			CustomerFiler customerFiler = new CustomerFiler(filePath);
			List<Customer> customerList = new ArrayList<>();
			customerList = customerFiler.load();
			for(Customer customer : customerList) {
				System.out.println(customer.getCustomerId()+"; "+customer.getCustomerName()+"; "+customer.getTotalDebit()+";");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
