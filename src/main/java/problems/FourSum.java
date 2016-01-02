package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a <= b <= c <= d) The solution set must not contain duplicate
 * quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * 
 * 
 * @author lucas
 *
 */
public class FourSum {

	public static List<List<Integer>> solveBruteforce(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> list;
		for (int a = 0; a < array.length; a++) {
			list = new ArrayList<Integer>();
			list.add(array[a]);
			for (int b = 0; b < array.length; b++) {
				if (b != a) {
					list.add(array[b]);
					for (int c = 0; c < array.length; c++) {
						if (c != b && c != a) {
							list.add(array[c]);
							for (int d = 0; d < array.length; d++) {
								if (d != c && d != b && d != a) {
									list.add(array[d]);
									if ((list.get(0) + list.get(1) + list.get(2) + list.get(3)) == target) {
										List<Integer> tmp = new ArrayList<Integer>(list);
										Collections.sort(tmp);
										if (!result.contains(tmp)) {
											result.add(tmp);
										}
									}
									list.remove(list.size() - 1);
								}
							}

							list.remove(list.size() - 1);
						}
					}
					list.remove(list.size() - 1);
				}
			}
			list.remove(list.size() - 1);
		}

		return result;
	}

	public static List<List<Integer>> solve(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		return result;
	}

	public static void main(String[] args) {
		int[] array = { 1, 0, -1, 0, -2, 2 };
		System.out.println(solveBruteforce(array, 0));

	}

}
