package com.godoro.interfaces;

abstract public class Bird extends Animal implements Flighted{

	public Bird(String name){
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void fly() {
		System.out.println(name + " is in Flight");
	}
	public void land() {
		System.out.println(name + " has landed");
	}

}
