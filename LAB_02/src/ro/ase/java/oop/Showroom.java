package ro.ase.java.oop;

public class Showroom {
	
	private String showroomName;
	private int numberOfCars;
	private long[] carPrices;
	
	
	public Showroom() {
		
	}
	
	public Showroom(String name, int noCars, long[] carPrices) {
		this.showroomName = name;
		this.numberOfCars = noCars;
		this.carPrices = new long[this.numberOfCars];
		for(int i=0; i<this.numberOfCars; i++) {
			this.carPrices[i] = carPrices[i];
		}
	}
	
	public void setShowroomName(String name) {
		this.showroomName = name;
	}
	
	public void setNumberOfCars(int noCars) {
		this.numberOfCars = noCars;
	}
	
	public void setCarPrices(long[] carPrices) {
		this.carPrices = new long[carPrices.length];
		for(int i=0; i < carPrices.length; i++) {
			this.carPrices[i] = carPrices[i];
		}
	}
	
	public String getShowroomName() {
		return this.showroomName;
	}
	
	public int getNumberOfCars() {
		return this.numberOfCars;
	}
	
	public long[] getCarPrices() {
		return this.carPrices;
	}
	
	public double getAveragePrice() {
		double result = 0.0d;
		for(int i=0; i<this.numberOfCars; i++) {
			result += this.carPrices[i];
		}
		result = result / this.numberOfCars;
		return result;
	}
}
