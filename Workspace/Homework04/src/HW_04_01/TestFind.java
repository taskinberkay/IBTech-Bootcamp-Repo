package HW_04_01;

public class TestFind {
	public static void main(String[] args) {
		CustomerManager pm = new CustomerManager();
		try {
			Customer customer = pm.find(3);
			System.out.println(customer.getCustomerId() + "  " + customer.getCustomerName()+ "  "  + customer.getTotalDebit());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
