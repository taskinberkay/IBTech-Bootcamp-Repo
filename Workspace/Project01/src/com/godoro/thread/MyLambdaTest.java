package com.godoro.thread;

public class MyLambdaTest {
	public static void main(String[] args) {
		new Thread(() -> walk())
		.start();
		process();
	}

	private static void process() {
		while (true) {
			try {
				System.out.println("Running...");
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private static void walk() {
		while(true) {
			try {
				System.out.println("Continuing...");
				Thread.sleep(750);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
}
