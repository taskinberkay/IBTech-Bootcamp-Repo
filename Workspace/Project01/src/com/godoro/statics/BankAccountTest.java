package com.godoro.statics;

public class BankAccountTest {
	public static void main(String[] args) {
		
		BankAccount myAccount = new BankAccount(1000);
		BankAccount myAccount1 = new BankAccount(5000);
		
		System.out.println(myAccount.getRate());
		System.out.println(myAccount1.getRate());
		
		myAccount.setRate(10);
		
		System.out.println(myAccount.getRate());
		System.out.println(myAccount1.getRate());
		
		System.out.println(myAccount.getRate());
		System.out.println(myAccount.getRate());
		
		System.out.println(myAccount.getAmount(12));
		System.out.println(myAccount1.getAmount(12));
	}
}
