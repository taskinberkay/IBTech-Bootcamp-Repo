package HW_02_05;

import java.util.Scanner;

public class AccountInput {
	public Account getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Id giriniz: ");
		long accountId = scanner.nextLong();
		System.out.println("Hesap ismi giriniz: ");
		String accountName = scanner.next();
		System.out.println("Hesap miktarı giriniz: ");
		double totalAmount = scanner.nextDouble();
		scanner.close();
		Account account = new Account(accountId, accountName, totalAmount);
		return account;
	}
	public String format(Account account) {
		StringBuilder builder = new StringBuilder();
		builder.append(account.getAccountId()).append("; ");
		builder.append(account.getAccountName()).append("; ");
		builder.append(account.getAmountLocal());
		return builder.toString();
	}
}
