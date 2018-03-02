package ro.ase.java;

public class Car extends Vehicle implements Transmission{
	
	private int maximumSpeed;
	
	public Car() {
		super();
	}
	
	public Car(VehicleType type, int weight, int maxSpeed) {
		super(type, weight);
		this.maximumSpeed = maxSpeed;
	}
	
	public void setMaximumSpeed(int speed) {
		this.maximumSpeed = speed;
	}
	
	public int getMaximumSpeed() {
		return this.maximumSpeed;
	}
	
	@Override
	public String showDetails() {
		return super.getVehicleType() + " " + super.getWeight() + " " + this.maximumSpeed;
	}
	
	@Override
	public boolean hasIntegralTransmission() {
		// TODO Auto-generated method stub
		return false;
	}
}
