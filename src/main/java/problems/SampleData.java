package problems;

import java.util.Random;

/**
 * Reservoir sampling is a family of randomized algorithms for randomly choosing
 * a sample of k items from a list S containing n items, where n is either a
 * very large or unknown number. Typically n is large enough that the list
 * doesn't fit into main memory.
 * 
 * @author lucas
 *
 */
public class SampleData {

	private static int random(int min, int max) {
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = min + rand.nextInt((max - min) + 1);

		return randomNum;
	}

	/**
	 * The algorithm creates a "reservoir" array of size k and populates it with
	 * the first k items of S. It then iterates through the remaining elements
	 * of S until S is exhausted. At the ith element of S, the algorithm
	 * generates a random number j between 1 and i. If j is less than or equal
	 * to k, the jth element of the reservoir array is replaced with the ith
	 * element of S. In effect, for all i, the ith element of S is chosen to be
	 * included in the reservoir with probability k/i. Similarly, at each
	 * iteration the jth element of the reservoir array is chosen to be replaced
	 * with probability 1/k * k/i, which simplifies to 1/i.
	 */
	public static int[] solve(int[] s, int k) {
		int[] r = new int[k];
		int n = s.length;
		// fill the reservoir array
		for (int i = 0; i < k; i++) {
			r[i] = s[i];
		}

		// replace elements with gradually decreasing probability
		for (int i = k; i < n; i++) {
			int j = random(1, i); // important: inclusive range

			//j<=k with probability k/i
			if (j < k) { // Normally j<=k, but we start counting from 0
				// jth element in r is replaced with probability 1/k * k/i
				r[j] = s[i];
			}
		}

		return r;
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] s = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 3;
		int[] r = solve(s, k);
		print(r);

	}

}
