package eu.ase.test;

import java.io.Serializable;

/*
 * Grade 3: Create the class ElectricVehicle which extends Vehicle implements Cloneable and Comparable<ElectricVehicle> interfaces.
 * 
 * Besides the fields and methods inherited from the class Vehicle, the class ElectricVehicle has the following private fields:
 * bateryCapacity : int for the capacity of the batery available in the car;
 * serialVersionUID : static long
 * 
 * Create the constructor method with 6 parameters: 
 * "make" of type String, "model" of type String, "plateNumber" of type String, "horsePower" of type int, "parkingDuration" of type float and "bateryCapacity" of type int;
 * The constructor should throw an Exception if the plate number (plateNumber) length is less than 6;
 * 
 * Implement proper get/set method(s) and override equals method:
 * public method equals(Object o) which returns boolean
 * 
 * The setBateryCapacity method must throw an exception if the value is less equal than 0.
 * 
 * Implement consistently the clone method for creating deep copy of the current object:
 * public clone() which return Object and may throw CloneNotSupportedException
 * 
 * Override the methods from Comparable (compareTo() -> returns int and it compares ElectricVehicles in terms of bateryCapacity)
 * 
 * Override method getAbstractBookingId() which returns a String which represents the concatenation of the inherited value
 * for the bookingId and vipCardNo filed value
 */

public class ElectricVehicle extends Vehicle implements Cloneable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int bateryCapacity;
	
	public ElectricVehicle(String make, String model, String plateNumber, int horsePower, float parkingDuration, int bateryCapacity) throws Exception {
		super(make, model, plateNumber, horsePower, parkingDuration);
		if(bateryCapacity <= 0)
			throw new Exception("Batery capacity should be greater than 0.");
		this.bateryCapacity = bateryCapacity;
	}

	public void setBateryCapacity(int bateryCapacity) throws Exception {
		if(bateryCapacity <= 0)
			throw new Exception("Batery capacity should be greater than 0.");
		this.bateryCapacity = bateryCapacity;
	}
	
	public int getBateryCapacity() {
		return this.bateryCapacity;
	}
	
	@Override
	public ElectricVehicle clone() throws CloneNotSupportedException {
		ElectricVehicle newObj = (ElectricVehicle) super.clone();
		newObj.bateryCapacity = this.bateryCapacity;
		return newObj;
	}
	
	public boolean equals(Object o) {
		ElectricVehicle obj = null;
		if(!(o instanceof ElectricVehicle))
			return false;
		obj = (ElectricVehicle) o;
		return (obj.getMake().equals(this.getMake()) &&
				obj.getModel().equals(this.getModel()) &&
				obj.getPlateNumber().equals(this.getPlateNumber()) &&
				obj.bateryCapacity == this.bateryCapacity);
	}
}
