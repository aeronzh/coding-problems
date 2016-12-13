package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class FraudulentActivityNotifications {
    private static final int MAX_EXPENDITURE = 200;

    private static int solve(int[] a, int n, int d) {
        int ans = 0;
        int[] histogram = new int[MAX_EXPENDITURE + 1];

        // Carry a histogram of the last d expenditures
        for (int i = 0; i < d; i++) {
            histogram[a[i]] = histogram[a[i]] + 1;
        }

        for (int i = d; i < n; i++) {
            int cursor = 0;
            int currentAmount = a[i];
            double median = 0;
            int left = -1;
            int right = -1;
            for (int e = 0; e <= MAX_EXPENDITURE; e++) {
                cursor += histogram[e];
                if (d % 2 == 1) {
                    // Odd -> Pick middle one for median
                    if (cursor >= d / 2 + 1) {
                        median = e;
                        break;
                    }
                } else {
                    // Even -> Pick average of two middle values for median
                    if (cursor == d / 2) {
                        left = e;
                    }

                    if (cursor > d / 2 && left != -1) {
                        right = e;
                        median = (left + right) / 2.0;
                        break;
                    }

                    if (cursor > d / 2 && left == -1) {
                        median = e;
                        break;
                    }
                }

            }

            if (currentAmount >= 2 * median) {
                ans++;
            }

            // Update histogram: slide window 1 index to right
            histogram[a[i - d]] = histogram[a[i - d]] - 1;
            histogram[a[i]] = histogram[a[i]] + 1;
        }


        return ans;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(solve(a, n, d));
    }
}
