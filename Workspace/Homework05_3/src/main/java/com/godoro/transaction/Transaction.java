package com.godoro.transaction;

public class Transaction {
	private long id;
	private String name;
	private double amount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction(long id, String name, double amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	public Transaction() {
	}
	

}
