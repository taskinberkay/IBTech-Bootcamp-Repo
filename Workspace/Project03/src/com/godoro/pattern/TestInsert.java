package com.godoro.pattern;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		ProductManager pm = new ProductManager();
		Product product = new Product(0, "A", 10);
		System.out.println(pm.insert(product));
	}

}
