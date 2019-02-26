package ro.ase.java.models;

public class Vehicle {
	private String make;
	private String model;
	private int cubicCapacity;
	private float weight;
	private double price;
	private boolean electricVehicle;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String make,
			String model,
			int cubicCapacity,
			float weight,
			double price,
			boolean electricVehicle) {
		this.make = make;
		this.model = model;
		this.cubicCapacity = cubicCapacity;
		this.weight = weight;
		this.price = price;
		this.electricVehicle = electricVehicle;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setCubicCapacity(int cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void isElectricVehicle(boolean isElectric) {
		this.electricVehicle = isElectric;
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
	public double getPrice() {
		return this.price;
	}
	public boolean getIsElectricVehicle() {
		return this.electricVehicle;
	}
	
	public void applyDiscount(double amount) {
		this.price = this.price - amount;
	}
	
	public String toString() {
		return this.make + " " +
					this.model + " " +
					this.cubicCapacity + " " +
					this.weight + " " +
					this.price + " " +
					this.electricVehicle; 
	}
	
}
