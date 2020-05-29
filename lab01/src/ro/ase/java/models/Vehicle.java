package ro.ase.java.models;

public class Vehicle {
	private String make;
	private String model;
	private int cubicCapacity;
	private float weight;
	private boolean isElectric;
	private double price;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String make, String model,
				int capacity, 
				float weight,
				boolean isElectric,
				double price) {
		this.make = make;
		this.model = model;
		this.cubicCapacity = capacity;
		this.weight = weight;
		this.isElectric = isElectric;
		this.price = price;
	}

	public String getMake() {
		return this.make;
	}
	public String getModel() {
		return this.model;
	}
	public int getCubicCapacity() {
		return this.cubicCapacity;
	}
	public float getWeight() {
		return this.weight;
	}
	public boolean isElectricVehicle() {
		return this.isElectric;
	}
	public double getPrice() {
		return this.price;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setCubicCapacity(int capacity) {
		this.cubicCapacity = capacity;
	}
	public void setWeight(float weight) { 
		this.weight = weight;
	}
	public void isElectricVehicle(boolean isElectric) {
		this.isElectric = isElectric;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return this.make + " " +
				this.model + " " +
				this.cubicCapacity + " " +
				this.weight + " " +
				this.isElectric + " " + this.price;
	}
	
	
}
