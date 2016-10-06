package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MayorAndLasers {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // number of buildings
        int[] h = new int[n];

        for (int i=0; i<n; i++) {
            h[i] = in.nextInt();
        }

        int m = in.nextInt(); // number of lasers
        int[] l = new int[m];

        for (int i=0; i<m; i++) {
            l[i] = in.nextInt();
        }
    }
}
