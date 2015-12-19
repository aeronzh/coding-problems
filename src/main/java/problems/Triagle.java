package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [
 * 
 * ---[2],
 * 
 * --[3,4],
 * 
 * -[6,5,7],
 * 
 * [4,1,8,3]
 * 
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 * 
 * @author lucas
 *
 */
public class Triagle {

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;

		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}

		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}

		return total[0];
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> l0 = Arrays.asList(2);
		List<Integer> l1 = Arrays.asList(3, 4);
		List<Integer> l2 = Arrays.asList(6, 5, 7);
		List<Integer> l3 = Arrays.asList(4, 1, 8, 3);

		triangle.add(l0);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);

		System.out.println(minimumTotal(triangle));
	}

}
