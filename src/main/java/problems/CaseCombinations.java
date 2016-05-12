package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write code to generate all possible case combinations of a given lower-cased string. (e.g.
 * "0ab" -> ["0ab", "0aB", "0Ab", "0AB"]
 */
public class CaseCombinations {
    private static List<String> alphabet = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));

    private static void solve(String str, String current) {
        if (str.isEmpty()) {
            System.out.println(current);
        } else {
            String ch = str.substring(0,1);

            solve(str.substring(1, str.length()), current + ch);

            if (alphabet.contains(ch)) {
                solve(str.substring(1, str.length()), current + ch.toUpperCase());
            }
        }
    }

    public static void main(String[] args) {
        solve("0ab", "");
    }
}
