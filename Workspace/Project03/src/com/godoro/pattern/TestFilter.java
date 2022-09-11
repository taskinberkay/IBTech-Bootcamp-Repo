package com.godoro.pattern;

import java.util.List;

public class TestFilter {
	public static void main(String[] args) {
		ProductManager pm = new ProductManager();
		try {
			List<Product> productList = pm.filter(5000);
			for(Product product : productList) {
				System.out.println(product.getProductId() + "  " + product.getProductName()+ "  "  + product.getSalePrice());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
