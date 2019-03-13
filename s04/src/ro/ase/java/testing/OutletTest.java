package ro.ase.java.testing;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import ro.ase.java.models.Outlet;

public class OutletTest {
	
	@Test
	public void checkNumberOfFields() {
		try {
			Class<?> t = Class.forName("ro.ase.java.models.Outlet");
			if(t.getDeclaredFields().length < 2) {
				fail("Invalid number of fields");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testListEmpty() {
		Outlet o = new Outlet("ALBA");
		assertTrue(o.getItems().isEmpty());
	}
}
