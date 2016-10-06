package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WoC_23_4 {
    private static final int MOD = 1000000007;


    private static boolean checkIfKey(String str, String sub) {
        int i = 0;
        int n = str.length();

        if (n % sub.length() != 0) {
            return false;
        }

        while (i<n/sub.length()) {
            String other = str.substring(i*sub.length(),i*sub.length()+sub.length());
            if (!other.equals(sub)) {
                return false;
            }
            i++;
        }

        return true;
    }

    private static void solve(String s, int m) {
        long total = 0;
        double n = s.length();

        String key = null;
        for (int i=1; i<=n; i++) {
            String sub = s.substring(0, i);
            if (checkIfKey(s, sub)) {
                key = sub;
                break;
            }
        }

        if (key != null) {
            System.out.println((m / key.length())%MOD);
        } else {
            System.out.println(0);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        String s = in.next();
        int m = in.nextInt();

        solve(s, m);

    }
}
