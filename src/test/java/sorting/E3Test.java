package sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exercises.sorting.E3;

public class E3Test {

	int[] array = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };

	@Test
	public void testFind1() {
		int num = 5;
		assertEquals(8, E3.findIndex(num, array));
	}

	@Test
	public void testFind2() {
		int num = 15;
		assertEquals(0, E3.findIndex(num, array));
	}

	@Test
	public void testFind3() {
		int num = 14;
		assertEquals(11, E3.findIndex(num, array));
	}

	@Test
	public void testFind4() {
		int num = 1;
		assertEquals(5, E3.findIndex(num, array));
	}

	@Test
	public void testFind5() {
		int num = 3;
		assertEquals(6, E3.findIndex(num, array));
	}
}
