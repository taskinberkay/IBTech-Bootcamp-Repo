package com.godoro.pattern;

public class TestFind {
	public static void main(String[] args) {
		ProductManager pm = new ProductManager();
		try {
			Product product = pm.find(3);
			System.out.println(product.getProductId() + "  " + product.getProductName()+ "  "  + product.getSalePrice());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
