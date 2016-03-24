package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FindTheMedian {

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
	}

	// Paretitions array around a pivot and returns pivot position
	public static int partition(int[] a, int start, int end) {
		if (start == end) {
			return end;
		}
		
		int pivot = a[(start+end)/2];

		int i = start;
		int j = end;

		while (i <= j) {
			// Find element on left that should be on right
			while (a[i] < pivot) {
				i++;
			}
			
			// Find the element on right that should be on left
			while( a[j] > pivot) {
				j--;
			}
			
			if (i <= j) {
				// swap i and j
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		}

		return i;
	}
	
	private static int quickselect(int[] a, int k, int start, int end) {
		int p = partition(a, start, end);
		if (p == k) {
			return a[p];
		} if (k < p) {
			// k is on the left side 
			return quickselect(a, k, start, p-1);
		} else {
			// k is on the right side
			return quickselect(a, k, p+1, end);
		}
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
			b[i] = a[i];
		}

		// 4960
		System.out.println(quickselect(a, a.length/2, 0, a.length-1));

		Arrays.sort(b);
		System.out.println(b[b.length/2]);
		
	
	}

}
