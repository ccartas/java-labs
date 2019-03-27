package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ro.ase.java.models.Product;
import ro.ase.java.models.ShoppingCart;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassTest {
	
	@Test
	public void _310testClassPrivateAttributes() throws Exception {
		Class<?> t = Class.forName("ro.ase.java.models.Product");
		if(t.getDeclaredFields().length < 3) {
			fail("Not a proper number of fields");
		}
		for(Field f : t.getDeclaredFields()) {
			try {
				assertTrue("Field "+f.toString(),
						Modifier.isPrivate(f.getModifiers()));
			} catch(Exception safe) {
				fail("The field " + f.toString() + " has problems.");
			}
		}
	}
	
	@Test
	public void _311testClassAttributeTypes() throws Exception {
		Class<?> c = Class.forName("ro.ase.java.models.Product");
		if(c.getDeclaredFields().length < 3) {
			fail("Not a proper number of fields");
		}
		for(Field f : c.getDeclaredFields()) {
			try {
				if(f.getName().equals("productName"))
					assertEquals("productName is type of String", String.class, f.getType());
				if(f.getName().equals("category"))
					assertEquals("category is type of String", String.class, f.getType());
				if(f.getName().equals("price"))
					assertEquals("price is type of double", double.class, f.getType());
			} catch(Exception nsfe) {
				fail("Field "+f.toString()+ " has problems.");
			}
		}
	}
	
	@Test
	public void _410testShoppingCartPrivateAttributes() throws Exception {
		Class<?> t = Class.forName("ro.ase.java.models.ShoppingCart");
		if(t.getDeclaredFields().length < 3) {
			fail("Not a proper number of fields");
		}
		for(Field f : t.getDeclaredFields()) {
			try {
				assertTrue("Field "+f.toString(),
						Modifier.isPrivate(f.getModifiers()));
			} catch(Exception safe) {
				fail("The field " + f.toString() + " has problems.");
			}
		}
	}
	
	@Test
	public void _411testShoppingCartAttributeTypes() throws Exception {
		Class<?> c = Class.forName("ro.ase.java.models.Product");
		if(c.getDeclaredFields().length < 3) {
			fail("Not a proper number of fields");
		}
		for(Field f : c.getDeclaredFields()) {
			try {
				if(f.getName().equals("products"))
					assertEquals("products is type of List", List.class, f.getType());
				if(f.getName().equals("applyDiscount"))
					assertEquals("applyDiscount is type of boolean", boolean.class, f.getType());
				if(f.getName().equals("discountPercentage"))
					assertEquals("finalPrice is type of double", double.class, f.getType());
			} catch(Exception nsfe) {
				fail("Field "+f.toString()+ " has problems.");
			}
		}
	}
	
	@Test
	public void _510testAccessMethodsProduct() throws Exception {
		Product p = new Product();
		p.setProductName("Iphone XS");
		assertEquals("Iphone XS", p.getProductName());
		p.setCategory("Smartphone");
		assertEquals("Smartphone", p.getCategory());
		p.setPrice(5000);
		assertEquals(5000, p.getPrice(), 0.001);
	}

}
