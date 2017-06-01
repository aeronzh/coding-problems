package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/marcs-cakewalk
public class MarcsCakewalk {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();

		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = in.nextInt();
		}

		Arrays.sort(c);

		long miles = 0;
		for (int i = 0; i < n; i++) {
			miles += Math.pow(2, i) * c[n - i - 1];
		}

		System.out.println(miles);
	}

}
