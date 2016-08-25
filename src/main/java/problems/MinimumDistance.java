package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Consider an array of integers, A = [a_0, a_1, ... a_(n-1)]. The distance
 * between two indices, i and j, is denoted by d_(i,j) = |i - j|.
 * 
 * Given A, find the minimum d_(i,j) such that a_i=a_j and i != j. In other
 * words, find the minimum distance between any pair of equal elements in the
 * array. If no such value exists, print -1.
 * 
 * 
 * Input Format
 * 
 * The first line contains an integer, n , denoting the size of array A. The
 * second line contains n space-separated integers describing the respective
 * elements in array A.
 * 
 * Output Format
 * 
 * Print a single integer denoting the minimum d_(i,j) in A; if no such value
 * exists, print -1.
 * 
 * Sample Input
 * 
 * 6
 * 
 * 7 1 3 4 1 7
 * 
 * 
 * Sample Output
 * 
 * 3
 * 
 * 
 * @author lucas
 *
 */
public class MinimumDistance {

	private static void solve(int[] a) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (!map.containsKey(a[i])) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(a[i], list);
			} else {
				List<Integer> list = map.get(a[i]);
				int last = list.get(list.size() - 1);
				min = Math.min(min, Math.abs(i - last));
				map.get(a[i]).add(i);
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		solve(a);

	}
}
