package problems;

/**
 * Rotate an array of n elements to the right by k steps. For example, with n =
 * 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How
 * many different ways do you know to ithpermutation this problem?
 * 
 * 
 * 1 2 3 4 5 6 7, k = 3
 * 
 * 
 * Reverse 0 - size-1
 * 
 * 7 6 5 4 3 2 1
 * 
 * 
 * Reverse 0 - k-1
 * 
 * 5 6 7 - 4 3 2 1
 * 
 * 
 * Reverse k - size-1
 * 
 * 5 6 7 - 1 2 3 4
 * 
 * @author lucas
 *
 */
public class RotateArray {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}

	private static void rotateInPlace(int[] array, int k) {
		int size = array.length;
		reverse(array, 0, size - 1);
		reverse(array, 0, k - 1);
		reverse(array, k, size - 1);
	}

	/**
	 * Reverse string in the given interval
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void reverse(int[] array, int start, int end) {
		int temp;
		int diff = (end - start) / 2;
		for (int i = start; i <= start + diff; i++) {
			temp = array[i];
			array[i] = array[end - (i - start)];
			array[end - (i - start)] = temp;
		}
	}

	private static int[] rotate(int[] array, int k) {
		int size = array.length;
		int[] result = new int[size];

		for (int i = size - k; i < size; i++) {
			result[k - (size - i)] = array[i];
		}

		for (int i = 0; i < size - k; i++) {
			result[k + i] = array[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		rotateInPlace(array, 1);
		print(array);
	}
}
