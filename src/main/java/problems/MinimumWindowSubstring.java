package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 * <p>
 * For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
 *
 * @author lucas
 */
public class MinimumWindowSubstring {

    /**
     * 1) Build a count array count[] for string 2. The count array stores counts of characters. count['i'] = 1
     * count['t'] = 2 count['s'] = 1
     * <p>
     * 2) Scan the string1 from left to right until we find all the characters of string2. To check if all the
     * characters are there, use count[] built in step 1. So we have substring "this is a t" containing all characters
     * of string2. Note that the first and last characters of the substring must be present in string2. Store the length
     * of this substring as min_len.
     * <p>
     * 3) Now move forward in string1 and keep adding characters to the substring "this is a t". Whenever a character is
     * added, check if the added character matches the left most character of substring. If matches, then add the new
     * character to the right side of substring and remove the leftmost character and all other extra characters after
     * left most character. After removing the extra characters, get the length of this substring and compare with
     * min_len and update min_len accordingly.
     * <p>
     * Basically we add 'e' to the substring "this is a t", then add 's' and then 't'. 't' matches the left most
     * character, so remove 't' and 'h' from the left side of the substring. So our current substring becomes "is a
     * test". Compare length of it with min_len and update min_len.
     * <p>
     * Again add characters to current substring "is a test". So our string becomes "is a test str". When we add 'i', we
     * remove leftmost extra characters, so current substring becomes "t stri". Again, compare length of it with min_len
     * and update min_len. Finally add 'n' and 'g'. Adding these characters doesn't decrease min_len, so the smallest
     * window remains "t stri".
     * <p>
     * 4) Return min_len.
     * <p>
     * <p>
     * Input string1: "this is a test string" Input string2: "tist" Output string: "t stri"
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWin(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<Character, Integer>();
        char[] targetCharacters = t.toCharArray();

        for (int i = 0; i < targetCharacters.length; i++) {
            Character c = targetCharacters[i];
            if (targetMap.containsKey(c)) {
                targetMap.put(c, targetMap.get(c) + 1);
            } else {
                targetMap.put(c, 1);
            }
        }

        char[] sourceCharacters = s.toCharArray();
        Map<Character, Integer> sourceMap = new HashMap<Character, Integer>();
        int count = 0;
        int index = 0;
        for (int i = 0; i < sourceCharacters.length; i++) {
            Character c = sourceCharacters[i];
            if (targetMap.containsKey(c)) {
                if (sourceMap.containsKey(c)) {
                    // str = AABC, target = ABC ==> That way we don't increment count
                    // when targetMap.containsKey('A') is fulfilled twice for the 2 'A's.
                    if (sourceMap.get(c) < targetMap.get(c)) {
                        count++;
                    }
                    sourceMap.put(c, sourceMap.get(c) + 1);
                } else {
                    sourceMap.put(c, 1);
                    count++;
                }
            }

            if (count == t.length()) {
                index = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, index + 1));
        int minLen = sb.length();
        String window = sb.toString();
        for (int i = index + 1; i < sourceCharacters.length; i++) {
            char c = sourceCharacters[i];
            sb.append(c);
            if (sourceMap.containsKey(c)) {
                sourceMap.put(c, sourceMap.get(c) + 1);
            } else {
                sourceMap.put(c, 1);
            }

            if (c == sb.charAt(0)) {
                // remove extra characters
                int tmp = 0;
                char tmpChar = sb.charAt(tmp);
                while (!targetMap.containsKey(tmpChar) || (targetMap.containsKey(tmpChar) && sourceMap.get(tmpChar) > targetMap.get(tmpChar))) {
                    if (targetMap.containsKey(tmpChar) && sourceMap.get(tmpChar) > targetMap.get(tmpChar)) {
                        sourceMap.put(tmpChar, sourceMap.get(tmpChar) - 1);
                    }
                    tmp++;
                    tmpChar = sb.charAt(tmp);
                }

                if (sb.substring(tmp, sb.length()).length() <= minLen) {
                    window = sb.substring(tmp, sb.length());
                    sb.replace(0, sb.length(), window);
                    minLen = window.length();
                }
            }
        }


        return window;
    }

    public static void main(String[] args) {
        System.out.println(minWin("ADOBECODEBANC", "ABC"));
        System.out.println(minWin("this is a test string", "tist"));

    }

}
