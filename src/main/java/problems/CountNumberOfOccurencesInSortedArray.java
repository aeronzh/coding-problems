package problems;

/**
 * Given a sorted array arr[] and a number x, write a function that counts the
 * occurrences of x in arr[]. Expected time complexity is O(Logn)
 * 
 * @author lucas
 *
 */
public class CountNumberOfOccurencesInSortedArray {

	/******************************************************************************************************************/
	
	private static int binarySearch1(int[] a, int l, int h, int x, int count) {
		if (l <= h) {
			int mid = (l + h) / 2;

			if (x == a[mid]) {
				return binarySearch1(a, mid + 1, h, x, count) + binarySearch1(a, l, mid - 1, x, count) + 1;
			} else if (x > a[mid]) {
				return binarySearch1(a, mid + 1, h, x, count);
			} else {
				return binarySearch1(a, l, mid - 1, x, count);
			}

		} else {
			return count;
		}
	}

	private static void solve1(int[] a, int x) {
		int count = binarySearch1(a, 0, a.length - 1, x, 0);
		System.out.println(count);
	}

	/******************************************************************************************************************/

	private static int binarySearch2(int[] a, int l, int h, int x, int count) {
		if (l <= h) {
			int mid = (l + h) / 2;

			if (x == a[mid]) {
				count++;
				int i = mid - 1;
				while (i >= 0 && a[i] == x) {
					count++;
					i--;
				}
				i = mid + 1;
				while (i < a.length && a[i] == x) {
					count++;
					i++;
				}
				
				return count;

			} else if (x > a[mid]) {
				return binarySearch2(a, mid + 1, h, x, count);
			} else {
				return binarySearch2(a, l, mid - 1, x, count);
			}

		} else {
			return count;
		}
	}

	private static void solve2(int[] a, int x) {
		int count = binarySearch2(a, 0, a.length - 1, x, 0);
		System.out.println(count);
	}

	/*****************************************************************************************************/
	
	private static int firstOccurence(int[] a, int l, int h, int x) {
		if (l <= h) {
			int mid = (l + h) / 2;

			if (mid==0 || x == a[mid] && a[mid-1] < x) {
				return mid;
			} else if (x > a[mid]) {
				return firstOccurence(a, mid + 1, h, x);
			} else {
				return firstOccurence(a, l, mid - 1, x);
			}

		} else {
			return -1;
		}
	}
	
	private static int lastOccurence(int[] a, int l, int h, int x) {
		if (l <= h) {
			int mid = (l + h) / 2;

			if (mid==a.length-1 || x == a[mid] && a[mid+1] > x) {
				return mid;
			} else if (x >= a[mid]) {
				return lastOccurence(a, mid + 1, h, x);
			} else {
				return lastOccurence(a, l, mid - 1, x);
			}

		} else {
			return -1;
		}
	}
	
	private static void solve3(int[] a, int x) {
		int first = firstOccurence(a, 0, a.length-1, x);
		int last = lastOccurence(a, 0, a.length-1, x);
		
		System.out.println(last-first+1);
	}
	
	public static void main(String[] args) {
		int a[] = { 1, 1, 2, 2, 2, 2, 3 };
		int x = 2;
		solve3(a, x);
	}
}
