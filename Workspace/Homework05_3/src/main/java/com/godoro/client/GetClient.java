package com.godoro.client;
import static com.godoro.utils.StreamUtils.get;
import com.godoro.transaction.Transaction;
import com.godoro.transaction.TransactionConverter;

public class GetClient {
	public static void main(String[] args) throws Exception {
		String address = "http://localhost:8080/Homework05_3/get";
		String text = get(address);
		System.out.println("İçerik: ");
		System.out.println(text);
		
		Transaction transaction = new TransactionConverter().parse(text);
		System.out.println(transaction.getName()); // Parse Test
		
	}
}
