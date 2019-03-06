package ro.ase.java.utils;

public class EmployeeUtils {
	
	public float computeBonusWithIf(String title, float salary) {
		float bonus = 0.0f;
		if(title == "CEO") {
			System.out.println("SUNT EGALE");
		}
		if(title.equals("CEO")) {
			bonus = salary * 0.25f;
		} else if(title.equals("CTO")) {
			bonus = salary * 0.20f;
		} else if(title.equals("MANAGER")) {
			bonus = salary * 0.15f;
		} else {
			bonus = salary * 0.1f;
		}
		return bonus;
	}
	
	public float computeBonusWithSwitch(String title, float salary) {
		float bonus = 0.0f;
		switch(title) {
			case "CEO":
				bonus = salary * 0.25f;
				break;
			case "CTO":
				bonus = salary * 0.20f;
				break;
			case "MANAGER":
				bonus = salary * 0.15f;
				break;
			default:
				bonus = salary * 0.1f;
				break;
		
		}
		return bonus;
	}
	
	
}
