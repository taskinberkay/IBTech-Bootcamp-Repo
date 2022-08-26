package com.godoro.statics;

public class BankAccount {
	
	public final static int MONTHS_IN_A_YEAR = 12;
	private double investment;
	private static double rate;
	
	
	
	public BankAccount(double investment) {
		this.investment = investment;
	}

	public double getAmount(int month) {
		return investment*(1+month*rate/(MONTHS_IN_A_YEAR*100));
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		BankAccount.rate = rate;
	}
	
	
}
