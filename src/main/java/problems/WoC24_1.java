package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WoC24_1 {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int a = (m%2==1) ? m/2 +1 : m/2;
        int b = (n%2==1) ? n/2 +1 : n/2;

        System.out.println(a*b);
    }
}
