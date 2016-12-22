package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by lucas on 01/12/2016.
 */
public class WoC24_2 {

    private static int sumDigits(int num) {
        int ans = 0;
        while (num > 0) {
            ans += (num % 10);
            num /= 10;
        }

        return ans;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int maxSum = 0;
        int maxNum = 1;
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                System.out.println(i+" sum= "+sumDigits(i));
                int tmp = sumDigits(i);
                if(tmp > maxSum) {
                    maxSum = tmp;
                    maxNum = Math.max(maxNum, i);
                }
            }
        }

        System.out.println(maxNum);
    }
}
