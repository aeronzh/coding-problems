package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by lucas on 13/05/16.
 */
public class Pairs {

    private static int solve(int[] a, int n, int k) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int num:a) {
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<Integer>());
            }
        }

        for (int num:a) {
            if (map.containsKey(num+k)) {
                map.get(num+k).add(num);
            }
        }

        int count = 0;
        for (int num:a) {
            if (map.containsKey(num)) {
                count += map.get(num).size();
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
