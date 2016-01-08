package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of values, design and code an algorithm that returns whether
 * there are two duplicates within k indices of each other? k indices and within
 * plus or minus l (value) of each other? Do all, even the latter, in O(n)
 * running time and O(k) space.
 * 
 * @author lucas
 *
 */
public class FindDuplicateWithinN {

	public static boolean find(int[] array, int k) {
		
		// always carry the last k-visited elements with each iteration
		Set<Integer> set = new HashSet<Integer>(k);

		for (int i = 0; i < array.length; i++) {
			int current = array[i];

			if (set.contains(current)) {
				return true;
			}

			if (i < k) {
				// do nothing
			} else {
				set.remove(array[i - k]);
			}

			set.add(current);

		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(find(new int[] { 5, 5, 9, 4, 5, 20, 6, 7, 8, 10 }, 2));
	}

}
