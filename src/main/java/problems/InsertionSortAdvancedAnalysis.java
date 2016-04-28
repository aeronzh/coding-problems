package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
 * @author lucas
 *
 */
public class InsertionSortAdvancedAnalysis {
	private static final int MAX = 10000001;

	public static long insertSort(int[] a) {
		long count = 0;

		int[] occurrence = new int[MAX];
		for (int i = 0; i < a.length; i++) {
			occurrence[a[i]] = occurrence[a[i]] + 1;
		}

		int[] lessEq = new int[MAX];
		lessEq[0] = occurrence[0];
		for (int i = 1; i < MAX; i++) {
			lessEq[i] = lessEq[i - 1] + occurrence[i];
		}

		int[] newIndex = new int[MAX];
		Arrays.fill(newIndex, -1);
		int[] sorted = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			int less = lessEq[num] - occurrence[num];
			if (newIndex[num] == -1) {
				newIndex[num] = less;
			} else {
				newIndex[num] = newIndex[num] + 1;
			}

			System.out.println("num = " + num + "  index = " + i + "  newIndex = " + newIndex[num]);
			sorted[newIndex[num]] = num;
			
			if (newIndex[num] < i) {
				count += Math.abs(i - newIndex[num]);
			}

		}

		// check if sorted:
		for (int i=0; i<sorted.length; i++) {
			if (i>0 && sorted[i]<sorted[i-1]) {
				System.out.println("Error");
			}
		}
		
		return count;

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

			System.out.println(insertSort(a));
		}
	}

}
