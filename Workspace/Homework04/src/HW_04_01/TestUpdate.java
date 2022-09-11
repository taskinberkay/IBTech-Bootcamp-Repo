package HW_04_01;

public class TestUpdate {
	public static void main(String[] args) {
		CustomerManager pm = new CustomerManager();
		Customer customer = new Customer(1, "A", 5600);
		try {
			System.out.println(pm.update(customer));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
