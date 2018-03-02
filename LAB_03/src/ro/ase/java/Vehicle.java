package ro.ase.java;

public abstract class Vehicle {
	
	private VehicleType type;
	private int weight;
	
	public Vehicle() {
		
	}
	
	public Vehicle(VehicleType type, int weight) {
		this.type = type;
		this.weight = weight;
	}
	
	public String getVehicleType() {
		return this.type.getVehicleType();
	}
	public int getWeight() {
		return this.weight;
	}
	
	public String showDetails() {
		return this.type.getVehicleType() + " " + this.weight;
	}
}
