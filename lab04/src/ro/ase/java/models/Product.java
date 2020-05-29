package ro.ase.java.models;

public class Product implements Comparable<Product> {
	private String productName;
	private String category;
	private double price;
	
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

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		if(this.price == o.price) {
			return 0;
		} else if(this.price > o.price) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 37 * 37 * (int) this.price + this.productName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Product)) {
			return false;
		}
		Product p = (Product) obj;
		return this.productName.equals(p.productName) && 
				this.category.equals(p.category) && 
				this.price == p.price;
	}
	
	
}
