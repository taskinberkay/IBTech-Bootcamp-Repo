package com.godoro.filer;

import java.util.ArrayList;
import java.util.List;

public class TestStore {
	public static void main(String[] args) {
		try {
			List<Supplier> supplierList = new ArrayList<>();
			supplierList.add(new Supplier(601, "Cem Kar", 6540));
			supplierList.add(new Supplier(602, "Cem Kara", 6543));
			supplierList.add(new Supplier(603, "Cem Karaca", 6542));
			
			String filePath = "C:\\Users\\BERKAY\\OneDrive\\Belgeler\\Bootcamp\\IBTech-Bootcamp-Repo\\IO\\Supplier.txt";
			SupplierFiler supplierFiler = new SupplierFiler(filePath);
			supplierFiler.store(supplierList, filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
