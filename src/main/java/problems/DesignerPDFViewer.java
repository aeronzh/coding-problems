package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DesignerPDFViewer {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int[] h = new int[26];
        for (int i=0; i<26; i++) {
            h[i] = in.nextInt();
        }

        String s = in.next();

        char[] str = s.toCharArray();
        int maxH = h[str[0] - 'a'];
        for (char c: str) {
            if (h[c - 'a'] > maxH) {
                maxH = h[c - 'a'];
            }
        }

        int ans = str.length * maxH;

        System.out.println(ans);

    }
}
