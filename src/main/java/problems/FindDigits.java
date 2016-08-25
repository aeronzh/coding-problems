package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Given an integer, N , traverse its digits (d1,d2,...,dn) and determine how
 * many digits evenly divide N (i.e.: count the number of times N divided by
 * each digit i has a remainder of 0). Print the number of evenly divisible
 * digits.
 * 
 * Note: Each digit is considered to be unique, so each occurrence of the same
 * evenly divisible digit should be counted (i.e.: for N=111, the answer is 3).
 * 
 * @author lucas
 *
 */
public class FindDigits {
	private static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private static int[] intToArray(int n) {
		int length = 0;
		
		int num = n;
		while (num>0) {
			length++;
			num /= 10;
		}
		
		int[] ans = new int[length];
		int index = length-1;
		while (n>0) {
			ans[index--] = n % 10;
			n /= 10;
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t=0; t<tests; t++) {
			int num = in.nextInt();
			int[] a = intToArray(num);
			int count = 0;
			
			for (int d:a) {
				if (d>0 && num % d == 0) {
					count++;
				}
			}
			
			System.out.println(count);
		}
		
	}
}
