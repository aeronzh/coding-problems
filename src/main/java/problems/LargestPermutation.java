package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You are given an array of N integers which is a permutation of the first N
 * natural numbers. You can swap any two elements of the array. You can make at
 * most K swaps. What is the largest permutation, in numerical order, you can
 * make?
 * 
 * Input Format The first line of the input contains two integers, N and K, the
 * size of the input array and the maximum swaps you can make, respectively. The
 * second line of the input contains a permutation of the first N natural
 * numbers.
 * 
 * Output Format Print the lexicographically largest permutation you can make
 * with at most K swaps.
 * 
 * Sample Input#00
 * 
 * 5 1
 * 
 * 4 2 3 5 1
 * 
 * Sample Output#00
 * 
 * 5 2 3 4 1
 * 
 * 
 * Explanation#00
 * 
 * You can swap any two numbers in [4,2,3,5,1][4,2,3,5,1] and see the largest
 * permutation is [5,2,3,4,1][5,2,3,4,1]
 * 
 * Sample Input#01
 * 
 * 3 1
 * 
 * 2 1 3
 * 
 * Sample Output#01
 * 
 * 3 1 2
 * 
 * Explanation#01
 * 
 * With 1 swap we can get [1,2,3][1,2,3], [3,1,2][3,1,2] and [2,3,1][2,3,1] out
 * of these [3,1,2][3,1,2] is the largest permutation.
 * 
 * Sample Input#02
 * 
 * 2 1
 * 
 * 2 1
 * 
 * Sample Output#02
 * 
 * 2 1
 * 
 * 
 * Explanation#02
 * 
 * We can see that [2,1][2,1] is already the largest permutation. So we don't
 * need any swaps.
 * 
 * @author lucas
 *
 */
public class LargestPermutation {

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static int indexOfMax(int[] a, int start) {
		int n = a.length;
		int maxIndex = start;
		for (int j = start; j < n; j++) {
			if (a[j] > a[maxIndex]) {
				maxIndex = j;
			}
		}

		return maxIndex;
	}

	private static void solve(int[] a, int k) {
		int n = a.length;
		int[] indices = new int[n + 1];
		for (int i = 0; i < n; i++) {
			indices[a[i]] = i;
		}

		int i = 0;
		while (k > 0 && i < n) {
			int num = a[i];
			for (int j = n; j > num; j--) {
				if (indices[j] > i) {
					swap(a, i, indices[j]);

					int tmp = indices[j];
					indices[j] = i;
					indices[num] = tmp;
					k--;
					break;
				}
			}
			i++;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int n, k;
		n = scanner.nextInt();
		k = scanner.nextInt();

		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		solve(a, k);
		print(a);
	}
}
