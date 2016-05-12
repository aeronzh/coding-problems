package exercises.sorting;

/**
 * A circus is designing a tower routine consisting of people standing atop one
 * another's shoulders. For practical and aesthetic reasons, each person must be
 * both shorter and lighter than the person below him or her. Given the heights
 * and weights of each person in the circus, write a method to compute the
 * largest possible number of people in such a tower.
 * 
 * EXAMPLE:
 * 
 * Input (ht, wt):
 * 
 * (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 *
 * 
 * Output:
 * 
 * The longest tower is length 6 and includes from top to bottom: (56, 90)
 * (60,95) (65,100) (68,110) (70,150) (75,190).
 * 
 * @author lucas
 *
 */
public class E7 {

	private static void print(Tuple[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static Tuple[] merge(Tuple[] left, Tuple[] right) {
		int totalLength = left.length + right.length;
		Tuple[] merged = new Tuple[totalLength];

		int leftPointer = 0;
		int rightPointer = 0;
		int currentPointer = 0;
		while (leftPointer < left.length && rightPointer < right.length) {
			if (left[leftPointer].height < right[rightPointer].height) {
				merged[currentPointer] = left[leftPointer];
				leftPointer++;
			} else {
				merged[currentPointer] = right[rightPointer];
				rightPointer++;
			}
			currentPointer++;
		}

		while (leftPointer < left.length) {
			merged[currentPointer] = left[leftPointer];
			leftPointer++;
			currentPointer++;
		}

		while (rightPointer < right.length) {
			merged[currentPointer] = right[rightPointer];
			rightPointer++;
			currentPointer++;
		}

		return merged;
	}

	private static Tuple[] mergeSort(Tuple[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;

			Tuple[] left = mergeSort(array, start, middle);
			Tuple[] right = mergeSort(array, middle + 1, end);
			return merge(left, right);
		} else {
			return new Tuple[] { array[start] };
		}
	}

	private static class Tuple {
		public int height;
		public int weight;

		public Tuple(int h, int w) {
			this.height = h;
			this.weight = w;
		}

		public String toString() {
			return "(" + height + ", " + weight + ")";
		}
	}

	/**
	 * Treat the problem as a longest subsequence.
	 * 
	 * Have an array LS with LS[i] = length of longest subsequence that ends
	 * with tuples[i].weight:
	 * 
	 * LS[i] = 1 + max(LS[j]), where tuples[i]>tuples[j] for j<i
	 * 
	 * 
	 * @param tuples
	 * @return
	 */
	public static int findLongestSubsequence(Tuple[] tuples) {
		int result = 1;

		// Sort in increasing order by height
		Tuple[] merged = mergeSort(tuples, 0, tuples.length - 1);

		int[] ls = new int[merged.length];
		ls[0] = 1;

		for (int i = 1; i < merged.length; i++) {
			ls[i] = 1;

			int max = ls[0];
			for (int j = 0; j < i; j++) {
				if (ls[j] > max && merged[j].weight < merged[i].weight) {
					max = ls[j];
				}
			}

			ls[i] = 1 + max;

			// Check if we have a new max
			if (ls[i] > result) {
				result = ls[i];
			}

		}

		return result;
	}

	public static void main(String[] args) {
		Tuple[] tuples = { new Tuple(65, 100), new Tuple(70, 150), new Tuple(56, 90), new Tuple(75, 190), new Tuple(60, 95), new Tuple(68, 110) };
		System.out.println(findLongestSubsequence(tuples));
	}
}
