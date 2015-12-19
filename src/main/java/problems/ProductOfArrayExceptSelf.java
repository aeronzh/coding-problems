package problems;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * 
 * @author lucas
 *
 */
public class ProductOfArrayExceptSelf {

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}
		System.out.println();
	}
	
	public static int[] solve(int[] n) {
		int[] result = new int[n.length];
		
		int p = 1;
		for (int i=0; i<n.length; i++) {
			p = p * n[i];
		}
		
		for (int i=0; i<result.length; i++) {
			result[i] = p;
		}
		
		for (int i=0; i<n.length; i++) {
			result[i] = result[i]/n[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] n = new int[]{1,2,3,4};
		int[] result = solve(n);
		print(result);
	}

}
