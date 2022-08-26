package com.godoro.thread;

public class MyRunnable implements Runnable{
	public void run() {
		while(true) {
			try {
				System.out.println("Running...");
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
