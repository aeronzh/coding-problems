package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Manasa is out on a hike with friends. She finds a trail of stones with
 * numbers on them. She starts following the trail and notices that two
 * consecutive stones have a difference of either a or b. Legend has it that
 * there is a treasure trove at the end of the trail and if Manasa can guess the
 * value of the last stone, the treasure would be hers. Given that the number on
 * the first stone was 0, find all the possible values for the number on the
 * last stone.
 * 
 * Note: The numbers on the stones are in increasing order.
 * 
 * @author lucas
 *
 */
public class ManasaAndStones {

	private static void solve2(int n, int a, int b) {
		Set<Integer> solution = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			int last = i * b + (n - i - 1) * a;
			solution.add(last);
		}

		for (int v : solution) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

	private static void solve(int n, int a, int b, int current, int value, Set<Integer> solution) {
		if (current == n) {
			solution.add(value);
		} else {
			solve(n, a, b, current + 1, value + a, solution);
			solve(n, a, b, current + 1, value + b, solution);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt(); // number of stones
			int a = in.nextInt();
			int b = in.nextInt();

			//			Set<Integer> solution = new TreeSet<Integer>();
			//			solve(n,a,b,1,0, solution);
			//
			//
			//			for (int v:solution) {
			//				System.out.print(v+" ");
			//			}
			//			System.out.println();

			solve2(n, a, b);

		}

	}

}
