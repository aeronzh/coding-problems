package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortPalidrome {
	private static final int MOD = 1000000007;

	private static void print(int[][] a) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				System.out.print(a[r][c] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * When you process the characters, if you get a character C at position P,
	 * let's call the prefix as preStr, and postfix as postStr, all you want is
	 * to find how many a, b...z in preStr and how many subsequency Ca, Cb...Cz
	 * in postStr, then muliply each pair and sum them. For preStr it is just
	 * simply count. For postStr you need pre calculation.
	 * 
	 * - Keaton Sun
	 * 
	 * ghhggh
	 */
	private static long solve(String s) {
		if (s.length() < 2) {
			return 0;
		}

		// PRE-CALCULATION
		long[][] pre = new long[26][s.length()]; // pre['x' - 'a'][i] holds the number of 'x' that appear up till index i.
		pre[s.charAt(0) - 'a'][0] = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			for (char j = 'a'; j <= 'z'; j++) {
				pre[j - 'a'][i] = pre[j - 'a'][i - 1];
			}
			pre[c - 'a'][i] = pre[c - 'a'][i] + 1;
		}

		long ans = 0;
		long[][] post = new long[26][26]; // post['a']['b'][i] holds the number of 'ab' (no necessary consecutive) from and after index i
		//post[s.charAt(s.length() - 2) - 'a'][s.charAt(s.length() - 1) - 'a'] = 1;
		for (int i = s.length() - 2; i >= 0; i--) {

			char c = s.charAt(i);
			
			for (char x = 'a'; x <= 'z'; x++) {
				long preCount = 0;
				if (i > 0) {
					preCount = pre[x - 'a'][i - 1];
				}

				long postCount = post[c - 'a'][x - 'a'];
				long product = preCount * postCount;
				ans = (ans + product) % MOD;
			}
			
			
			for (char x = 'a'; x <= 'z'; x++) {

				// Since we have a new character c, we need to increase the entries of cx in post[][] for c starting from the current index i+1 
				// (exclude i because we have c at index i).
				// Number of x till end
				long end = pre[x - 'a'][s.length() - 1];

				// Number of x till i
				long start = pre[x - 'a'][i];

				long diff = end - start;

				// Number of cx from i till end
				post[c - 'a'][x - 'a'] = post[c - 'a'][x - 'a'] + diff;
			}


		}

		return ans;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		String s = in.next();
		long ans = solve(s);
		System.out.println(ans);
	}
}
