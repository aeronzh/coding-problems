package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * @author lucas
 *
 */
public class SingleNumber {

	/**
	 * Solution using XOR.
	 * 
	 * XORing the pairs will result in 0000...000
	 * 
	 * Then XORing 0000...000 with the single number 1101...101 will result in
	 * 1101...101 again.
	 * 
	 * @param array
	 * @return single number.
	 */
	public static int solveBits(int[] array) {
		int result = array[0];
		for (int i = 1; i < array.length; i++) {
			result = result ^ array[i];
		}

		return result;
	}

	/**
	 * Solution using a Map.
	 * 
	 * @param array
	 * @return single number.
	 */
	public static int solveHashMap(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], (map.get(array[i]) + 1));
			} else {
				map.put(array[i], 1);
			}
		}

		for (Integer key : map.keySet()) {
			if (map.get(key) < 2) {
				return key;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 10, 1, 2, 5, 5, 7, 8, 8, 10, 1, 2, 3, 20, 3, 20 };
		System.out.println(solveBits(array));
	}

}
