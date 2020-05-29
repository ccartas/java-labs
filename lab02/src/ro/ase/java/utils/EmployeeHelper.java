package ro.ase.java.utils;

import ro.ase.java.models.Employee;

public class EmployeeHelper {
	
	public double computeChristmasBonusWithIf(Employee employee) {
		double bonus = 0;
		if(employee.getJobTitle() == "CEO") {
			System.out.println("Sunt egale");
		}
		if(employee.getJobTitle().equals("CEO")) {
			bonus = employee.getSalary() * 0.25;
		} else if(employee.getJobTitle().equals("CTO")) {
			bonus = employee.getSalary() * 0.30;
		} else if(employee.getJobTitle().equals("MANAGER")) {
			bonus = employee.getSalary() * 0.20;
		} else if(employee.getJobTitle().equals("EXPERT")) {
			bonus = employee.getSalary() * 0.15;
		} else if(employee.getJobTitle().equals("INTERN")) {
			bonus = employee.getSalary() * 0.25;
		} else {
			bonus = employee.getSalary() * 0.1;
		}
		return bonus;
	}
	
	public double computeChristmasBonusWithSwitch(Employee employee) {
		double bonus = 0;
		switch(employee.getJobTitle()) {
			case "CEO":
				bonus = employee.getSalary() * 0.25;
				break;
			case "CTO":
				bonus = employee.getSalary() * 0.30;
				break;
			case "MANAGER":
				bonus = employee.getSalary() * 0.20;
				break;
			case "EXPERT":
				bonus = employee.getSalary() * 0.15;
				break;
			case "INTERN":
				bonus = employee.getSalary() * 0.25;
				break;
			default:
				bonus = employee.getSalary() * 0.10;
		}
		return bonus;
	}
}
