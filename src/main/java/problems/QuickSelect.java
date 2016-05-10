package problems;

public class QuickSelect {

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	/**
	 * Partition array around a pivot element and return the index of the pivot
	 * element
	 * 
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	private static int partition(int[] a, int start, int end) {
		int pivotIndex = a[end];

		int cursor = start;
		for (int i = start; i < end; i++) {
			if (a[i] < a[pivotIndex]) {
				swap(a, cursor, a[i]);
				cursor++;
			}
		}

		swap(a, cursor, pivotIndex);

		return cursor;
	}

	private static int quickselect(int[] a, int k, int start, int end) {
		if (start <= end) {
			int pivotIndex = partition(a, start, end);

			if (k == pivotIndex) {
				return a[pivotIndex];
			} else if (k < pivotIndex) {
				return quickselect(a, k, start, pivotIndex - 1);
			} else {
				return quickselect(a, k, pivotIndex + 1, end);
			}
		} else {
			return -1;
		}
	}

	private static int quickselect(int[] a, int k) {
		return quickselect(a, k, 0, a.length - 1);
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 2, 0, 5, 7, 6 };
		// 0 1 2 3 4 5 6 7
		int k = 6;

		System.out.println(quickselect(a, k));
	}

}
