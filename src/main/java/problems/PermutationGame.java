package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

	/**
	 * Returns true if the sequence a represented by mask is strictly increasing
	 * 
	 * Example: a: 5 3 2 1 4 mask: 0 0 0 1 1 --> Returns true
	 * 
	 * @param a
	 * @param mask
	 * @return
	 */
	private static boolean isIncreasing(int[] a, int mask) {
		int n = a.length;
		int lastNonZero = 0;
		while (lastNonZero < n && (mask & (1 << (n - lastNonZero - 1))) == 0) {
			lastNonZero++;
		}

		int i = lastNonZero + 1;
		while (i < n && (mask & (1 << (n - i - 1))) == 0) {
			i++;
		}

		while (i < n) {
			if (a[i] <= a[lastNonZero]) {
				return false;
			}

			lastNonZero = i;
			i++;

			while (i < n && (mask & (1 << (n - i - 1))) == 0) {
				i++;
			}
		}

		return true;
	}

	/**
	 * Given a mask 10110 it returns the direct next mask that can be derived by
	 * zeroing out a set bit.
	 * 
	 * Example: 10110 --> 10100 10010 110
	 * 
	 * @param mask
	 * @return
	 */
	private static List<Integer> nextMask(int mask) {
		//		System.out.print(Integer.toBinaryString(mask) + " --> ");

		List<Integer> list = new ArrayList<Integer>();
		int bit = 1;
		while (bit <= mask) {
			int newMask = mask;
			while (bit <= mask && ((mask & bit) == 0)) {
				bit = bit << 1;
			}

			newMask &= ~(bit);
			list.add(newMask);
			bit = bit << 1;
		}

		//		for (int nextMask : list) {
		//			System.out.print(Integer.toBinaryString(nextMask) + "  ");
		//		}
		//		System.out.println();

		return list;
	}

	private static boolean isWinning(boolean[] isIncreasing, List<Integer>[] next, int current) {
		for (int nextMove : next[current]) {
			if (!isIncreasing[nextMove]) {
				return false;
			}
		}

		return true;
	}
	
	private static void generateWinningArray(boolean[] isIncreasing, List<Integer>[] next, int max, int current, boolean[] winning) {

		if (next[current].size() == 1) {
			winning[current] = false;
		} else {
			
			for (int child : next[current]) {
				generateWinningArray(isIncreasing, next, max, child, winning);
			}
			
			boolean allChildsLose = true;
			for (int child : next[current]) {
				if (winning[child]) {
					allChildsLose = false;
				}
			}
			
			if (!allChildsLose) {
				winning[current] = false;
			} else {
				winning[current] = true;
			}
			
			if (isIncreasing[current]) {
				winning[current] = false;
			} 
		}
	}

	private static void solve(int[] a) {
		int n = a.length;

		// isIncreasing[i] = true if seq with mask i is an increasing seq, thus player given that mask looses. False otherwise.
		int max = (1 << n);
		boolean[] isIncreasing = new boolean[max];
		List<Integer>[] next = new ArrayList[max];

		for (int i = 1; i <= max - 1; i++) {
			isIncreasing[i] = isIncreasing(a, i);
			next[i] = nextMask(i);
		}
		
		boolean[] winning = new boolean[max];
		generateWinningArray(isIncreasing, next, max, (max-1), winning);
		
		for (int i = 1; i <= max - 1; i++) {
			System.out.println(Integer.toBinaryString(i) + (winning[i] ? " --> winning" : ""));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);
		Scanner output = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		int tests = scanner.nextInt();
		for (int t = 0; t < tests; t++) {

			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}

			solve(a);
		}

	}
}
