package HW_03_01;

import java.util.ArrayList;
import java.util.List;

public class TestLoad {
	public static void main(String[] args) {
		try {
			String filePath = "..\\..\\IO\\Supplier.txt";
			SupplierFiler supplierFiler = new SupplierFiler(filePath);
			List<Supplier> supplierList = new ArrayList<>();
			supplierList = supplierFiler.load();
			for(Supplier supplier : supplierList) {
				System.out.println(supplier.getSupplierId()+"; "+supplier.getSupplierName()+"; "+supplier.getTotalCredit()+";");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
