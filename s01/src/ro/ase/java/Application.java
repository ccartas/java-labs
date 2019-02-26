package ro.ase.java;

import ro.ase.java.models.Vehicle;

public class Application {
	public static void main(String[] args) {
		Vehicle v = new Vehicle("Audi", "A5", 2500, 2.5f, 20000, false);
		v.applyDiscount(1000);
		System.out.println(v);
	}
}
