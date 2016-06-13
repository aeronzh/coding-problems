package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given integers N, count the number of pairs of integers whose difference is K.
 * 
 * Input Format
 * 
 * The first line contains N and K. The second line contains N numbers of the set.
 * All the N numbers are unique.
 * 
 * @author lucas
 *
 */
public class Pairs {
	private static void solve(int[] a, int k) {
		Arrays.sort(a);
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i] - k)) {
				count++;
			}
			set.add(a[i]);
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		solve(a, k);
	}

}
