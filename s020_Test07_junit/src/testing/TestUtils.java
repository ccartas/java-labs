package testing;

import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestUtils {
	
	public static void testIfFieldIsPrivate(Field f) {
		if(!Modifier.isPrivate(f.getModifiers()))
			fail(f.getName() + " is not private!");	
	}
	
	public static void testIfFieldIsStatic(Field f) {
		if(!Modifier.isStatic(f.getModifiers()))
			fail(f.getName() + " is not static!");
	}
	
	public static void testFieldType(Field f, Object expectedType) {
		if(!f.getType().equals(expectedType))
			fail(f.getName() + " is not of type " + expectedType);
	}
}
