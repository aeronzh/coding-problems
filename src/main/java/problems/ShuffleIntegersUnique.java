package problems;

/**
 * Given a sorted array of integers, using the same array, shuffle the integers
 * to have unique elements and return the index.
 * 
 * Sample input: [3,3,4,5,5,6,7,7,7]
 * 
 * Sample output: [3,4,5,6,7,X,X,X,X]
 * 
 * in this case it returns an index of 4.
 * 
 * @author lucas
 *
 */
public class ShuffleIntegersUnique {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static int shuffle(int[] array) {
		int uniqueIndex = 1;
		int index = 1;

		while (index < array.length) {
			if (array[index] != array[uniqueIndex]) {
				array[uniqueIndex] = array[index];
				uniqueIndex++;
			}
			index++;
		}

		index = array.length - 1;
		while (index > 0 && array[index - 1] == array[index]) {
			array[index] = 0;
			index--;
		}

		print(array);

		return index;
	}

	public static void main(String[] args) {
		System.out.println(shuffle(new int[] { 3, 3, 4, 5, 5, 6, 7, 7, 7 }));

	}

}
