package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.
 * <p/>
 * door
 * <p/>
 * But, to lock the door he needs a key that is an anagram of a certain palindrome string.
 * <p/>
 * The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string can be a palindrome or not.
 */
public class GameOfThrones {

    private static String solve(String str) {
        Map<Character, Integer> char2count = new HashMap<Character, Integer>();
        char[] strChars = str.toCharArray();

        for (int i = 0; i < strChars.length; i++) {
            if (!char2count.containsKey(strChars[i])) {
                char2count.put(strChars[i], 1);
            } else {
                int count = char2count.get(strChars[i]);
                count++;
                char2count.put(strChars[i], count);
            }
        }

        int odds = 0;
        for (Character key : char2count.keySet()) {
            int count = char2count.get(key);
            if (count % 2 != 0) {
                odds++;
                if (odds > 1) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solve(str));

    }
}
