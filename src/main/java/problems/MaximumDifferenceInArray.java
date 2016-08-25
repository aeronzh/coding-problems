package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Maximum difference between two elements such that larger element appears
 * after the smaller number
 * 
 * Given an array arr[] of integers, find out the difference between any two
 * elements such that larger element appears after the smaller number in arr[].
 * 
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8
 * (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value
 * should be 2 (Diff between 7 and 9)
 * 
 * @author lucas
 *
 */
public class MaximumDifferenceInArray {
	private static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int[] min = new int[n]; // min[i] min up to index i
		min[0] = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] < min[i - 1]) {
				min[i] = a[i];
			} else {
				min[i] = min[i - 1];
			}
		}

		// 2 3 10 2 4 8 1
		// 2 2 2  2 2 2 1

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, (a[i] - min[i - 1]));
		}

		System.out.println(max);
	}
}
