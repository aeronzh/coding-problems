package problems;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value. Your algorithm's runtime complexity must be in the order
 * of O(log n). If the target is not found in the array, return [-1, -1]. For
 * example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author lucas
 *
 */
public class SearchForARange3 {

	private static int[] search(int[] a, int low, int high, int target) {
		if (low > high) {
			return new int[] { -1, -1 };
		} else {
			int mid = low + (high - low) / 2;
			if (target < a[mid]) {
				// Go left
				return search(a, low, mid - 1, target);
			} else if (target > a[mid]) {
				// Go right
				return search(a, mid + 1, high, target);
			} else {
				//Go left
				int[] l = search(a, low, mid - 1, target);

				//Go right
				int[] r = search(a, mid + 1, high, target);

				int[] ans = new int[] { l[0] == -1 ? mid : l[0], r[1] == -1 ? mid : r[1] };
				return ans;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 5, 7, 7, 8, 8, 10 };
		int[] ans = search(a, 0, a.length - 1, 8);
		System.out.println(ans[0] + ", " + ans[1]);
	}

}
