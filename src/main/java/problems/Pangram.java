package problems;

/**
 * Created by lucas on 27/02/16.
 */
public class Pangram {
    private static String solve(String str) {
        int[] alphabet = new int[26];

        for (char c:str.toCharArray()) {
            int ch = Character.toUpperCase(c);
            if (ch>='A' && ch<='Z') {
                alphabet[ch - 65] = 1;
            }
        }

        int count = 0;
        for (int c=0; c<alphabet.length; c++) {
            count += alphabet[c];
        }

        return (count == alphabet.length) ? "pangram" : "not pangram";
    }


    public static void main(String[] args) {
        String str1 = "We promptly judged antique ivory buckles for the next prize";

        System.out.println(solve(str1));
    }
}
