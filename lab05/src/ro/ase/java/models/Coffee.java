package ro.ase.java.models;

import java.io.Serializable;

public class Coffee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7278204448927055545L;
	
	private String beverageName;
	private String coffeeType;
	double price;
	
	public Coffee() {}
	public Coffee(String beverageName, String coffeeType, double price) {
		this.beverageName = beverageName;
		this.coffeeType = coffeeType;
		this.price = price;
	}
	
	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}
	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
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
}
