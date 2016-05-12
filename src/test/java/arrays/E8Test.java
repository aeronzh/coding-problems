package arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class E8Test {

	@Test
	public void testIsRotation1() {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		assertTrue(E8.isRotation(s1, s2));
	}

	@Test
	public void testIsRotation2() {
		String s1 = "wwaterbottle";
		String s2 = "erbottlewat";
		assertFalse(E8.isRotation(s1, s2));
	}
}
