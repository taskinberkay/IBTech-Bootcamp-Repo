package com.godoro.inventory;

public class Product {
	private long productId;
	private String ProductName;
	private double salesPrice;
	
	
	
	public Product(long productId, String productName, double salesPrice) {
		this.productId = productId;
		this.ProductName = productName;
		this.salesPrice = salesPrice;
	}

	Product(){
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public long getProductId() {
		return productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
}
