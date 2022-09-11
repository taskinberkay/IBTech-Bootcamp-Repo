package HW_03_02;

public class SupplierFiler extends BaseFiler<Supplier> {
	public final static String DELIMETER = ";";

	protected String format(Supplier supplier) {
		StringBuilder builder = new StringBuilder();
		builder.append(supplier.getSupplierId()).append(DELIMETER);
		builder.append(supplier.getSupplierName()).append(DELIMETER);
		builder.append(supplier.getTotalCredit());
		String line = builder.toString();
		return line;
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
