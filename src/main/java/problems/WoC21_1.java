package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WoC21_1 {

    private static String solve(int x1, int v1, int x2, int v2) {
        if (x1 >= x2 && v1 > v2) {
            return "NO";
        }

        if (x2 >= x1 && v2 > v1) {
            return "NO";
        }


        int dv = Math.abs(v1 - v2);
        int dx = Math.abs(x1 - x2);

        double d = (double) dx / (double) dv;
        if ((d == Math.floor(d)) && !Double.isInfinite(d)) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();


        System.out.println(solve(x1, v1, x2, v2));
    }
}
