package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given two strings, A and B. Find if there is a substring that appears in both A and B.

 * Created by lucas on 28/02/16.
 */
public class TwoStrings {

    public static String solve(String a, String b) {
        Set<Character> setA = new HashSet<Character>();
        for (char c:a.toCharArray()) {
            setA.add(c);
        }

        for (char c:b.toCharArray()) {
            if (setA.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        String a = "hi";
        String b = "world";

        System.out.println(solve(a,b));
    }
}
