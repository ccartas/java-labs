package ro.ase.java;

public class MainPoly {
	
	
	public static void main(String[] args) {
		Vehicle v = null;
		
		ElectricCar ec = new ElectricCar(VehicleType.ELECTRIC, 2000, 50);
		System.out.println(ec.getVehicleType() + " " + ec.getWeight() + " " + ec.getNumberOfBateries() + " " + ec.hasIntegralTransmission());
		
		Car c = new Car(VehicleType.NORMAL, 1500, 300);
		System.out.println(c.getVehicleType() + " " + c.getWeight() + " " + c.getMaximumSpeed() + " " + c.hasIntegralTransmission());
		
		v = ec; 
		System.out.println(v.showDetails()); // Polimorfism
		
		v = c;
		System.out.println(v.showDetails()); // Polimorfism
	}
}
