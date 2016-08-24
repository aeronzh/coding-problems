package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Problem in the Workbook is special if its index within a chapter is the same as the page number where its located
// Print number of special problems in workbook
public class LisasWorkbook {

	private static void solve(int[] t, int n, int k) {
		int ans = 0;
		int pages = 1;
		for (int problemsOfChapter : t) {
			for (int p=1; p<=problemsOfChapter; p++) {
				
				if (p == pages) {
					ans++;
				}
				
				if (p % k == 0) {
					pages++;
				}
			}
			
			if (problemsOfChapter % k != 0) {
				pages++;
			}
		}

		
		System.out.println(ans);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(); // number of chapters 1..n
		int k = in.nextInt(); // number of problems per page
		int[] t = new int[n]; // number of problems per chapter

		for (int i = 0; i < n; i++) {
			t[i] = in.nextInt();
		}

		solve(t, n, k);
	}

}
