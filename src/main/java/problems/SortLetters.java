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

	private static String sort(String a, String b) {
		char[] charsA = a.toCharArray();
		Map<String, Integer> char2Pos = new HashMap<String, Integer>();
		for (int i=0; i<charsA.length; i++) {
			char2Pos.put(""+charsA[i], i);
		}
		
		char[] newStr = new char[b.length()];
		
		return null;
	}
	
	public static void main(String[] args) {

	}
	
}
