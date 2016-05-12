package arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class E6Test {

	@SuppressWarnings("deprecation")
	@Test
	public void testRotate1() {
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		E6.rotate(array);
		assertEquals(expected, array);
	}

}
