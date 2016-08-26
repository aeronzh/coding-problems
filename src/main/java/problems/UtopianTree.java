package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UtopianTree {
	
	private static void solve(int n) {
		int h = 1;
		
		boolean dbl = true;
		for (int i=0; i<n; i++) {
			if (dbl) {
				h *= 2;
				dbl = false;
			} else {
				h++;
				dbl = true;
			}
		}
		
		System.out.println(h);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t=0; t<tests; t++) {
			int n = in.nextInt();
			solve(n);
		}
		
	}
}
