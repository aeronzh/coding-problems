package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PasswordCracker {
	static Set<String> cache; // memoization

	private static boolean isValid(String loginAttempt, Set<String> pass, List<String> out) {
		boolean ans = false;

		if (cache.contains(loginAttempt)) {
			return false;
		}

		if (pass.contains(loginAttempt)) {
			out.add(loginAttempt);
			return true;
		} else {
			cache.add(loginAttempt);
		}

		for (int i = 0; i < loginAttempt.length(); i++) {
			String left = loginAttempt.substring(0, i);
			String right = loginAttempt.substring(i);
			ans = isValid(left, pass, out) && isValid(right, pass, out);
			if (ans) {
				return true;
			}
		}

		return ans;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 1; t <= tests; t++) {
			int n = in.nextInt();
			Set<String> pass = new HashSet<String>();
			for (int i = 0; i < n; i++) {
				pass.add(in.next());
			}
			String loginAttempt = in.next();

			List<String> out = new LinkedList<String>();
			cache = new HashSet<String>();
			boolean res = isValid(loginAttempt, pass, out);
			if (res) {
				for (String p : out) {
					System.out.print(p + " ");
				}
			} else {
				System.out.print("WRONG PASSWORD");
			}
			System.out.println();
		}
	}
}
