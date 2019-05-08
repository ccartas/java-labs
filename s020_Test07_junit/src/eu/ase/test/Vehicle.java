package eu.ase.test;
/*
 * Grade 2: 
 * Create the class Vehicle which implements Cloneable and java.io.Serializable interfaces.
 * 
 * The class has the following private fields:
 * make : String which is the make of the vehicle;
 * model : String for the model of the car;
 * plateNumber : String representing the plate number of the car;
 * horsePower : int representing the horse power of the engine;
 * parkingDuration: float representing the duration of parking in hours;
 * 
 * serialVersionUID : static long
 * 
 * Create the constructor method without parameters and the one with 5 parameters: 
 * The constructor with parameters should throw an Exception if the plate number (plateNumber) length is less than 6 characters; 
 * 
 * Create the private, static and final field className : String with the value "eu.ase.test.Vehicle" 
 * and associated public, static get method (getClassName)
 * 
 * Implement proper get/set methods
 * 
 * Implement consistently the clone method for creating deep copy of the current object:
 * public clone() which return Object and may throw CloneNotSupportedException
 * 
 * 
 * Declare public abstract method getAbstractBookingId which has no parameter and returns -> String.
 */

import java.io.Serializable;


public class Vehicle implements Cloneable, Serializable, Comparable<Vehicle>{

	private static final long serialVersionUID = 1L;
	
	private String make;
	private String model;
	private String plateNumber;
	private int horsePower;
	private float parkingDuration;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String make, String model, String plateNumber, int horsePower, float parkingDuration) throws Exception {
		if(plateNumber.length() < 6)
			throw new Exception("Plate number should have at least 6 characters.");
		this.make = make;
		this.model = model;
		this.plateNumber = plateNumber;
		this.horsePower = horsePower;
		this.parkingDuration = parkingDuration;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	public void setParkingDuration(float parkingDuration) {
		this.parkingDuration = parkingDuration;
	}
	
	public String getMake() {
		return this.make;
	}
	public String getModel() {
		return this.model;
	}
	public String getPlateNumber() {
		return this.plateNumber;
	}
	public int getHorsePower() {
		return this.horsePower;
	}
	public float getParkingDuration() {
		return this.parkingDuration;
	}
	
	
	@Override
	public Vehicle clone() throws CloneNotSupportedException {
		Vehicle newObj = (Vehicle) super.clone();
		newObj.make = new String(this.make);
		newObj.model = new String(this.model);
		newObj.plateNumber = new String(this.plateNumber);
		newObj.horsePower = this.horsePower;
		newObj.parkingDuration = this.parkingDuration;
		return newObj;
	}

	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		return Float.compare(this.parkingDuration, o.parkingDuration);
	}
}
