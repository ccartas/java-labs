package ro.ase.java;

import ro.ase.java.models.Admin;
import ro.ase.java.models.Customer;
import ro.ase.java.models.User;

public class Application {
	public static void main(String[] args) {
		User u1 = new User("user", "p@ss");
		Customer c1 = new Customer("customer", "p@ssw0rd", "John Doe");
		Admin a1 = new Admin("admin", "@dmin", "JD LTD");
		System.out.println(u1.getUsername() + " " + u1.getPassword());
		System.out.println(c1.getFullName() + " " + c1.getUsername()+ " " + c1.getPassword());
		System.out.println(a1.getCompanyName() + " " + a1.getUsername() + " " + a1.getPassword());
		System.out.println(c1 instanceof User);
		System.out.println(a1 instanceof User);
		try {
			Admin a2 = a1.clone();
			a2.setCompanyName("TEST LTD");
			System.out.println(a2.getCompanyName());
			System.out.println(a1.getCompanyName());
			a1.authenticate("admin", "@dmin");
			c1.authenticate("customer", "p@ssw0rd");
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
