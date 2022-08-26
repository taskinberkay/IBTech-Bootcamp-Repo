package com.godoro.thread;

public class MyInnerTest {
	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable() {
			public void run() {
				walk();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
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
