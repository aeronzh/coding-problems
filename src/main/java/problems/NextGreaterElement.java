package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The
 * Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1.
 * 
 * @author lucas
 *
 */
public class NextGreaterElement {
	// 4, 5, 2, 25
	private static void solve(int[] a) {
		int n = a.length;
		Deque<Integer> stack = new ArrayDeque<Integer>();

		stack.push(a[0]);
		for (int i = 1; i < n; i++) {

			int next = a[i];

			while (!stack.isEmpty()) {
				int elem = stack.pop();
				if (next > elem) {
					System.out.println(elem + " " + next);
				} else {
					stack.push(elem);
					break;
				}
			}

			stack.push(next);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " -1");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		solve(a);
	}
}
