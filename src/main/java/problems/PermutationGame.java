package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Alice and Bob play the following game:
 * 
 * They choose a permutation of the first numbers to begin with. They play
 * alternately and Alice plays first. In a turn, they can remove any one
 * remaining number from the permutation. The game ends when the remaining
 * numbers form an increasing sequence. The person who played the last turn
 * (after which the sequence becomes increasing) wins the game. Assuming both
 * play optimally, who wins the game?
 * 
 * Input Format:
 * 
 * The first line contains the number of test cases . test cases follow. Each
 * case contains an integer on the first line, followed by a permutation of the
 * integers on the second line.
 * 
 * Output Format:
 * 
 * Output lines, one for each test case, containing "Alice" if Alice wins the
 * game and "Bob" otherwise.
 * 
 * 
 * @author lucas
 *
 */
public class PermutationGame {
	private static enum Player {
		Alice, Bob
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static boolean isIncreasing(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] != 0 && a[i] <= a[i - 1]) {
				return false;
			}
		}

		return true;
	}

	private static boolean alice = true;

	// Bob
	// 12 10 5 3 4 9 7 2 1 8 13 6 11
	// 7
	private static int inversions(int[] a, int n) {
		int inversions = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i < j && a[i] > a[j] && a[i] != 0 && a[j] != 0) {
					inversions++;
				}
			}
		}

		return inversions;
	}

	private static String result;
	private static int aliceCount = 0;
	private static int bobCount = 0;

	private static void brute(int[] a, Player p, int n) {
		result = p.toString();

		int inversions = inversions(a, n);
		if (inversions > 1) {
			for (int i = 0; i < n; i++) {
				if (a[i] != 0) {
					int tmp = a[i];
					a[i] = 0;
					inversions = inversions(a, n);
					boolean optimal = (inversions % 2 == 1);
					if (optimal) {
						Player next = (p == Player.Alice) ? Player.Bob : Player.Alice;
						brute(a, next, n);
					}
					a[i] = tmp;
				}
			}
		} else {
			if (p == Player.Alice) {
				bobCount++;
			} else {
				aliceCount++;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);
		Scanner output = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		int tests = scanner.nextInt();
		for (int t = 0; t < tests; t++) {
			aliceCount = 0;
			bobCount = 0;
			result = "";

			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}

			brute(a, Player.Alice, n);

			String expected = output.next();

			if (result.equals(expected)) {
				System.out.println(result);
			} else {
				System.out.println("*** Got " + result + "  expected: " + expected);
			}
		}

	}
}
