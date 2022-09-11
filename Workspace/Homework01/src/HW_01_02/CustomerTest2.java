package HW_01_02;

public class CustomerTest2 {
	public static void main(String[] args) {
		Customer customer = new Customer(501, "Neşet Ertaş", 4350);
		System.out.println("Müşteri ID'si: " + customer.getCustomerId() + "\n" + "Müşteri İsmi: " + customer.getCustomerName() + "\n" + "Harcama: " + customer.getTotalDebit());
	}

}
