package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class FindCelebrity {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i = 1; i <= n; i++) {
			stack.push(i);
		}

		boolean[][] knows = new boolean[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			knows[a][b] = true;
		}

		while (stack.size() > 1) {
			int a = stack.pop();
			int b = stack.pop();
			if (knows[a][b]) {
				stack.push(b);
			} else {
				stack.push(a);
			}
		}

		int candidate = stack.poll();

		// Verify that candidate is a celebrity
		for (int i = 1; i <= n; i++) {
			if (i != candidate && (!knows[i][candidate] || knows[candidate][i])) {
				System.out.println("No celebrity in party!");
				return;
			}
		}

		System.out.println("Celebrity is " + candidate);
	}
}
