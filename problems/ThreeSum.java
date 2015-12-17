package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a
 * <= b <= c) The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author lucas
 *
 */
public class ThreeSum {

	public static List<List<Integer>> solve(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(array);
		// -4 -1 -1 0 1 2

		int sum;
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j >= i + 1; j--) {
				sum = array[i] + array[i + 1] + array[j];
				if (sum == 0) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(array[i]);
					temp.add(array[i + 1]);
					temp.add(array[j]);
					if (!result.contains(temp)) {
						result.add(temp);
					}
				}

			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] array = { -1, 0, 1, 2, -1, -4, 0, 0, 5, -3, -2 };
		System.out.println(solve(array, 0));
	}

}
