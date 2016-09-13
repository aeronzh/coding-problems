package problems;

/**
 * Given a sorted array and a value x, the floor of x is the largest element in
 * array smaller than or equal to x. Write efficient functions to find floor of
 * x.
 * 
 * Examples:
 * 
 * Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 5
 * 
 * Output : 2
 * 
 * 2 is the largest element in arr[] smaller than 5.
 * 
 * 
 * 
 * 
 * Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 20
 * 
 * Output : 19
 * 
 * 19 is the largest element in arr[] smaller than 20.
 * 
 * 
 * 
 * 
 * Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 0
 * 
 * Output : -1
 * 
 * Since floor doesn't exist, output is -1.
 * 
 * @author lucas
 *
 */
public class FloorInSortedArray {
	private static void search(int[] a, int low, int high, int x, boolean switched) {
		if (low > high) {
			System.out.println("-1");
			return;
		} else {

			if (x>a[high]) {
				System.out.println(a[high]);
				return;
			}
			
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				System.out.println(a[mid]);
				return;
			}
			if (x < a[mid]) {
				if (mid > 0 && x < a[mid] && x >= a[mid - 1]) {
					System.out.println(a[mid - 1]);
					return;
				}
				search(a, low, mid - 1, x, false);
			} else {
				search(a, mid + 1, high, x, true);
			}

		}
	}

	private static void solve(int[] a, int x) {
		search(a, 0, a.length - 1, x, false);
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 8, 10, 10, 12, 19 };
		solve(a, 20);
	}
}
