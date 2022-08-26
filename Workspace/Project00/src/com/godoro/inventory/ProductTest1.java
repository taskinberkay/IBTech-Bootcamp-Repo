package com.godoro.inventory;

public class ProductTest1 {
	public static void main(String[] args) {
	Product myProduct = new Product();
	myProduct.setProductId(11111);
	myProduct.setProductName("Cep Telefonu");
	myProduct.setSalesPrice(5000);
	System.out.println(
			"Ürün ID'si: " + myProduct.getProductId() + "\n" +
			"Ürün ismi: " + myProduct.getProductName() + "\n" +
			"Ürün satış fiyatı: " + myProduct.getSalesPrice()
	);
	}
}
