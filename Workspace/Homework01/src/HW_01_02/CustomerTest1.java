package HW_01_02;

public class CustomerTest1 {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setCustomerId(501);
		customer.setCustomerName("Neşet Ertaş");
		customer.setTotalDebit(4350);
		System.out.println("Müşteri ID'si: " + customer.getCustomerId() + "\n" + "Müşteri İsmi: " + customer.getCustomerName() + "\n" + "Harcama: " + customer.getTotalDebit());
	}
	

}
