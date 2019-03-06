package ro.ase.java;

public class Product implements Cloneable{
	private String name;
	private double price;
	
	public Product() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public Product clone() {
		Product p = null;
		try {
			p = (Product) super.clone();
			p.setName(this.name);
			p.setPrice(this.price);
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return p;
	}
	
}
