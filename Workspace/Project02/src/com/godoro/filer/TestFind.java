package com.godoro.filer;

import java.util.ArrayList;
import java.util.List;

public class TestFind {
	private static Supplier find(List<Supplier> supplierList, long supplierId) {
		for(Supplier supplier : supplierList) {
			if(supplier.getSupplierId() == supplierId) {
				return supplier;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		List<Supplier> supplierList = new ArrayList<>();
		supplierList.add(new Supplier(601, "Cem Kar", 6540));
		supplierList.add(new Supplier(602, "Cem Kara", 6541));
		supplierList.add(new Supplier(603, "Cem Karaca", 6542));
		long supplierId=601;
		Supplier supplier = find(supplierList, supplierId);
		if(supplier!=null) {
			System.out.println(supplier.getSupplierId()+ " " + 
		supplier.getSupplierName()+ " " + 
		supplier.getTotalCredit()+ " ");
		}else {
			System.out.println("Satımcı Bulunamadı!");
		}
	}
}
