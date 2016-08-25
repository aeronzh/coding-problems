package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Best way to find the number of pairs in an array whose difference is k
 */
public class Pairs {

    private static int solve(int[] a, int n, int k) {
       Set<Integer> set = new HashSet<Integer>()

        for (int num:a) {
            set.add(num);
        }

        int count = 0;
        for (int num:a) {
            if (set.contains(num+k)) {
                count++;
            }
        }
        return count;
    }

    // 5 2
    // 1 5 3 4 2
    // 1 -> []
    // 5 -> []
    // 3 -> [1]
    // 4 -> []
    // 5 -> []
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(solve(a,n,k));

    }
}
