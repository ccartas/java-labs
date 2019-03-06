package ro.ase.java;

import ro.ase.java.models.Admin;
import ro.ase.java.models.User;

public class Application {
	public static void main(String[] args) {
		Admin a = new Admin("admin", "@dmin", "SC FIRMA");
		System.out.println(a.getUsername());
		
		//Downcasting
		User u1 = new Admin("admin", "adm1n", "SC ALTA FIRMA");
		System.out.println(((Admin)u1).getCompanyName());
		
		
		//Upcasting: Class Cast Exception
		/*
		 * User u2 = new User("user", "P@ss");
		 * System.out.println(((Admin)u2).getCompanyName());
		 */
		
		User u3 = (User) a;
		System.out.println(a.getUsername());
	}
}
