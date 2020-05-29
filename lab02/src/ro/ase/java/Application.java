package ro.ase.java;

import ro.ase.java.models.Employee;
import ro.ase.java.utils.EmployeeHelper;

public class Application {
	public static void main(String[] args) {
		Employee emp1 = new Employee("John Doe", "TEAM LEAD", 20000);
		Employee emp2 = new Employee("Jane Dane", "CEO", 30000);
		EmployeeHelper helper = new EmployeeHelper();
		System.out.println(helper.computeChristmasBonusWithIf(emp1));
		System.out.println(helper.computeChristmasBonusWithSwitch(emp1));
		System.out.println(emp1.getJobTitle() == emp2.getJobTitle());
	}
}
