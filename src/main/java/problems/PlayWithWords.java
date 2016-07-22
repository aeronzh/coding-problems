package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Shaka and his brother have created a boring game which is played like this:
 * 
 * They take a word composed of lowercase English letters and try to get the
 * maximum possible score by building exactly 2 palindromic subsequences. The
 * score obtained is the product of the length of these 2 subsequences.
 * 
 * Let's say A and B are two subsequences from the initial string. If A_i & A_j
 * are the smallest and the largest positions (from the initial word)
 * respectively in A; and B_i & B_j are the smallest and the largest positions
 * (from the initial word) respectively in B, then the following statements hold
 * true:
 * 
 * A_i <= A_j
 * 
 * B_i <= B_j
 * 
 * A_j < B_i
 * 
 * i.e., the positions of the subsequences should not cross over each other.
 * 
 * Hence the score obtained is the product of lengths of subsequences A & B.
 * Such subsequences can be numerous for a larger initial word, and hence it
 * becomes harder to find out the maximum possible score. Can you help Shaka and
 * his brother find this out?
 * 
 * Input Format Input contains a word S composed of lowercase English letters in
 * a single line.
 * 
 * Output Format Output the maximum score the boys can get from S.
 * 
 * Constraints
 * 
 * each character will be a lower case english alphabet.
 * 
 * Sample Input:
 * 
 * eeegeeksforskeeggeeks
 * 
 * Sample
 * 
 * 
 * Output:
 * 
 * 50
 * 
 * Explanation
 * 
 * A possible optimal solution is eee-g-ee-ksfor-skeeggeeks being eeeee the one
 * subsequence and skeeggeeks the other one. We can also select eegee in place
 * of eeeee, as both have the same length.
 * 
 * 
 * @author lucas
 *
 */
public class PlayWithWords {

	private static int[][] longestPalidromicSubsequence(String s) {
		int n = s.length();
		char[] str = s.toCharArray();
		int[][] l = new int[n][n]; // l[i][j] holds length of longest palidromic subsequence in range i..j 

		for (int i = 0; i < n; i++) {
			l[i][i] = 1;
		}

		for (int fill = 0; fill < n; fill++) {
			for (int end = fill + 1; end < n; end++) {
				int start = end - fill - 1;

				if (str[start] == str[end] && start + 1 == end) {
					l[start][end] = 2;
				} else if (str[start] == str[end]) {
					l[start][end] = l[start + 1][end - 1] + 2;
				} else {
					l[start][end] = Math.max(l[start + 1][end], l[start][end - 1]);
				}
			}
		}

		return l;
	}

	private static int solve(String s) {
		int n = s.length();
		int[][] len = longestPalidromicSubsequence(s);
		int max = Integer.MIN_VALUE;

		for (int cutOff = 0; cutOff < n - 1; cutOff++) {
			int left = len[0][cutOff];
			int right = len[cutOff + 1][n - 1];
			max = Math.max(left * right, max);
		}

		return max;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		String s = in.next();
		System.out.println(solve(s));

	}

}
