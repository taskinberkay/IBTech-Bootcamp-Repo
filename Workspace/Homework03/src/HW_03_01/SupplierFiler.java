package HW_03_01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class SupplierFiler extends BaseFiler<Supplier>{
	public final static String DELIMETER = ";";

	protected String format(Supplier supplier) {
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

	protected Supplier parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Supplier supplier = new Supplier();
		supplier.setSupplierId(Long.parseLong(tokens[0]));
		supplier.setSupplierName(tokens[1]);
		supplier.setTotalCredit(Double.parseDouble(tokens[2]));
		return supplier;
	}

	
	

	public SupplierFiler(String filePath) {
		super(filePath);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
