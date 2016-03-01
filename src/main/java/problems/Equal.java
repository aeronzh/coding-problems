package problems;

/**
 * Christy is interning at HackerRank. One day she has to distribute some
 * chocolates to her colleagues. She is biased towards her friends and may have
 * distributed the chocolates unequally. One of the program managers gets to
 * know this and orders Christy to make sure everyone gets equal number of
 * chocolates.
 * 
 * But to make things difficult for the intern, she is ordered to equalize the
 * number of chocolates for every colleague in the following manner,
 * 
 * For every operation, she can choose one of her colleagues and can do one of
 * the three things.
 * 
 * She can give one chocolate to every colleague other than chosen one.
 * 
 * She can give two chocolates to every colleague other than chosen one.
 * 
 * She can give five chocolates to every colleague other than chosen one.
 * 
 * 
 * Calculate minimum number of such operations needed to ensure that every
 * colleague has the same number of chocolates.
 * 
 * @author lucas
 *
 */
public class Equal {

	/**
	 * From the discussion board:
	 * If you give chocolate bars to all but chosen one, it is equivalent to take
	 * away the chocolate bar(s) from each chosen one until every one is equal.
	 * So the challenge becomes decrease from each individual 1, 2 or 5 until
	 * all are equal. Second to calculate the ops we need to use to decrease an
	 * integer n until it reaches 0 (call it the function f) is equivalent to
	 * convert $n into $1, $2, $5 (no need to use dynamic programming here).
	 * Finally, to solve this challenge, we find the min (call it m) of the
	 * given list, then for i from 0 to 4, we find min of ops[i]=sum(f(c-min+i))
	 * where c is each individual colleague and thus no need to use dynamic
	 * programming here :)
	 * 
	 * @param n
	 * @param target
	 * @return
	 */
	private static int count(int n, int target) {
		int[] options = { 5, 2, 1 };

		int count = 0;
		while (n > target) {
			for (int o : options) {
				if (n - o >= target) {
					n -= o;
					count++;
					break;
				}
			}
		}

		return count;
	}

	public static int solve(int[] arr) {
		int n = arr.length;

		int min = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		for (int i = 0; i < n; i++) {
			a += count(arr[i], min);
			b += count(arr[i], min - 1);
			c += count(arr[i], min - 2);
			d += count(arr[i], min - 3);
			e += count(arr[i], min - 4);
		}

		return Math.min(a, Math.min(b, Math.min(Math.min(c, d), e)));
	}

	public static void main(String[] args) {
		int[] a = { 2, 2, 3, 7 }; // 2

		// 5104
		int[] b = { 512, 125, 928, 381, 890, 90, 512, 789, 469, 473, 908, 990, 195, 763, 102, 643, 458, 366, 684, 857, 126, 534, 974, 875, 459, 892, 686, 373, 127, 297, 576, 991,
				774, 856, 372, 664, 946, 237, 806, 767, 62, 714, 758, 258, 477, 860, 253, 287, 579, 289, 496 };

		int[] c = { 1, 5, 5 }; // 3

		System.out.println(solve(a));
		System.out.println(solve(b));
		System.out.println(solve(c));

	}

}
