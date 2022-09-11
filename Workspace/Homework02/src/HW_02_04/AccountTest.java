package HW_02_04;

public class AccountTest {
	public static void main(String[] args) {
		String line = "601;Kasa Hesabi;2360";
		AccountConverter ac = new AccountConverter();
		Object[] attributes = ac.parse(line);
		Account account = new Account((long)attributes[0], (String)attributes[1], (double)attributes[2]);
		System.out.println(ac.format(account));
		

	}
}
