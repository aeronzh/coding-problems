package problems;

/**
 * Given an array, find an element before which all elements are smaller than
 * it, and after which all are greater than it. Return index of the element if
 * there is such an element, otherwise return -1.
 * 
 * @author lucas
 *
 */
public class ElementBeforeAllAreSmallerAfterGreater {

	// 		a: 5 1 4 3 6 8 10 7  9
	// 	  max: 5 5 5 5 6 8 10 10 10
	//    min: 
	private static void solve(int[] a) {
		int[] max = new int[a.length]; // max[i] holds the maximum element until (inclusive) i

		max[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max[i - 1]) {
				max[i] = a[i];
			} else {
				max[i] = max[i - 1];
			}
		}

		int[] min = new int[a.length]; // min[i] holds the minimum element from index i to a.length-1
		min[a.length - 1] = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i]<min[i+1]) {
				min[i] = a[i];
			} else {
				min[i] = min[i+1];
			}
		}
		
		
		for (int i=1; i<a.length-1; i++) {
			if (max[i-1]<a[i] && min[i+1]>a[i]) {
				System.out.println(i);
				return;
			}
		}
		
		if (min[1]>a[0]) {
			System.out.println(0);
			return;
		}
		
		if (max[a.length-2]<max[a.length-1]) {
			System.out.println(a.length-1);
			return;
		}
	}

	public static void main(String[] args) {
		int[] a = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
		solve(a);
	}
}
