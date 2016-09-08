package problems;

/**
 * Given two sorted arrays and a number x, find the pair whose sum is closest to
 * x and the pair has an element from each array.
 * 
 * We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to
 * find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] –
 * x) is minimum.
 * 
 * @author lucas
 *
 */
public class ClosestPairFromTwoSortedArrays {

	/**
	 * We can do it in O(n) time using following steps. 1) Merge given two
	 * arrays into an auxiliary array of size m+n using merge process of merge
	 * sort. While merging keep another boolean array of size m+n to indicate
	 * whether the current element in merged array is from ar1[] or ar2[].
	 * 
	 * 2) Consider the merged array and use the linear time algorithm to find
	 * the pair with sum closest to x. One extra thing we need to consider only
	 * those pairs which have one element from ar1[] and other from ar2[], we
	 * use the boolean array for this purpose.
	 * 
	 * @param a
	 * @param b
	 * @param x
	 */
	private static void solve(int[] a, int[] b, int x) {
		int m = a.length;
		int n = b.length;
		int[] c = new int[m + n];
		boolean[] from = new boolean[m + n];

		int ia = 0;
		int ib = 0;
		int i = 0;
		while (ia < m && ib < n) {
			if (a[ia] < b[ib]) {
				c[i] = a[ia++];
				from[i] = true;
			} else {
				c[i] = b[ib++];
			}

			i++;
		}

		while (ia < m) {
			c[i] = a[ia++];
			from[i] = true;
			i++;
		}

		while (ib < n) {
			c[i] = b[ib++];
			i++;
		}

		int min = Integer.MAX_VALUE;
		int[] pair = new int[2];
		int l = 0;
		int r = m + n - 1;
		while (l < r) {
			if (Math.abs(c[l] + c[r] - x) < min) {
				if (from[l] != from[r]) {
					pair = new int[] { c[l], c[r] };
					min = Math.abs(c[l] + c[r] - x);
				}
			}

			if (c[l] + c[r] < x) {
				l++;
			} else {
				r--;
			}
		}

		System.out.println(pair[0] + ", " + pair[1]);
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 7, 50 };
		int b[] = { 10, 20, 30, 40 };
		int x = 38; // 7, 30
		solve(a, b, x);

		// 37  34  33  31
	}
}
