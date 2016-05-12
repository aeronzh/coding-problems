package arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 * 
 * @author Lucas L.
 *
 */
public class E6 {

	public static void rotate(int[][] array) {
		int n = array.length;

		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - layer - 1;

			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = array[layer][i];

				// left -> top
				array[first][i] = array[last - offset][first];

				// bottom -> left
				array[last - offset][first] = array[last][last - offset];

				// right -> bottom
				array[last][last - offset] = array[i][last];

				// top -> right
				array[i][last] = top;
			}
		}
	}

	/**
	 * Helper method to print an NxM array of ints
	 * 
	 * @param array
	 *            int[][] array
	 */
	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
