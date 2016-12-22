package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WorldCode_Sprint_8_2 {


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] alice = new int[m];
        for (int i = 0; i < m; i++) {
            alice[i] = in.nextInt();
        }

        int maxRank = 1;
        for (int i = 1; i < n; i++) {
            if (score[i] != score[i - 1]) {
                maxRank++;
            }
        }

        int rank = maxRank + 1;
        int cursor = n - 1;
        for (int a = 0; a < m; a++) {
            while (cursor >= 0 && alice[a] >= score[cursor]) {
                boolean flag = false;
                do {
                    cursor--;
                    if (!flag) {
                        rank = Math.max(1, rank - 1);
                        flag = true;
                    }
                } while (cursor > 0 && score[cursor + 1] == score[cursor]);
            }

            System.out.println(rank);
        }
    }
}
