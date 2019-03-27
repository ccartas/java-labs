package ro.ase.java.collections;

import java.io.Serializable;

public class Coffee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private String beverageName;
	private String coffeeType;
	private double price;
	
	public Coffee() {
		
	}
	
	public Coffee(String name, String type, double price) {
		this.beverageName = name;
		this.coffeeType = type;
		this.price = price;
	}
	
	public void setBeverageName(String name) {
		this.beverageName = name;
	}
	public void setCoffeeType(String type) {
		this.coffeeType = type;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getBeverageName() {
		return this.beverageName;
	}
	
	public String getCoffeeType() {
		return this.coffeeType;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Coffee))
			return false;
		Coffee c = (Coffee) o;
		return c.getBeverageName().equals(this.beverageName);
	}
	
	@Override
	public int hashCode() {
		return 31*31+31 * this.beverageName.hashCode() + (int) this.price;
	}
}
