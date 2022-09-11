package com.godoro.pattern;

public class TestUpdate {
	public static void main(String[] args) {
		ProductManager pm = new ProductManager();
		Product product = new Product(15, "A", 100);
		try {
			System.out.println(pm.update(product));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
