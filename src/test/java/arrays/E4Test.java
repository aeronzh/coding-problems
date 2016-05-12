package arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class E4Test {

	@Test
	public void testAreAnagrams1() {
		assertTrue(E4.areAnagrams("", ""));
	}

	@Test
	public void testAreAnagrams2() {
		assertTrue(E4.areAnagrams("a", "a"));
	}

	@Test
	public void testAreAnagrams3() {
		assertTrue(E4.areAnagrams("aa", "aa"));
	}

	@Test
	public void testAreAnagrams4() {
		assertTrue(E4.areAnagrams("ab", "ba"));
	}

	@Test
	public void testAreAnagrams5() {
		assertTrue(E4.areAnagrams("abc", "cba"));
	}

	@Test
	public void testAreAnagrams6() {
		assertTrue(E4.areAnagrams("abc", "bca"));
	}

	@Test
	public void testAreAnagrams7() {
		assertTrue(E4.areAnagrams("abc", "cba"));
	}

	@Test
	public void testAreAnagrams8() {
		assertTrue(E4.areAnagrams("abc", "abc"));
	}

	@Test
	public void testAreAnagrams9() {
		assertFalse(E4.areAnagrams("abc", "ba"));
	}

	@Test
	public void testAreAnagrams10() {
		assertFalse(E4.areAnagrams("abc", ""));
	}

	@Test
	public void testAreAnagram11() {
		assertFalse(E4.areAnagrams("c", "a"));
	}

	@Test
	public void testAreAnagrams12() {
		assertFalse(E4.areAnagrams("aaa", "aa"));
	}
}
