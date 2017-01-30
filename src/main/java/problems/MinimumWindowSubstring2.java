package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucas on 29/01/2017.
 */
public class MinimumWindowSubstring2 {

    public static String minWin(String s, String t) {
        String ans = "";

        // Build a count map that holdshow often each character in t appears
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }
        }


        Map<Character, Integer> count = new HashMap<>();
        int n = s.length();
        int start = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (start == -1 && dict.containsKey(c)) {
                // Detected first character included in target string
                start = i;
            }

            // Added current character to count
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }

            // Check if we have all required characters
            boolean complete = true;
            for (Character key : dict.keySet()) {
                if (count.containsKey(key)) {
                    if (count.get(key) < dict.get(key)) {
                        complete = false;
                        break;
                    }
                } else {
                    complete = false;
                    break;
                }
            }

            if (complete) {
                end = i;
            }

            char tmp = s.charAt(start);
            if (complete && tmp == s.charAt(i)) {
                while (!dict.containsKey(tmp) || count.get(tmp) > dict.get(tmp)) {
                    count.put(tmp, count.get(tmp) - 1);
                    start++;
                    tmp = s.charAt(start);
                }
            }

            if (ans.isEmpty() || (end - start) < ans.length()) {
                ans = s.substring(start, end + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minWin("ADOBECODEBANC", "ABC"));
        System.out.println(minWin("this is a test string", "tist")); // t stri

    }
}
