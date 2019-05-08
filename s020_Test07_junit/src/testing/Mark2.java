package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import eu.ase.test.Vehicle;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Mark2 {
	private static final String CLASS_NAME = "eu.ase.test.Vehicle";
	@Test
	public void _210_Vehicle_TestFields() {
		try {
			Class<?> t = Class.forName(CLASS_NAME);
			if(t.getDeclaredFields().length < 6)
				fail("Wrong number of fields in class Vehicle");
			for(Field f : t.getDeclaredFields()) {
				System.out.println(f.getName());
				switch(f.getName()) {
					case "serialVersionUID":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testIfFieldIsStatic(f);
						TestUtils.testFieldType(f, long.class);
						break;
					case "make":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, String.class);
						break;
					case "model":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, String.class);
						break;
					case "plateNumber":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, String.class);
						break;
					case "horsePower":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, int.class);
						break;
					case "parkingDuration":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, float.class);
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
	public void _211_Vehicle_TestConstructors() {
		try {
			Class<?> t = Class.forName(CLASS_NAME);
			if(t.getDeclaredConstructors().length != 2) {
				fail(t.getName() + " class should have 2 constructors.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void _212_Vehicle_TestConstructorWithParamsException() {
		try {
			Vehicle v = new Vehicle("Audi", "A5", "B01AB", 177, 2);
			fail("Constructor with parameters should throw an exception if plateNumber length is less than 6.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void _212_Vehicle_TestSettersAndGetters() {
		Vehicle v = new Vehicle();
		v.setMake("Audi");
		v.setModel("A5");
		v.setPlateNumber("B-55-MAD");
		v.setHorsePower(177);
		v.setParkingDuration(2);
		
		assertEquals("Setter and Getter for make", "Audi", v.getMake());
		assertEquals("Setter and Getter for model", "A5", v.getModel());
		assertEquals("Setter and Getter for plateNumber", "B-55-MAD", v.getPlateNumber());
		assertEquals("Setter and Getter for horsePower", 177, v.getHorsePower());
		assertEquals("Setter and Getter for parkingDuration", 2, v.getParkingDuration(), 0.01);
	}
	
	@Test
	public void _213_Vehicle_TestClone() {
		try {
			Vehicle v1 = new Vehicle("Audi", "A5", "B-55-MAD", 177, 2);
			Vehicle v2 = v1.clone();
			v2.setMake(new String(""+v1.getMake()));
			v2.setModel(new String(""+v1.getModel()));
			v2.setPlateNumber(new String(""+v1.getPlateNumber()));
			
			assertNotSame("Testing vehicle clone reference", v1, v2);
			if(v1.getHorsePower() != v2.getHorsePower())
				fail("horsePower should have the same value on the cloned object");
			if(v1.getParkingDuration() != v2.getParkingDuration())
				fail("parkingDuration should have the same value on the cloned object");
			if(!(v1.getMake().compareTo(v2.getMake()) == 0) &&
					!(v1.getModel().compareTo(v2.getModel()) == 0) &&
					!(v1.getPlateNumber().compareTo(v2.getPlateNumber()) == 0))
				fail("Fields of type String should have the same value after clone");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void _214_Vehicle_TestComparable() {
		try {
			Vehicle v1 = new Vehicle("Audi", "A5", "B-55-MAD", 177, 2);
			Vehicle v2 = new Vehicle("Audi", "A5", "B-55-MAD", 177, 2);
			if(v1.compareTo(v2) != 0)
				fail("compareTo not correctly implemented");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
