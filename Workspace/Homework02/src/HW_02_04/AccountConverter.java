package HW_02_04;

public class AccountConverter {
	public Object[] parse(String line) {
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
		return attributes;
	}
	public String format(Account account) {
		StringBuilder builder = new StringBuilder();
		builder.append(account.getAccountId()).append("; ");
		builder.append(account.getAccountName()).append("; ");
		builder.append(account.getAmountLocal());
		return builder.toString();
	}
}
