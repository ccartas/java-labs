package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import eu.ase.test.SmartParking;
import eu.ase.test.Vehicle;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Mark4 {

	private static final String CLASS_NAME = "eu.ase.test.SmartParking";
	
	@Test
	public void _410_SmartParking_testFields() {
		try {
			Class<?> t = Class.forName(CLASS_NAME);
			if(t.getDeclaredFields().length < 3)
				fail("Not proper number of fields");
			for(Field f : t.getDeclaredFields()) {
				switch(f.getName()) {
					case "numberOfRows":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, int.class);
						break;
					case "numberOfColumns":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, int.class);
						break;
					case "parkedVehicles":
						TestUtils.testIfFieldIsPrivate(f);
						TestUtils.testFieldType(f, Vehicle[][].class);
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
	public void _411_SmartParking_TestConstructor() {
		try {
			Class<?> t = Class.forName(CLASS_NAME);
			if(t.getDeclaredConstructors().length != 2)
				fail(CLASS_NAME + " should have 2 constructors");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void _412_SmartParking_TestConstructorExceptionRows() {
		try {
			SmartParking sp = new SmartParking(-1, 3);
			fail("numberOfRows should not be negative.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void _413_SmartParking_TestConstructorExceptionColumns() {
		try {
			SmartParking sp = new SmartParking(0, -1);
			fail("numberOfColumns should not be negative");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void _414_SmartParking_TestSettersAndGetters() {
		try {
			SmartParking sp = new SmartParking();
			sp.setNumberOfColumns(2);
			sp.setNumberOfRows(2);
			sp.setParkedVehicles(new Vehicle[][] {{null, null}, {null, null}});
			
			assertEquals("Setter and Getter for numberOfRows", 2, sp.getNumberOfRows());
			assertEquals("Setter and Getter for numberOfColumns", 2, sp.getNumberOfColumns());
		} catch (Exception e) {
			
		}
	}
}
