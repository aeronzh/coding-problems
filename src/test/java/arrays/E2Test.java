package arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class E2Test {

	@Test
	public void testReverseString1() {
		assertEquals("cba", E2.reverseString("abc"));
	}

	@Test
	public void testReverseString2() {
		assertEquals("", E2.reverseString(""));
	}

	@Test
	public void testReverseString3() {
		assertEquals("a", E2.reverseString("a"));
	}

	@Test
	public void testReverseString4() {
		assertEquals("aaa", E2.reverseString("aaa"));
	}
}
