package composition.entities;

public class Product {
	private long productId;
	private String productName;
	private long categoryid;
	private Double salesPrice;
	private String imgPath;
	
	
	public Product() {
	}

	
	public Product(long id, String name, Double price, long categoryid, String imgPath) {
		super();
		this.productId = id;
		this.productName = name;
		this.categoryid = categoryid;
		this.salesPrice = price;
		this.imgPath = imgPath;
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long id) {
		this.productId = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String name) {
		this.productName = name;
	}

	public long getCategoryId() {
		return categoryid;
	}

	public void setCategoryId(long categoryid) {
		this.categoryid = categoryid;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double price) {
		this.salesPrice = price;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String image) {
		this.imgPath = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + productId + ", name=" + productName + ", category=" + categoryid + ", price=" + salesPrice + ", image="
				+ imgPath + "]";
	}
	
	
}
