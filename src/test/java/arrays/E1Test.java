package arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class E1Test {

	// Method 1
	@Test
	public void testHasUniqueCharsA1() {
		assertTrue(E1.hasUniqueChars("abc"));
	}

	@Test
	public void testHasUniqueCharsA2() {
		assertFalse(E1.hasUniqueChars("abca"));
	}

	@Test
	public void testHasUniqueCharsA3() {
		assertTrue(E1.hasUniqueChars(""));
	}

	@Test
	public void testHasUniqueCharsA4() {
		assertFalse(E1.hasUniqueChars("aaaaa"));
	}

	@Test
	public void testHasUniqueCharsA5() {
		assertTrue(E1.hasUniqueChars("a"));
	}

	// Method 2
	@Test
	public void testHasUniqueCharsB1() {
		assertTrue(E1.hasUniqueChars2("abc"));
	}

	@Test
	public void testHasUniqueCharsB2() {
		assertFalse(E1.hasUniqueChars2("abca"));
	}

	@Test
	public void testHasUniqueCharsB3() {
		assertTrue(E1.hasUniqueChars2(""));
	}

	@Test
	public void testHasUniqueCharsB4() {
		assertFalse(E1.hasUniqueChars2("aaaaa"));
	}

	@Test
	public void testHasUniqueCharsB5() {
		assertTrue(E1.hasUniqueChars2("a"));
	}

	// Method 3
	@Test
	public void testHasUniqueCharsC1() {
		assertTrue(E1.hasUniqueChars3("abc"));
	}

	@Test
	public void testHasUniqueCharsC2() {
		assertFalse(E1.hasUniqueChars3("abca"));
	}

	@Test
	public void testHasUniqueCharsC3() {
		assertTrue(E1.hasUniqueChars3(""));
	}

	@Test
	public void testHasUniqueCharsC4() {
		assertFalse(E1.hasUniqueChars3("aaaaa"));
	}

	@Test
	public void testHasUniqueCharsC5() {
		assertTrue(E1.hasUniqueChars3("a"));
	}
}
