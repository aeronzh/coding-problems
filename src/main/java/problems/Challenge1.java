package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Challenge1 {

    private static void solve(String str) {
        char[] binary = str.toCharArray();
        int n = binary.length-1;

        int index = 0; int countOnes = 0;

        while (binary[index] != '1') {
            index++;
        }

        // Turn on next zero.
        while (binary[index] == '1') {
            index++;
            countOnes++;
        }

        binary[index] = '1';

        // Turn off previous one
        index--;
        binary[index] = '0';
        countOnes--;

        // Set zeros
        for (int i = index - 1; i >= countOnes; i--) {
            binary[i] = '0';
        }

        // Set ones
        for(int i=countOnes-1; i>=0; i--){
            binary[i] = '1';
        }

        StringBuffer sb = new StringBuffer(new String(binary));

        String b = sb.reverse().toString();
        String[] ones = b.split("0");

        int o = ones.length;
        for (int i=0; i<ones.length; i++) {
            if (ones[i].isEmpty()){
                o--;
            }
        }



        String[] zeros = b.split("1");
        int z = zeros.length;

        for (int i=0; i<zeros.length; i++) {
            if (zeros[i].isEmpty()){
                z--;
            }
        }


        int[] a = new int[o+z];

        int oIndex = 0;
        int zIndex = 0;

        while (oIndex<ones.length && ones[oIndex].isEmpty()) {
            oIndex++;
        }
        while (zIndex<zeros.length && zeros[zIndex].isEmpty()) {
            zIndex++;
        }
        System.out.println(a.length);
        for (int i=0; i<a.length; i++) {
            if (i % 2 ==0) {
                a[i] = ones[oIndex++].length();
                while (oIndex<ones.length && ones[oIndex].isEmpty()) {
                    oIndex++;
                }
            } else {
                a[i] = zeros[zIndex++].length();
                while (zIndex<zeros.length && zeros[zIndex].isEmpty()) {
                    zIndex++;
                }
            }
        }




        for (int i=0; i<a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();

        for (int t=0; t<tests; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++) {
                a[i] = scanner.nextInt();
                for (int b=0; b<a[i]; b++) {
                    if (i % 2 == 0) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            }

            solve(sb.reverse().toString());
        }



    }
}
