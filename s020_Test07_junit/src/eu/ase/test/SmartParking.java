package eu.ase.test;

import java.util.List;

public class SmartParking {
	
	private int numberOfRows;
	private int numberOfColumns;
	private Vehicle[][] parkedVehicles;
	
	//private List<Vehicle> vehicles;
	
	public SmartParking() {
		
	}
	
	public SmartParking(int noRows, int noColumns) throws Exception {
		if (noRows < 0 || noColumns < 0)
			throw new Exception("Please insert a positive line or column number for the constructor.");
		
		this.numberOfRows = noRows;
		this.numberOfColumns = noColumns;
		
		this.parkedVehicles = new Vehicle[this.numberOfRows][this.numberOfColumns];
	}
	
	public void setNumberOfRows(int noRows) throws Exception {
		if(noRows < 0)
			throw new Exception("Please insert a positive value for the number of rows");
		this.numberOfRows = noRows;
	}
	public void setNumberOfColumns(int noColumns) throws Exception {
		if(noColumns < 0)
			throw new Exception("Please insert a positive value for the number of rows");
		this.numberOfColumns = noColumns;
	}
	public void setParkedVehicles(Vehicle[][] parkedVehicles) {
		this.parkedVehicles = parkedVehicles;
	}
	
	public int getNumberOfRows() {
		return this.numberOfRows;
	}
	public int getNumberOfColumns() {
		return this.numberOfColumns;
	}
	public Vehicle[][] getParkedVehicles(){
		return this.parkedVehicles;
	}
}
