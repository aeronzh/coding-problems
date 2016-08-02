package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class MakeLargestNumberPalidrome {
    private static void maxSide(int[] a) {
        for (int i = 0; i < a.length; i++) {

        }
    }


    private static String print(int[] a) {
        Arrays.sort(a);
        return a[0] + " " + a[1] + " " + a[2];
    }

    public static String reverseString(String str) {
        char[] strCharacters = str.toCharArray();

        int len = strCharacters.length;
        int middle = len / 2;
        char tmp;
        for (int charIndex = 0; charIndex < middle; charIndex++) {
            tmp = strCharacters[charIndex];
            strCharacters[charIndex] = strCharacters[len - charIndex - 1];
            strCharacters[len - charIndex - 1] = tmp;
        }

        return new String(strCharacters);
    }


    private static void solve(int n, int k, String num) {

        if (k >= n) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sb.append("9");
            }
            System.out.println(sb.toString());
            return;
        }

        char[] c = num.toCharArray();
        char[] r = reverseString(num).toCharArray();

        int mid = n / 2;

        // find number of differences first
        int diff = 0;
        for (int i = 0; i < mid; i++) {
            if (c[i] != r[i]) {
                diff++;
            }
        }
        System.out.println(diff);


        int op = 0;
        if (diff*2 <= k && diff % 2 == 0) {
            for (int i = 0; i < mid; i++) {
                if (c[i] != r[i]) {
                    if (op + 2 <= k) {
                        if (c[i] - '0' < 9) {
                            c[i] = '9';
                            op++;
                        }
                        if (c[n - i - 1] - '0' < 9) {
                            c[n - i - 1] = '9';
                            r[i]= '9';
                            op++;
                        }
                    }
                }
            }
        }

        System.out.println(new String(c) + "  " + op);

        for (int i = 0; i <= mid; i++) {
            if (op < k) {
                if (c[i] != r[i]) {
                    if (c[i] - '0' > r[i] - '0') {
                        c[n - i - 1] = c[i];
                    } else {
                        c[i] = c[n - i - 1];
                    }
                    op++;
                }
            }
        }

        System.out.println(new String(c) + "  " + op);

        int i = 0;
        while (op < k && i <= mid) {
            if (c[i] - '0' < 9) {
                if (op + 2 <= k) {
                    c[i] = '9';
                    c[n - i - 1] = '9';
                    op++;
                    op++;
                }
            }
            i++;
        }

        if (k - op == 1) {
            if (n % 2 == 1) {
                c[n / 2] = '9';
            }
        }


        String palidrome = new String(c);
        if (palidrome.equals(reverseString(palidrome))) {
            System.out.println(palidrome);
        } else {
            System.out.println("-1");
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String num = scanner.next();

        solve(n, k, num);

    }
}
