package problems;

import java.util.Arrays;
import java.util.List;

/**
 * Given a set of positive integers, and a value sum k, list all subsets in array whose sum is equal to given sum k.
 * 
 * @author lucas
 *
 */
public class SubsetSum {

	private static void sums(List<Integer> set, int k, int index, int sum, boolean[] solution) {
		if (sum == k) {
			System.out.print("Found solution: ");
			StringBuilder sb = new StringBuilder("{");
			for (int i=0; i<solution.length; i++) {
				if (solution[i]) {
					sb.append(set.get(i)+" ");
				}
			}
			sb.append("}");
			System.out.println(sb.toString());
		} else if (index < set.size()){
			int n = set.get(index);

			// take it
			solution[index] = true;
			sum = sum + n;
			sums(set, k, index + 1, sum, solution);

			// don't take it
			solution[index] = false;
			sum = sum - n;
			sums(set, k, index + 1, sum, solution);
		}
	}

	public static void main(String[] args) {
		List<Integer> set = Arrays.asList( 1, 2, 2, 3, 4, 5 );
		sums(set, 5, 0, 0, new boolean[set.size()]);
	}

}
