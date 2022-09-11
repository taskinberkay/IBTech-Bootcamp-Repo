package HW_02_01;

public class Test {
	public static void main(String[] args) {
		Customer customer = new Customer(401, "Neşet", "Ertaş", 3450);
		customer.setEmailAdress("neset@godoro.com");
		
		Person person = new Customer(402, "Ahmet", "Akif", 3460);
		person.setEmailAdress("ahmet@godoro.com");

		
		Supplier supplier = new Supplier(701, "Orhan", "Gencebay", 8125);
		supplier.setEmailAdress("orhan@godoro.com");

		
		Employee employee = new Employee(201, "Erkan", "Ocaklı", 5470);
		employee.setEmailAdress("erkan@godoro.com");

		
		System.out.println(
		customer.getGreeting() + " " + customer.getFullName() + "\n" + 
		person.getGreeting() + " " + person.getFullName() + "\n" + 
		supplier.getGreeting() + " " + supplier.getFullName() + "\n" +
		employee.getGreeting() + "\n"
		);
		sendMail(customer);
		sendMail(employee);
	}
	public static void sendMail(Person person) {
		System.out.println("Kime: " + person.getEmailAdress());
		System.out.println("Konu: " + person.getGreeting());
		System.out.println("Gövde: " + person.getFullName()+"\n");
	}
}
