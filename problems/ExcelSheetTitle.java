package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet. For example:
 * 
 * 1 -> A
 * 
 * 2 -> B
 * 
 * 3 -> C
 * 
 * ...
 * 
 * 26 -> Z
 * 
 * 27 -> AA
 * 
 * 28 -> AB
 * 
 * @author lucas
 *
 */
public class ExcelSheetTitle {

	public static String solve(int n) {
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		for (int i = 1; i <= 26; i++) {
			map.put(i, (char) ((char) i + 64));
		}

		int rest = 0;
		String str = "";
		while (n > 0) {
			rest = n % 26;
			if (rest == 0) {
				rest = 26;
			}
			str = map.get(rest) + str;
			n = n / 26;
		}

		return str;
	}

	public static void main(String[] args) {
		System.out.println(solve(1));
		System.out.println(solve(2));
		System.out.println(solve(3));
		System.out.println(solve(26));
		System.out.println(solve(27));
		System.out.println(solve(28));

	}

}
