package exercises.recursion;

/**
 * Implement the paint fill function that one might see on many editing
 * programs. That is, given a screen (represented by a two dimensional array of
 * colors), a point and a new color, fill in the surrounding area until the
 * color changes from the original color.
 *
 */
public class E6 {

	private static void print(int[][] screen) {
		System.out.println("-----------------------------------------------------");
		for (int r = 0; r < screen.length; r++) {
			for (int c = 0; c < screen[0].length; c++) {
				System.out.print(screen[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------");
	}

	public static int[][] paint(int[][] screen, int row, int colunm, int color, int originalColor) {
		screen[row][colunm] = color;

		int left = colunm - 1;
		int right = colunm + 1;
		int up = row - 1;
		int down = row + 1;

		if (left > 0 && screen[row][left] == originalColor) {
			paint(screen, row, left, color, originalColor);
		}

		if (right < screen[0].length && screen[row][right] == originalColor) {
			paint(screen, row, right, color, originalColor);
		}

		if (up > 0 && screen[up][colunm] == originalColor) {
			paint(screen, up, colunm, color, originalColor);
		}

		if (down < screen.length && screen[down][colunm] == originalColor) {
			paint(screen, down, colunm, color, originalColor);
		}

		return screen;
	}

}
