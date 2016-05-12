package sorting;

import org.junit.Test;

import exercises.sorting.E1;

public class E1Test {

	@Test
	public void testMerge() {
		int[] a = { -1, 4, 20, 0, 0, 0, 0, 0, 0, 0 };
		int[] b = { 1, 11, 18, 21, 33 };
		org.junit.Assert.assertArrayEquals(new int[] { -1, 1, 4, 11, 18, 20, 21, 33, 0, 0 }, E1.merge(a, b));
	}

	@Test
	public void testMerge2() {
		int[] a = { 1, 0 };
		int[] b = { 1 };
		org.junit.Assert.assertArrayEquals(new int[] { 1, 1 }, E1.merge(a, b));
	}
}
