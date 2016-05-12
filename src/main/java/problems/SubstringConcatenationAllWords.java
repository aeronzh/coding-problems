package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s="barfoothefoobarman" & words=["foo", "bar"], return
 * [0,9].
 * 
 * That is, the substring "barfoo" is a concatenation of all words in words[]
 * ("bar" and "foo") and contains them exactly once. Similarly with the
 * substring "foobar" at index 9.
 * 
 * @author lucas
 *
 */
public class SubstringConcatenationAllWords {

	public static List<Integer> solve(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();

		int wordLen = words[0].length();
		int wordCount = words.length;

		INDEX_LOOP: for (int index = 0; index < s.length() - (wordCount * wordLen); index++) {

			Map<String, Integer> word2count = new HashMap<String, Integer>();
			for (String word : words) {
				word2count.put(word, 0);
			}

			String substr;
			int start = index;
			for (int i = 0; i < wordCount; i++) {
				substr = s.substring(start, start + wordLen);
				if (word2count.containsKey(substr)) {
					int count = word2count.get(substr);
					word2count.put(substr, count + 1);
				}
				start += wordLen;
			}

			for (String key : word2count.keySet()) {
				if (word2count.get(key) != 1) {
					continue INDEX_LOOP;
				}
			}

			result.add(index);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solve("barfoothefoobarman", new String[] { "foo", "bar" }));

	}

}
