package ro.ase.java;

import ro.ase.java.utils.EmployeeUtils;

public class Application {
	
	public static void main(String[] args) {
		EmployeeUtils utils = new EmployeeUtils();
		String title = "CEO";
		System.out.println(title == "CEO");
		System.out.println(utils.computeBonusWithIf("CEO", 10000));
		System.out.println(utils.computeBonusWithSwitch("CEO", 10000));
		
		int[] employmentYears = {2012, 2015, 2017};
		
		System.out.println("Printing array values using normal for statement: ");
		for(int i = 0; i < employmentYears.length; i++) {
			System.out.println(employmentYears[i]);
		}
		
		System.out.println("Printing array values using enhanced for statement: ");
		for(int year : employmentYears) {
			System.out.println(year);
		}
		
		System.out.println("Printing array values using while statement: ");
		int i = 0;
		while(i < employmentYears.length) {
			System.out.println(employmentYears[i]);
			i++;
		}
		
		System.out.println("Printing array values using do while statment: ");
		int j = 0;
		do {
			System.out.println(employmentYears[j]);
			j++;
		} while (j < employmentYears.length);
		
	}
}
