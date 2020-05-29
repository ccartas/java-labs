package ro.ase.java.models;

public class Product {
	private String productName;
	private String category;
	private double price;
	
	public Product() {}
	public Product(String productName, String category, double price) {
		this.productName = productName;
		this.category = category;
		this.price = price;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getProductName() {
		return this.productName;
	}
	public String getCategory() {
		return this.category;
	}
	public double getPrice() {
		return this.price;
	}
}
