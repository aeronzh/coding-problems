package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HackerrankInAString {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int queries = in.nextInt();
		for (int q = 0; q < queries; q++) {
			char[] s = in.next().toCharArray();

			int cursor = 0;
			char[] hr = "hackerrank".toCharArray();
			for (int i = 0; i < s.length; i++) {
				if (s[i] == hr[cursor]) {
					cursor++;
				}

				if (cursor == hr.length) {
					System.out.println("YES");
					break;
				}
			}

			if (cursor != hr.length) {
				System.out.println("NO");
			}
		}
	}
}
