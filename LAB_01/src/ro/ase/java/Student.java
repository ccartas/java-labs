package ro.ase.java;

public class Student {
	
	/**
	 * PUBLIC ATTRIBUTES: VISIBLE IN ANY CLASS
	 * PRIVATE ATTRIBUTES: VISIBLE ONLY INSIDE THE CLASS
	 * PROTECTED: VISIBLE IN THE PACKAGE AND IN ANY SUBCLASS
	 * DEFAULT: VISIBLE INSIDE THE PACKAGE
	*/
	private int ID;
	private String nume;
	
	public Student() {
		
	}
	
	public Student(int id, String nume) {
		this.ID = id;
		this.nume = nume;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getNume() {
		return this.nume;
	}
	
	public Student createClone() {
		Student s = new Student(this.ID, this.nume);
		return s;
	}
	
}
