package com.lucaslouca.other;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author lucas
 *
 */
public class KthLargest {

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int pointerLeft = 0;
		int pointerRight = 0;
		int pointerResult = 0;

		while (pointerLeft < left.length && pointerRight < right.length) {
			if (left[pointerLeft] < right[pointerRight]) {
				result[pointerResult++] = left[pointerLeft++];
			} else {
				result[pointerResult++] = right[pointerRight++];
			}
		}

		while (pointerLeft < left.length) {
			result[pointerResult++] = left[pointerLeft++];
		}

		while (pointerRight < right.length) {
			result[pointerResult++] = right[pointerRight++];
		}

		return result;
	}

	private static int[] mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			int[] left = mergeSort(array, start, middle);
			int[] right = mergeSort(array, middle + 1, end);
			int[] merged = merge(left, right);
			return merged;
		} else {
			return new int[] { array[start] };
		}
	}

	private static int[] mergeSort(int[] array) {
		return mergeSort(array, 0, array.length - 1);
	}

	private static int kthLargest(int[] array, int k) {
		int[] merged = mergeSort(array);

		return merged[array.length - k];
	}

	public static void main(String[] args) {
		int[] array = { 3, 2, 1, 5, 6, 4 };
		System.out.println(kthLargest(array, 1));
	}

}
