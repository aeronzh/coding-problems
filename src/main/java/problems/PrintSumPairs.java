package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A = [3, 7, 2,5,6,4] for a number N, print the pairs from that
 * array A that sums up to N. You should print each pair once.
 * 
 * @author lucas
 *
 */
public class PrintSumPairs {

	public static void solve(int[] a, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer i : a) {
			map.put(i, (n - i));
		}

		for (Integer i : a) {
			if (map.containsKey(i)) {
				int rest = map.get(i);
				map.remove(i);
				if (map.containsKey(rest)) {
					System.out.println("(" + i + "," + rest + ")");
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 7, 2, 5, 6, 4, 1, 1 };
		solve(a, 5);

	}

}
