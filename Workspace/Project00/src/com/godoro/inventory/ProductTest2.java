package com.godoro.inventory;

public class ProductTest2 {
	public static void main(String[] args) {
	Product myProduct = new Product(11111, "Cep Telefonu", 5000);
	System.out.println(
			"Ürün ID'si: " + myProduct.getProductId() + "\n" +
			"Ürün ismi: " + myProduct.getProductName() + "\n" +
			"Ürün satış fiyatı: " + myProduct.getSalesPrice()
	);
	}
}
