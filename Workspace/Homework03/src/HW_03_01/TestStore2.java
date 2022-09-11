package HW_03_01;

import java.util.ArrayList;
import java.util.List;

public class TestStore2 {
	public static void main(String[] args) {
		try {
			List<Customer> customerList = new ArrayList<>();
			customerList.add(new Customer(601, "Cem Kar", 6540));
			customerList.add(new Customer(602, "Cem Kara", 6543));
			customerList.add(new Customer(603, "Cem Karaca", 6542));
			String filePath = "..\\..\\IO\\Customer.txt";
			CustomerFiler customerFiler = new CustomerFiler(filePath);
			customerFiler.store(customerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
