package HW_03_01;

public class Customer {
	private String customerName;
	private long customerId;
	private double totalDebit;

	public Customer() {

	}

	public Customer(long customerId, String customerName, double totalDebit) {
		this.customerName = customerName;
		this.customerId = customerId;
		this.totalDebit = totalDebit;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(double totalDebit) {
		this.totalDebit = totalDebit;
	}

}
