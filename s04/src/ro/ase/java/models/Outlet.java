package ro.ase.java.models;

import java.util.ArrayList;
import java.util.List;

public class Outlet {
	private String location;
	private List<ClothingItem> items;
	
	
	public Outlet(String location) {
		this.location = location;
		//this.items = new ArrayList<ClothingItem>();
	}
	
	public List<ClothingItem> getItems(){
		return this.items;
	}
	
	public void addProduct(ClothingItem item) {
		this.items.add(item);
	}
}
