package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * Logan is cleaning his apartment. In particular, he must sort his old favorite
 * sequence, P , of N positive integers in nondecreasing order. He's tired from
 * a long day, so he invented an easy way (in his opinion) to do this job. His
 * algorithm can be described by the following pseudocode:
 * 
 * while isNotSorted(P) do {
 * 
 * WaitOneMinute();
 * 
 * RandomShuffle(P)
 * 
 * }
 * 
 * Can you determine the expected number of minutes that Logan will spend
 * waiting for P to be sorted?
 * 
 * Here's an explanation of question: Let probablity of occurence of sorted
 * order be p and of not occurence be q.Now probablity of first iteration would
 * be just p.For 2nd iteration it would be qxp, for 3rd, qxqxp, so on.So, the
 * sum would be 1xp + 2xqxp + 3xqxqxp +4xqxqxqxp.....to infinity.Its an
 * arithmetico-geometric series !!! Hope it helps
 * 
 * @author lucas
 *
 */
public class Bogosort {
	private static final int MAX_P = 100;

	private static boolean isSorted(int[] p, int n) {
		for (int i = 1; i < n; i++) {
			if (p[i] < p[i - 1]) {
				return false;
			}
		}

		return true;
	}

	private static long fact(int n) {
		long ans = 1;
		for (int i = 1; i <= n; i++) {
			ans *= i;
		}

		return ans;
	}

	/**
	 * The number of different permutations of n objects, where there are n1
	 * indistinguishable objects of style 1, n2 indistinguishable objects of
	 * style 2, ..., and nk indistinguishable objects of style k, is:
	 * <p>
	 * n!/(n1! * n2! * ... * nk!)
	 *
	 * @return Number of unique permutations with repetition
	 */
	public static long unique(int[] p, int n) {
		long ans = 1;

		long numerator = fact(n);

		int[] count = new int[MAX_P + 1];
		for (int i = 0; i < n; i++) {
			count[p[i]] = count[p[i]] + 1;
		}

		long denominator = 1;

		for (int i = 1; i <= MAX_P; i++) {
			denominator = denominator * fact(count[i]);
		}

		ans = numerator / denominator;

		return ans;
	}

	private static double solve(int[] p, int n) {
		if (isSorted(p, n)) {
			return 0.0;
		}

		double totalUnique = unique(p, n);

		// Probability of each individual permutation where sequence is sorted
		double probSorted = 1.0 / totalUnique;

		// Probability of each individual permutation where sequence is not sorted
		double probUnsorted = 1.0 - probSorted;

		double ans = probSorted * 1 / (probSorted * probSorted);

		return Math.round(ans * 1000000D) / 1000000D;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = scanner.nextInt();
		}

		System.out.printf("%.6f", solve(p, n));
	}
}
