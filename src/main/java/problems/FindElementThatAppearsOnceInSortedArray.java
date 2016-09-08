package problems;

/**
 * Given a sorted array in which all elements appear twice (one after one) and
 * one element appears only once. Find that element in O(log n) complexity.
 * 
 * 
 * An Efficient Solution can find the required element in O(Log n) time. The
 * idea is to use Binary Search. Below is an observation in input array. All
 * elements before the required have first occurrence at even index (0, 2, ..)
 * and next occurrence at odd index (1, 3, …). And all elements after the
 * required element have first occurrence at odd index and next occurrence at
 * even index.
 * 
 * 1) Find the middle index, say ‘mid’.
 * 
 * 2) If ‘mid’ is even, then compare arr[mid] and arr[mid + 1]. If both are
 * same, then the required element after ‘mid’ else before mid.
 * 
 * 3) If ‘mid’ is odd, then compare arr[mid] and arr[mid – 1]. If both are same,
 * then the required element after ‘mid’ else before mid.
 * 
 * Below is C implementation based on above idea.
 * 
 * @author lucas
 *
 */
public class FindElementThatAppearsOnceInSortedArray {

	private static void search(int[] a, int low, int high) {
		if (low > high) {
			return;
		} else if (low == high) {
			System.out.println(a[low]);
			return;
		} else {

			int mid = (low + high) / 2;
			if (mid % 2 == 0) {
				if (a[mid] == a[mid + 1]) {
					// Element appears after mid
					search(a, mid+2, high);
				} else {
					// Element appears before mid
					search(a, low, mid);
				}
			} else {
				if (a[mid] == a[mid - 1]) {
					// Element appears after mid
					search(a, mid+1, high);
				} else {
					// Element appears before mid
					search(a, low, mid-1);
				}
			}

		}
	}

	private static void solve(int[] a) {
		search(a,0,a.length-1);
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8 };
		solve(a);
	}
}
