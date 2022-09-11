package HW_04_01;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		CustomerManager pm = new CustomerManager();
		Customer customer = new Customer(0, "E", 5005);
		System.out.println(pm.insert(customer));
	}

}
