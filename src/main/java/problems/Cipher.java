package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cipher
 * @author lucas
 *
 */
public class Cipher {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();
		char[] c = in.next().toCharArray();

		int[] ans = new int[n];

		ans[0] = c[0] == '1' ? 1 : 0;
		int tmp = ans[0];
		for (int i = 1; i < n; i++) {
			if (i < k) {
				if (i >= 2) {
					tmp ^= ans[i - 1];
				}
			} else if (i >= k && i <= c.length - k) {
				tmp ^= ans[(i - k)];
				tmp ^= ans[i - 1];
			} else {
				tmp ^= ans[(i - k)];
			}

			if (c[i] == '0') {
				ans[i] = tmp;
			} else {
				ans[i] = tmp == 1 ? 0 : 1;
			}
		}

		for (int i : ans) {
			System.out.print(i);
		}

	}
}
