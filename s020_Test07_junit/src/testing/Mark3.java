package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;
import java.lang.reflect.Field;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import eu.ase.test.ElectricVehicle;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Mark3 {
	
	private static final String CLASS_NAME = "eu.ase.test.ElectricVehicle";
	
	@Test
	public void _311_ElectricVehicle_TestFields() {
		try {
			Class<?> t = Class.forName(CLASS_NAME);
			if(t.getDeclaredFields().length < 2)
				fail("ElectricVehicle should have 2 fields");
			for(Field f : t.getDeclaredFields()) {
				System.out.println(f.getName());
				switch(f.getName()) {
					case "serialVersionUID":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testIfFieldIsStatic(f);
						TestUtils.testFieldType(f, long.class);
						break;
					case "bateryCapacity":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, int.class);
						break;
					default:
						fail(f.getName() + " should not be present in class " + t.getName());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void _311_ElectricVehicle_TestConstructors() {
		try {
			Class<?> t = Class.forName(CLASS_NAME);
			if(t.getDeclaredConstructors().length != 1) {
				fail(t.getName() + " class should have 1 constructor.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void _312_ElectricVehicle_TestConstructorException() {
		try {
			ElectricVehicle ev1 = new ElectricVehicle("Tesla", "Model X", "B95AMD", 300, 2, 0);
			fail("ElectricVehicle should not accept values less equal than 0 for field bateryCapacity");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void _313_ElectricVehicle_TestSettersAndGetters() {
		try {
			ElectricVehicle ev1 = new ElectricVehicle("Tesla", "Model X", "B95AMD", 300, 2, 10000);
			ev1.setBateryCapacity(2000);
			assertEquals("Setter and Getter for bateryCapacity", 2000, ev1.getBateryCapacity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void _314_ElectricVehicle_TestSetterException() {
		try {
			ElectricVehicle ev1 = new ElectricVehicle("Tesla", "Model X", "B95AMD", 300, 2, 10000);
			ev1.setBateryCapacity(-500);
			fail("Setter for bateryCapacity should not accept values less equals than 0.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void _315_ElectricVehicle_TestClone() {
		try {
			ElectricVehicle ev1 = new ElectricVehicle("Tesla", "Model X", "B95AMD", 300, 2, 10000);
			ElectricVehicle ev2 = ev1.clone();
			assertNotSame("Reference of clone object should be different", ev1, ev2);
			if(ev1.getBateryCapacity() != ev2.getBateryCapacity())
				fail("Clone not correctly implemented");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void _316_ElectricVehicle_TestEquals() {
		try {
			ElectricVehicle ev1 = new ElectricVehicle("Tesla", "Model X", "B95AMD", 300, 2, 10000);
			ElectricVehicle ev2 = new ElectricVehicle("Tesla", "Model X", "B95AMD", 300, 2, 10000);
			if(!ev1.equals(ev2))
				fail("Equals not correctly implemented");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
