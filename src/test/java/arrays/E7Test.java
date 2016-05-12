package arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class E7Test {

	@SuppressWarnings("deprecation")
	@Test
	public void testZero1() {
		int[][] array = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		int[][] expected = { { 1, 0, 3 }, { 0, 0, 0 }, { 7, 0, 9 } };
		E7.zero(array);
		assertEquals(expected, array);
	}

}
