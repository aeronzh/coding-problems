package problems;

import java.util.HashMap;
import java.util.Map;


/**
 * Sort the letters in one word (b) by the order they occur in another (a) in linear time.
 * 
 * @author lucas
 *
 */
public class SortLetters {

	private static String sort(String toSort, String order) {
		int[] char2count = new int[26];
		for (char c : toSort.toCharArray()) {
			char2count[c-'a'] = char2count[c-'a'] + 1;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : order.toCharArray()) {
			while (char2count[c-'a'] > 0) {
				sb.append(c);
				char2count[c-'a'] = char2count[c-'a'] - 1;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String toSort = "xyacbda";
		String order = "abc";
		
		System.out.println(sort(toSort, order));
		
	}
	
}
