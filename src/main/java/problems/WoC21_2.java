package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class WoC21_2 {

    private static int solve(int n, int k, int[] l, boolean[] important) {
        List<Integer> imps = new ArrayList<Integer>();
        List<Integer> unimps = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (important[i]) {
                imps.add(l[i]);
            } else {
                unimps.add(l[i]);
            }
        }

        Collections.sort(imps);
        Collections.sort(unimps);

        //System.out.println(imps);
        //System.out.println(unimps);

        int impsCount = imps.size();
        int neg = 0;
        while (impsCount > k) {
            neg += imps.get(0);
            imps.remove(0);
            impsCount = imps.size();
        }

        int sum = 0;
        for (int luck : imps) {
            sum += luck;
        }

        for (int luck : unimps) {
            sum += luck;
        }

        sum -= neg;

        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] l = new int[n];
        boolean[] important = new boolean[n];

        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextInt();
            int imp = scanner.nextInt();
            important[i] = (imp == 1);
        }

        System.out.println(solve(n, k, l, important));
    }
}
