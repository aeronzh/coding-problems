package problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Beautiful3Set {
    private static void print(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static Integer[] rotate(int[] a, int k) {
       Integer[] ans = new Integer[a.length];
        for (int i=0; i<a.length; i++) {
            ans[i] = a[i];
        }

        int n = a.length - 1;

        int rotations = k % ans.length;
        for (int rot = 1; rot <= rotations; rot++) {
            // Rotate by 1. That is last element becomes first, the rest shifts to the right by one.
            int last = ans[n];
            for (int i = n; i >= 1; i--) {
                ans[i] = ans[i - 1];
            }
            ans[0] = last;
        }

        return ans;
    }

    private static void solve(int n) {
        int count = 0;
        Set<Integer[]> set = new HashSet<Integer[]>();

        for (int start = 0; start <= n; start++) {
            int min = start + (start + 1) + (start + 2); // (0, 1, 2) = 0 +1 + 2 = 3
            if (min <= n) {
                int tupleSize = 3;
                int d = (n - min) / tupleSize;
                int remain = (n - min) % tupleSize;

                // We need to distribute the remain on some nodes. Since remain is always smaller than tupleSize,
                // we will distribute it (in addition to d) on the last remain nodes (tupleSize-remain).
                int[] tuple = new int[tupleSize];
                int index = 0;
                for (int i = start + tupleSize - remain; i < tupleSize; i++) {
                    tuple[index++] = i + d + 1;
                }
                for (int i = start; i < tupleSize - remain; i++) {
                    tuple[index++] = i + d;
                }

                int sum = tuple[0] + tuple[1] + tuple[2];
                if (sum == n) {
                    count += 3;
                    for (int i = 0; i < tupleSize; i++) {
                        Integer[] b = rotate(tuple.clone(), i);
                        set.add(b);
                    }
                }
            }
        }

        System.out.println(count);
        for (Integer[] a:set) {
            print(a);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        solve(n);
    }
}
