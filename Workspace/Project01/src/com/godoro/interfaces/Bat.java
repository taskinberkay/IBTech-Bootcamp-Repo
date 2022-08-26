package com.godoro.interfaces;

public class Bat extends Mammal implements Flighted{

	public Bat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void fly() {
		System.out.println(name + " is in flight.");
	}
	public void land() {
		System.out.println(name + " has landed.");
	}

}
