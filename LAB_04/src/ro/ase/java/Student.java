package ro.ase.java;

import java.util.Arrays;

public class Student implements Comparable<Student> {
	
	private String name;
	private int[] grades;
	
	public Student() {
		
	}
	
	public Student(String name, int[] grades) {
		this.name = name;
		this.grades = new int[grades.length];
		for(int i = 0;i<grades.length;i++) {
			this.grades[i] = grades[i];
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGrades(int[] grades) {
		this.grades = new int[grades.length];
		for(int i=0;i<grades.length;i++) {
			this.grades[i] = grades[i];
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int[] getGrades() {
		return this.grades;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof Student) {
			Student other = (Student) obj;
			if(this.name.equals(other.name)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	
}
