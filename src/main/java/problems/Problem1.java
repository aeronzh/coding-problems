package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class Problem1 {

    private static void solve(String[] times) {
        int n = times.length;
        Arrays.sort(times);

        int min = Integer.MAX_VALUE;

        for (int i=1; i<n; i++) {
            String[] parts1 = times[i-1].split(":");
            int h1 = Integer.parseInt(parts1[0]);
            int m1 = Integer.parseInt(parts1[1]);

            String[] parts2 = times[i].split(":");
            int h2 = Integer.parseInt(parts2[0]);
            int m2 = Integer.parseInt(parts2[1]);

            int dm = (60 - m1) + m2 ;
            int dh = 0;
            if (h1 == 0 && h2 < 24) {
                dh = 23 - h2;
            } else if (h1 == 0 && h2 == 24) {
                dh = 0;
            } else {
                dh = h2 - h1;
            }

            int delta = dh*60 + dm;
            min = Math.min(min, delta);
        }

        // Circle
        String[] parts1 = times[0].split(":");
        int h1 = Integer.parseInt(parts1[0]);
        int m1 = Integer.parseInt(parts1[1]);

        String[] parts2 = times[n-1].split(":");
        int h2 = Integer.parseInt(parts2[0]);
        int m2 = Integer.parseInt(parts2[1]);

        int dm = (60 - m2) + m1;
        int dh = (23 - h2) + h1;
        int delta = dh*60 + dm;
        min = Math.min(min, delta);

        System.out.println(min);
    }


    private static void solve2(String[] times) {


    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);

        String t = "Shilpa|500|California|63";
        String[] parts = t.split("\\|");
        System.out.println();

    }
}
