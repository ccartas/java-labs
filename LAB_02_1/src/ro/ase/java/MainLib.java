package ro.ase.java;

import ro.ase.java.oop.Showroom;

public class MainLib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Showroom s1 = new Showroom("LIB SHOWROOM", 2, new long[] {20000, 40000});
		System.out.println(s1.getAveragePrice());
	}

}
