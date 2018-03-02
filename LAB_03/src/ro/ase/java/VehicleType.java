package ro.ase.java;

public enum VehicleType {
	
	NORMAL("NORMAL"), ELECTRIC("ELECTRIC");
	
	private String type;
	
	private VehicleType(String type) {
		this.type = type;
	}
	
	public String getVehicleType() {
		return this.type;
	}
	
}
