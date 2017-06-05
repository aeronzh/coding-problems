package problems;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://lucaslouca.com/longest-substring-without-repeating-characters-challenge/
 */
public class LongestSubstringWithoutRepeatingChar {
    static public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0;

        int start = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                // We have already added the character to our substring

                ans = Math.max(ans, i - start);

                boolean found = false;
                do {
                    found = s.charAt(start) == s.charAt(i);
                    set.remove(s.charAt(start));
                    start++;
                } while (!found);

                set.add(s.charAt(i));
            }
        }


        return Math.max(ans, n - start);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("c"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
