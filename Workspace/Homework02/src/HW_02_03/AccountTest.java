package HW_02_03;

public class AccountTest {
	public static void main(String[] args) {
		String line = "601;Kasa Hesabi;2360";
		int i = 0;
		Object[] attributes = new Object[3];
		for (String token : line.split(";")) {
			System.out.println(token);
			if (i % 3 == 0) {
				attributes[i] = Long.parseLong(token);
			} else if (i % 3 == 1) {
				attributes[i] = token;
			} else if (i % 3 == 2) {
				attributes[i] = Double.parseDouble(token);
			}
			i++;

		}
		StringBuilder builder = new StringBuilder();
		Account account = new Account((long)attributes[0], (String)attributes[1], (double)attributes[2]);
		builder.append(account.getAccountId()).append("; ");
		builder.append(account.getAccountName()).append("; ");
		builder.append(account.getAmountLocal());
		System.out.println(builder.toString());
		

	}
}
