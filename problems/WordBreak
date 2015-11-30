package com.lucaslouca.other;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author lucas
 *
 */
public class WordBreak {

	public static boolean solve(String str, Set<String> dict, int start) {
		if (start == str.length()) {
			return true;
		} else {
			for (String word : dict) {
				int len = word.length();
				int end = start + len;
				if (end > str.length()) {
					continue;
				} else {
					if (str.substring(start, end).equals(word)) {
						if (solve(str, dict, end)) {
							return true;
						}
					}
				}
			}

			return false;
		}
	}

	/**
	 * Define an array t[] such that t[i]==true => 0-(i-1) can be segmented
	 * using dictionary.
	 * 
	 * Initial state t[0] == true
	 * 
	 * @param str
	 * @param dict
	 * @return
	 */
	public static boolean solveDynamic(String str, Set<String> dict) {
		boolean[] t = new boolean[str.length() + 1];
		t[0] = true;

		for (int i = 0; i < t.length; i++) {
			if (!t[i]) {
				continue;
			} else {
				for (String word : dict) {
					int len = word.length();
					int end = i + len;
					if (end > str.length()) {
						continue;
					} else {
						if (t[end]) {
							continue;
						} else if (str.substring(i, end).equals(word)) {
							t[end] = true;
						}
					}
				}
			}
		}

		return t[str.length()];
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(solve("leetcode", dict, 0));
		System.out.println(solveDynamic("leetcode", dict));
	}

}
