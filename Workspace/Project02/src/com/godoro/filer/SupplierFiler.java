package com.godoro.filer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SupplierFiler {
	private String filePath;
	public final static String DELIMETER = ";";

	public SupplierFiler(String filePath) {
		this.filePath = filePath;
	}

	private String format(Supplier supplier) {
		StringBuilder builder = new StringBuilder();
		builder.append(supplier.getSupplierId()).append(DELIMETER);
		builder.append(supplier.getSupplierName()).append(DELIMETER);
		builder.append(supplier.getTotalCredit());
		String line = builder.toString();
		return line;
	}

	void store(List<Supplier> supplierList, String filePath) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		for (Supplier supplier : supplierList) {
			String line = format(supplier);
			bw.write(line);
			bw.write("\r\n");
		}
		bw.close();
	}

	private Supplier parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Supplier supplier = new Supplier();
		supplier.setSupplierId(Long.parseLong(tokens[0]));
		supplier.setSupplierName(tokens[1]);
		supplier.setTotalCredit(Double.parseDouble(tokens[2]));
		return supplier;
	}

	public List<Supplier> load(String filePath) {
		List<Supplier> supplierList;
		try {
			supplierList = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return supplierList;

	}

}
