package recursion;

import org.junit.Test;

import exercises.recursion.E6;

public class E6Test {

	@Test
	public void testPaint() {
		int[][] screen = new int[10][10];
		screen[0] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		screen[1] = new int[] { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 };
		screen[2] = new int[] { 1, 1, 1, 0, 0, 0, 1, 0, 0, 0 };
		screen[3] = new int[] { 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
		screen[4] = new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 };
		screen[5] = new int[] { 1, 0, 0, 0, 1, 0, 1, 1, 1, 1 };
		screen[6] = new int[] { 1, 1, 0, 0, 0, 0, 1, 0, 0, 0 };
		screen[7] = new int[] { 0, 1, 1, 1, 1, 1, 1, 0, 0, 0 };
		screen[8] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		screen[9] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		int[][] expected = new int[10][10];
		expected[0] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		expected[1] = new int[] { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 };
		expected[2] = new int[] { 1, 1, 1, 5, 5, 5, 1, 0, 0, 0 };
		expected[3] = new int[] { 1, 5, 5, 5, 5, 5, 1, 1, 1, 1 };
		expected[4] = new int[] { 1, 5, 5, 5, 1, 5, 5, 5, 5, 1 };
		expected[5] = new int[] { 1, 5, 5, 5, 1, 5, 1, 1, 1, 1 };
		expected[6] = new int[] { 1, 1, 5, 5, 5, 5, 1, 0, 0, 0 };
		expected[7] = new int[] { 0, 1, 1, 1, 1, 1, 1, 0, 0, 0 };
		expected[8] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		expected[9] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		int color = 5;
		int row = 3;
		int col = 2;

		int[][] actual = E6.paint(screen, row, col, color, screen[row][col]);

		org.junit.Assert.assertArrayEquals(expected, actual);
	}

}
