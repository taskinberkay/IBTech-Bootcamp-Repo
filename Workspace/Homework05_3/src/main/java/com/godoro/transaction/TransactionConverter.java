package com.godoro.transaction;


public class TransactionConverter {
	public final static String DELIMETER = ";";

	
	public String format(Transaction transaction) {
		StringBuilder builder = new StringBuilder();
		builder.append(transaction.getId()).append(DELIMETER);
		builder.append(transaction.getName()).append(DELIMETER);
		builder.append(transaction.getAmount());
		String line = builder.toString();
		return line;
		
	}
	public Transaction parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Transaction transaction = new Transaction();
		transaction.setId(Long.parseLong(tokens[0]));
		transaction.setName(tokens[1]);
		transaction.setAmount(Double.parseDouble(tokens[2]));
		return transaction;
	}

}
