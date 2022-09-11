package HW_04_01;

public class TestDelete {
	public static void main(String[] args) {
		CustomerManager pm = new CustomerManager();
		Customer customer = new Customer(0, "A", 100);
		try {
			System.out.println(pm.delete(customer));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
