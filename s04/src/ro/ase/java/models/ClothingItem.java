package ro.ase.java.models;

public class ClothingItem implements Comparable<ClothingItem>, Cloneable{
	private String brand;
	private String type;
	private String size;
	private double price;
	
	public ClothingItem() {
		
	}
	
	public ClothingItem(String brand,
					String type,
					String size,
					double price) {
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.price = price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		ClothingItem item = (ClothingItem) super.clone();
		if(this.brand != null) item.brand = this.brand;
		if(this.size != null) item.size = this.size;
		if(this.type != null) item.type = this.type;
		item.price = this.price;
		return item;
	}
	
	@Override
	public int compareTo(ClothingItem o) {
		// TODO Auto-generated method stub
		if (this.price == o.price)
			return 0;
		else if (this.price > o.price)
			return 1;
		else 
			return -1;
	}
	
	@Override
	public int hashCode() {
		return 37 * 37 * (int) this.price * this.brand.hashCode(); 
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(!(o instanceof ClothingItem))
			return false;
		ClothingItem item = (ClothingItem) o;
		return item.brand.equals(this.brand) && 
				item.size.equals(this.size) &&
				item.type.equals(this.type) &&
				item.price == this.price;
	}
	
	@Override
	public String toString() {
		return this.brand + " " + this.type + " " + this.size + " " + this.price;
	}
}
