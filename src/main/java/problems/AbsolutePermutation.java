package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by lucas on 21/05/16.
 */
public class AbsolutePermutation {

    private static void print(int[] p) {
        for (int i = 1; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }


    private static void checkAndPrint(int[] p, int k) {
        // check first
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < p.length; i++) {
            if (Math.abs(p[i] - i) != k || set.contains(p[i]) || p[i] == 0) {
                System.out.println("-1");
                return;
            }
            set.add(p[i]);
        }

        for (int i = 1; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }

    private static void solve(int n, int k) {
        if (k>0 && n % (2*k) != 0) {
            System.out.println("-1");
            return;

        }

        int[] p = new int[n + 1];

        int index = 1;
        Set<Integer> set = new HashSet<Integer>();
        while (index <= n) {
            while (index - k < 1) {
                p[index] = index + k;
                set.add(p[index]);
                index++;
            }

            if (!set.contains(index - k)) {
                p[index] = index - k;
            } else {
                p[index] = index + k;
            }
            set.add(p[index]);
            index++;

        }

//        print(p);
        checkAndPrint(p, k);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);


        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] p = new int[n + 1];


            solve(n, k);

        }

    }
}
