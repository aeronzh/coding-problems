package arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class E3Test {

	// Method 1
	@Test
	public void testRemoveDuplicatesA1() {
		assertEquals("a", E3.removeDuplicateChars("aaa"));
	}

	@Test
	public void testRemoveDuplicatesA2() {
		assertEquals("abc", E3.removeDuplicateChars("abc"));
	}

	@Test
	public void testRemoveDuplicatesA3() {
		assertEquals("ab", E3.removeDuplicateChars("ababa"));
	}

	@Test
	public void testRemoveDuplicatesA4() {
		assertEquals("ac", E3.removeDuplicateChars("aaac"));
	}

	// Method 2
	@Test
	public void testRemoveDuplicatesB1() {
		assertEquals("a" + '\0' + "a", E3.removeDuplicateChars("aaa".toCharArray()));
	}

	@Test
	public void testRemoveDuplicatesB2() {
		assertEquals("abc", E3.removeDuplicateChars("abc".toCharArray()));
	}

	@Test
	public void testRemoveDuplicatesB3() {
		assertEquals("ab" + '\0' + "ba", E3.removeDuplicateChars("ababa".toCharArray()));
	}

	@Test
	public void testRemoveDuplicatesB4() {
		assertEquals("ac" + '\0' + "c", E3.removeDuplicateChars("aaac".toCharArray()));
	}
}
