package problems;

/**
 * Given an almost sorted array where only two elements are swapped, how to sort
 * the array efficiently?
 * 
 * Input: arr[] = {10, 20, 60, 40, 50, 30}
 * 
 * // 30 and 60 are swapped
 * 
 * Output: arr[] = {10, 20, 30, 40, 50, 60}
 * 
 * 
 * Input: arr[] = {10, 20, 40, 30, 50, 60}
 * 
 * // 30 and 40 are swapped
 * 
 * Output: arr[] = {10, 20, 30, 40, 50, 60}
 * 
 * 
 * Input: arr[] = {1, 5, 3}
 * 
 * // 3 and 5 are swapped
 * 
 * Output: arr[] = {1, 3, 5}
 * 
 * Expected time complexity is O(n) and only one swap operation to fix the
 * array.
 * 
 * @author lucas
 *
 */
public class SortAlmostSortedArray {

	private static void print(int[] a) {
		for (int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	private static void solve(int[] a) {
		int n = a.length-1;
		int l = 0;
		int r = n;
		
		while (l<r) {
			while (l<n && a[l]<a[l+1]) {
				l++;
			}
			
			while (r>0 && a[r]>a[r-1]) {
				r--;
			}
			
			//swap
			a[l] = a[l] - a[r];
			a[r] = a[l] + a[r];
			a[l] = a[r] - a[l];
			
			break;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {10, 20, 60, 40, 50, 30};
		solve(a);
		print(a);
	}
}
