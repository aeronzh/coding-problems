package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringConstruction {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			String str = in.next();
			int[] count = new int[26];
			char[] ch = str.toCharArray();
			for (char c:ch) {
				count[c - 97] = 1;
			}
			
			
			int sum = 0;
			for (int c:count) {
				sum += c;
			}
			
			System.out.println(sum);
		}
		
		
	}
}
