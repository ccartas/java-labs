package ro.ase.java;

public class ElectricCar extends Vehicle implements Transmission {
	
	private int numberOfBateries;
	
	public ElectricCar() {
		super();
	}
	
	public ElectricCar(VehicleType type, int weight, int noBateries) {
		super(type,weight);
		this.numberOfBateries = noBateries;
	}
	
	public void setNumberOfBateries(int numberOfBateries) {
		this.numberOfBateries = numberOfBateries;
	}
	
	public int getNumberOfBateries() {
		return this.numberOfBateries;
	}
	
	@Override
	public String showDetails() {
		return super.getVehicleType() + " " + super.getWeight() + " " + this.numberOfBateries;
	}
	
	@Override
	public boolean hasIntegralTransmission() {
		// TODO Auto-generated method stub
		return true;
	}
}
