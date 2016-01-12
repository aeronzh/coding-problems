package problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * (Note: The result may be very large, so you need to return a string instead
 * of an integer.)
 * 
 * @author lucas
 *
 */
public class LargestNumber {

	public static long solve(int[] array) {
		String[] str = new String[array.length];
		for (int i=0; i<array.length; i++) {
			str[i] = ""+array[i];
		}
		
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String a, String b) {
				String s1 = a + b;
				String s2 = b + a;
				return s1.compareTo(s2);
			}
		});
		
		String result = "";
		for (int i=str.length-1; i>=0; i--) {
			result = result + str[i];
		}
		
		return new Long(result);
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{3, 30, 34, 5, 9};
		System.out.println(solve(array));
	}

}
