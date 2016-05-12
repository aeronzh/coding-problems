package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * For example:
 * 
 * Input: numbers={2, 7, 11, 4, 8, 15}, target=9 Output: index1=1, index2=2
 * 
 * 
 * 
 * @author lucas
 *
 */
public class TwoSum {
	private static void twoSum(int[] array, int s) {
		Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (valueToIndex.containsKey(array[i])) {
				System.out.println("[" + (valueToIndex.get(array[i]) + 1) + ", " + (i + 1) + "]");
			} else {
				valueToIndex.put(s - array[i], i);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 2, 1, 2, 4, 8, 15 };
		twoSum(array, 6);
	}

}
