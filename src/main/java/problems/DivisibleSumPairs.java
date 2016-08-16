package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You are given an array of n integers a_0, a_1,...,a_(n-1) and a positive
 * integer, k. Find and print the number of (i,j) pairs where i < j and a_i +
 * a_j is evenly divisible by k.
 * 
 * @author lucas
 *
 */
public class DivisibleSumPairs {

	private static void brute(int[] a, int n, int k) {
		int count = 0;
		
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if ((a[i] + a[j]) % k == 0) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		brute(a, n, k);
	}
}
