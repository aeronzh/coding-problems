package problems;

public class MergeSort {

	private static void print(int[] a) {
		for (int n : a) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];

		int l = 0;
		int r = 0;
		int c = 0;

		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				result[c++] = left[l++];
			} else {
				result[c++] = right[r++];
			}
		}

		while (l < left.length) {
			result[c++] = left[l++];
		}

		while (r < right.length) {
			result[c++] = right[r++];
		}

		return result;
	}

	private static int[] mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			int[] left = mergeSort(a, start, middle);
			int[] right = mergeSort(a, middle + 1, end);
			int[] sorted = merge(left, right);
			return sorted;
		} else {
			return new int[] { a[start] };
		}
	}

	public static int[] sort(int[] a) {
		if (a.length > 1) {
			return mergeSort(a, 0, a.length - 1);
		} else {
			return a;
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, -1, 6, 4 };
		int[] sorted = sort(a);
		print(a);
		print(sorted);
	}

}
