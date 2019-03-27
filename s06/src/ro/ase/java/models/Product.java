package ro.ase.java.models;

public class Product {
	private String productName;
	private String category;
	private double price;
	
	public Product(){
		
	}
	public void setProductName(String name) {
		this.productName = name;
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
