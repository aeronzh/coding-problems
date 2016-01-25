package problems;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author lucas
 *
 */
public class Permutations {

	private static String print(int[] n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n.length; i++) {
			sb.append(n[i]);
		}

		return sb.toString();
	}

	public static void solve(int[] n, int i) {
		if (i == n.length) {
			System.out.println(print(n));
		} else {
			for (int j = i; j < n.length; j++) {
				// swap
				int temp = n[i];
				n[i] = n[j];
				n[j] = temp;

				solve(n, i + 1);

				// swap back
				temp = n[i];
				n[i] = n[j];
				n[j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] n = { 1, 2, 3 };
		solve(n, 0);
	}

}
