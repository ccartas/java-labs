package ro.ase.java;

import java.io.Serializable;

public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1152299183344384467L;
	
	private String name;
	private int age;
	
	public Student() {
		
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return new String(this.name + " " + this.age);
	}
}
