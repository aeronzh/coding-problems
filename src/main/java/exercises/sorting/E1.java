package exercises.sorting;

/**
 *
 * You are given two sorted arrays, A and B, and A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 * 
 * @author lucas
 *
 */
public class E1 {

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int[] merge(int[] a, int[] b) {
		int sizeB = b.length;
		int sizeA = 0;
		while (a[sizeA] != 0) {
			sizeA++;
		}

		int indexA = sizeA - 1;
		int indexB = sizeB - 1;
		int totalSize = sizeA + sizeB;
		int currentIndex = totalSize - 1;

		while (currentIndex >= 0) {

			if (indexA >= 0 && indexB >= 0) {
				if (b[indexB] > a[indexA]) {
					a[currentIndex] = b[indexB];
					indexB--;
				} else {
					a[currentIndex] = a[indexA];
					indexA--;
				}

			}

			currentIndex--;
		}

		return a;
	}

	public static void main(String[] args) {
		int[] a = { -1, 4, 20, 0, 0, 0, 0, 0, 0, 0 };
		int[] b = { 1, 11, 18, 21, 33 };
		printArray(merge(a, b));
	}
}
