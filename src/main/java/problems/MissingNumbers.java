package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Numeros, the Artist, had two lists A and B, such that B was a permutation
 * of A. Numeros was very proud of these lists. Unfortunately, while
 * transporting them from one exhibition to another, some numbers were left out
 * of A. Can you find the missing numbers?
 * 
 * Notes
 * 
 * If a number occurs multiple times in the lists, you must ensure that the
 * frequency of that number in both lists is the same. If that is not the case,
 * then it is also a missing number. You have to print all the missing numbers
 * in ascending order. Print each missing number once, even if it is missing
 * multiple times. The difference between maximum and minimum number in B is
 * less than or equal to 100.
 * 
 * @author lucas
 *
 */
public class MissingNumbers {
	private static final int MAX = 10000;

	private static void solve(int[] a, int[] b) {
		int[] mapA = new int[MAX + 1];
		for (int num : a) {
			mapA[num] = mapA[num] + 1;
		}

		int[] mapB = new int[MAX + 1];
		for (int num : b) {
			mapB[num] = mapB[num] + 1;
		}

		for (int i = 0; i <= MAX; i++) {
			if (mapA[i] != mapB[i]) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		int m = scanner.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
		}

		solve(a, b);
	}

}
