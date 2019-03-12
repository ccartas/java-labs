package ro.ase.java.models;

public class ClothingItem implements Comparable<ClothingItem>{
	private String brand;
	private ClothesType type;
	private ClothesSize size;
	private double price;
	
	public ClothingItem() {
		
	}
	
	public ClothingItem(String brand,
					ClothesType type,
					ClothesSize size,
					double price) {
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.price = price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setType(ClothesType type) {
		this.type = type;
	}
	public void setSize(ClothesSize size) {
		this.size = size;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	@Override
	public int compareTo(ClothingItem o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
