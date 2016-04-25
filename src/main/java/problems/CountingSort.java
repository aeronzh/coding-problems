package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingSort {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] countLessEq = new int[100];
		int[] count = new int[100];

		int[] number = new int[n];
		String[] value = new String[n];

		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(scanner.next());
			value[i] = scanner.next();
			count[number[i]] = count[number[i]] + 1;
			countLessEq[number[i]] = countLessEq[number[i]] + 1;
		}

		for (int i = 1; i < 100; i++) {
			countLessEq[i] = countLessEq[i] + countLessEq[i - 1];
		}

		int[] position = new int[n];
		for (int i = 0; i < n; i++) {
			if (position[number[i]] == 0) {
				position[number[i]] = countLessEq[number[i]] - count[number[i]];
			} else {
				position[number[i]] = position[number[i]] + 1;
			}
		}

		String[] result = new String[n];
		for (int i = 0; i < n; i++) {

			//			System.out.println("i= "+i+" pos="+position[i] + " ");
		}
	}
}
