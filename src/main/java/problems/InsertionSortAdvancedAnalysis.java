package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * Insertion Sort is a simple sorting technique which was covered in previous
 * challenges. Sometimes, arrays may be too large for us to wait around for
 * insertion sort to finish. Is there some other way we can calculate the number
 * of times Insertion Sort shifts each elements when sorting an array?
 * 
 * If ki is the number of elements over which the ith element of the array has
 * to shift, then the total number of shifts will be k1 + k2 +...+kN.
 * 
 * Input Format
 * 
 * The first line contains the number of test cases, T. T test cases follow. The
 * first line for each test case contains N, the number of elements to be
 * sorted. The next line contains N integers (a[1], a[2], ..., a[N]).
 * 
 * Output Format Output T lines containing the required answer for each test
 * case.
 * 
 * Constraints 1≤T≤15
 * 
 * 1≤N≤100000
 * 
 * 1≤a[i]≤10000000
 * 
 * 
 * Sample Input
 * 
 * 2
 * 
 * 5
 * 
 * 1 1 1 2 2
 * 
 * 5
 * 
 * 2 1 3 1 2
 * 
 * 
 * 
 * Sample Output
 * 
 * 0
 * 
 * 4
 * 
 * 
 * 
 * Explanation
 * 
 * The first test case is already sorted, therefore there's no need to shift any
 * element. In the second case, it will proceed in the following way.
 * 
 * Array: 2 1 3 1 2 -> 1 2 3 1 2 -> 1 1 2 3 2 -> 1 1 2 2 3
 * 
 * Moves: - 1 - 2 - 1 = 4
 * 
 * Source:
 * https://www.quora.com/How-can-I-efficiently-compute-the-number-of-swaps-required-by-slow-sorting-methods-like-insertion-sort-and-bubble-sort-to-sort-a-given-array
 * 
 * @author lucas
 *
 */
public class InsertionSortAdvancedAnalysis {
	private static class ResultSet {
		int[] array;
		long inversions;
	}

	private static void print(int[] a) {
		for (int n : a) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	private static ResultSet merge(int[] left, int[] right) {
		ResultSet result = new ResultSet();
		int[] mergedArray = new int[left.length + right.length];

		int l = 0;
		int r = 0;
		int c = 0;

		long inversions = 0;

		while (l < left.length && r < right.length) {
			if (left[l] <= right[r]) {
				mergedArray[c++] = left[l++];

				// When we insert left[l] to the result, we have already inserted j numbers to
				// the right of left[l] that where smaller than left[l] (i.e.: for r>l -> a[r]<a[l])
				inversions += r;
			} else {
				mergedArray[c++] = right[r++];
			}
		}
		
		while (l < left.length) {
			mergedArray[c++] = left[l++];
			inversions += r;
		}

		while (r < right.length) {
			mergedArray[c++] = right[r++];
		}

		result.inversions = inversions;
		result.array = mergedArray;

		return result;
	}

	private static ResultSet mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			ResultSet left = mergeSort(a, start, middle);
			ResultSet right = mergeSort(a, middle + 1, end);
			ResultSet mergeResult = merge(left.array, right.array);
			mergeResult.inversions += (left.inversions + right.inversions);
			return mergeResult;
		} else {
			ResultSet result = new ResultSet();
			result.array = new int[] { a[start] };
			return result;
		}
	}

	public static long solve(int[] a) {
		if (a.length > 1) {
			return mergeSort(a, 0, a.length - 1).inversions;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int tests = scanner.nextInt();

		for (int t = 0; t < tests; t++) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}

			System.out.println(solve(a));
		}
	}

}
