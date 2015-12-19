package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * @author lucas
 *
 */
public class Anagrams {

	public static List<List<String>> solve(String[] array) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> sortedToList = new HashMap<String, List<String>>();
		String key;
		for (String str : array) {
			char[] strChars = str.toCharArray();
			Arrays.sort(strChars);
			key = new String(strChars);
			if (sortedToList.containsKey(key)) {
				sortedToList.get(key).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				sortedToList.put(key, list);
			}
		}

		for (Entry<String, List<String>> entry : sortedToList.entrySet()) {
			result.add(entry.getValue());
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solve(new String[] { "aaa", "abc", "aa", "cba", "bca", "bcaa", "xy", "yx" }));

	}

}
