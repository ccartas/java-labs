package ro.ase.java.models;

public class Employee {
	private String fullName;
	private String jobTitle;
	private double salary;
	
	public Employee() { }
	
	public Employee(String fullName,
					String jobTitle,
					double salary) {
		this.fullName = fullName;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	public String getJobTitle() {
		return this.jobTitle;
	}
	public double getSalary() {
		return this.salary;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
