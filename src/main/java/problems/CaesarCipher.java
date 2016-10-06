package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Julius Caesar protected his confidential information by encrypting it in a cipher. Caesar's cipher rotated every letter in a string by a fixed number, K,
 * making it unreadable by his enemies. Given a string, S, and a number, K, encrypt  and print the resulting string.
 */
public class CaesarCipher {

    private static void solve(char[] str, int n, int k) {
        for (int i=0; i<n; i++) {
            char c = str[i];
            char newC = str[i];
            if (c>='a' && c<='z') {
                newC = (char)('a' + ((c - 'a' + k) % 26));
            } else if (c>='A' && c<='Z') {
                newC = (char)('A' + ((c - 'A' + k) % 26));
            }

            str[i] = newC;
        }

        System.out.println(new String(str));
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        char[] str = in.next().toCharArray();
        int k = in.nextInt();

        solve(str, n, k);
    }
}
