package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a number k, and an array of integers A, find two integers in the array
 * which sum to k. Do this in linear time and O(n) space, iterating over the
 * array exactly once. Now do this in constant space and O(n log n) time.
 * 
 * @author lucas
 *
 */
public class PairKSum {

	private static void sum(int[] array, int k) {
		Map<Integer, Integer> sum2pos = new HashMap<Integer, Integer>();
		for (int i=0; i<array.length; i++) {
			if (sum2pos.containsKey(k-array[i])) {
				System.out.println(array[sum2pos.get(k-array[i])]+"+"+array[i]+" = "+k);
			} else {
				sum2pos.put(array[i], i);				
			}
		}
	}
	
	public static void main(String[] args) {
		sum(new int[]{1,3,2,4,6,5,7,8,9}, 5);
	}

}
