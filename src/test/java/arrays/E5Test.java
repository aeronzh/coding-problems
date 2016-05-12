package arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class E5Test {

	@Test
	public void testReplaceSpaces1() {
		assertEquals("Hello%20World", E5.replaceSpaces("Hello World"));
	}

	@Test
	public void testReplaceSpaces2() {
		assertEquals("Hello%20World%20%20", E5.replaceSpaces("Hello World  "));
	}

	@Test
	public void testReplaceSpaces3() {
		assertEquals("%20%20", E5.replaceSpaces("  "));
	}

	@Test
	public void testReplaceSpaces4() {
		assertEquals("%20%20", E5.replaceSpaces("%20 "));
	}
}
