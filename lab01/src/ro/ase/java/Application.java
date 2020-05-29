package ro.ase.java;

import ro.ase.java.models.Vehicle;

public class Application {
	public static void main(String[] args) {
		/*
		System.out.println("Hello Java");
		System.out.println("First shortcut.");
		System.out.println("Second shortcut."); */
		Vehicle v1 = new Vehicle("Tesla",
					"Model 3",
					0,
					2000,
					true,
					60000);
		System.out.println(v1.toString());
		System.out.println(v1);
		v1.setPrice(50000);
		System.out.println(v1.getPrice());
	}
}
