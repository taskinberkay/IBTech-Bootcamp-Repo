package HW_02_05;

public class AccountTest {
	public static void main(String[] args) {
		AccountInput ac = new AccountInput();
		Account account = ac.getInput();
		System.out.println(ac.format(account));
		

	}
}
