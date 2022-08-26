package com.godoro.pattern;

import java.util.List;

public class TestList {
	public static void main(String[] args) {
		ProductManager pm = new ProductManager();
		try {
			List<Product> productList = pm.list();
			for(Product product : productList) {
				System.out.println(product.getProductId() + "  " + product.getProductName()+ "  "  + product.getSalePrice());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
