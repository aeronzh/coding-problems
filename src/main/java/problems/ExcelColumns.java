package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number. For example:
 * 
 * A -> 1
 * 
 * B -> 2
 * 
 * C -> 3
 * 
 * ...
 * 
 * Z -> 26
 * 
 * AA -> 27
 * 
 * AB -> 28
 * 
 * ...
 * 
 * AAA -> 703
 * 
 * @author lucas
 *
 */
public class ExcelColumns {

	public static int solve(String str) {
		char[] c = str.toCharArray();
		int sum = 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char a='A'; a<='Z'; a++) {
			map.put(a, ((int) a - 64));
		}
		
		int t = 0;
		for (int i = c.length-1; i >=0; i--) {
			sum += map.get(c[i])*Math.pow(26, t);
			t++;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(solve("A"));
		System.out.println(solve("B"));
        System.out.println(solve("Z"));
		System.out.println(solve("AA"));
		System.out.println(solve("AB"));
		System.out.println(solve("AAA"));
	}

}
