package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AbsoluteElementsSum {
	/**
	 * Returns an index pointing to the first element in the range [first, last]
	 * that is greater or equal to value or last if no such element is found.
	 */
	private static int lowerBound(long[] a, int first, int last, long value) {
		if (first >= last) {
			// If the element isn't found, return current place in the search, rather than returning some null value.
			return first;
		} else {
			int mid = first + (last - first) / 2;
			if (a[mid] >= value) {
				// Element is found --> search leftward until you find a non-matching element.
				return lowerBound(a, first, mid, value);
			} else {
				return lowerBound(a, mid + 1, last, value);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		Scanner out = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		int n = in.nextInt();
		long[] a = new long[n];

		// Read input
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong();
		}

		// Sort array
		Arrays.sort(a);

		// Compute prefix sum
		long[] prefixSum = new long[n];
		prefixSum[0] = a[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + a[i];
		}

		int queries = in.nextInt();
		long add = 0;
		for (int q = 0; q < queries; q++) {
			long x = in.nextLong();

			add += x;

			// Get index of first element >= -add. That is, sepearte array by elements that are <-add and elements >=-add
			// Why -add and not add? Because:
			// 1. If add is negative(<0), then by adding it to the sum of elements a[i]>=-add=abs(add) we basically subtract it from this sum. For elements a[i]<abs(add)
			//    the absolute value of their sum increases through add. Example array: -3, -1, 1, 2, 3 and add=-2. Then lo = 3. That is, the sum of [2,3], which is 5, will
			//    get decreased by 2*(-2)=-4, so the final sum is 5 - 4 = 1. For the elements j that are <2, [-3, -1, 1] their sum goes towards -infinity 
			//    (because add<0 and |add|=-add>j, so by adding a larger negative we make it negative (in case j is >0) or more negative (in case j is already <0)).
			//    That is, -3, gets an additional 3*(-2)=-6, which becomes -9 with an absolute value of 9. Adding both absolute values of the sums together, 1+9, we get a total sum of 10.
			//
			// 2. If add is positive(>0), then by adding it to the sum of elements a[i]>=-add we increase this sum by add.  Example array: -3, -1, 1, 2, 3 and add=1, then elements
			//    >=-1 are [-1, 1, 2, 3] with a sum of 5. So their sum gets increased by 4*1 and becomes 9. For elements a[i] < -add = -1, their absolute sum gets decreased by add (because we are
			//    adding something positive to a negative). Those elements are [-3]. Adding add to the numbers a[i]<-add still keeps a[i] negative, but increases it. Increasing a negative number
			//    while still keeping it below 0, decreases its absolute value. That is for -3 (with an absolute value of 3), -3 + 1 becomes -2 with an absolute value of 2.
			
			
			int lo = lowerBound(a, 0, n - 1, -1 * add);

			long ans = 0;
			if (lo > 0) {
				ans = Math.abs(prefixSum[lo - 1] + lo * add) + (prefixSum[n - 1] - prefixSum[lo - 1]) + (n - lo) * add;
			} else {
				ans = prefixSum[n - 1] + n * add;
			}

			long expected = out.nextLong();
			if (expected != ans) {
				System.out.println("Expected " + expected + " got " + ans);
			} else {
				System.out.println(ans);
			}
		}
	}
}
