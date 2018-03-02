package ro.ase.java;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student(1, "Gigel");
		Student s2 = new Student();
		s2.setID(2);
		s2.setNume("Ionel");
		Student s3 = s1.createClone();
		
		System.out.println(s1.getID() + " " + s1.getNume());
		System.out.println(s2.getID() + " " + s2.getNume());
		System.out.println(s3.getID() + " " + s3.getNume());
	}

}
