package problems;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space to hold additional elements from
 * B. The number of elements initialized in A and B are m and n respectively.
 * 
 * @author lucas
 *
 */
public class MergeSortedArrays {

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void merge(int[] a, int[] b) {
		int n = 0;
		int m = b.length;
		while (a[n] != 0) {
			n++;
		}

		int buffer;
		int aIndex = n - 1;
		int bIndex = m - 1;
		int index = n + m - 1;
		while (aIndex >= 0 && bIndex >= 0) {
			if (b[bIndex] > a[aIndex]) {
				a[index] = b[bIndex];
				bIndex--;
			} else {
				a[index] = a[aIndex];
				aIndex--;
			}
			index--;
		}

		while (bIndex >= 0) {
			a[index] = b[bIndex];
			bIndex--;
			index--;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 10, 16, 20, 0, 0, 0, 0 };
		int[] b = { -1, 10, 15, 21 };
		merge(a, b);
		print(a);
	}

}
