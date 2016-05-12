package problems;

import java.util.Arrays;

/**
 * You and your friend decide to play a game using a stack consisting of N bricks. In this game, you can alternatively remove 1, 2 or 3
 * bricks from the top, and the numbers etched on the removed bricks are added to your score. You have to play so that you obtain the maximum possible score.
 * It is given that your friend will also play optimally and you make the first move.
 * <p/>
 * <p/>
 * Created by lucas on 25/02/16.
 */
public class PlayGame {

    static long[] cache;

    private static long solve(int[] a, int index) {
        int n = a.length;

        long pick1 = 0;
        long pick2 = 0;
        long pick3 = 0;

        if (index < n) {
            // Pick first only + the minimum of the next options(i+2, i+3, i+4) because the opponent the opponent tries to minimize it
            long tmpa = cache[index + 2];
            if (cache[index + 2] == Long.MAX_VALUE) {
                tmpa = solve(a, index + 2);
                cache[index + 2] = tmpa;
            }

            long tmpb = cache[index + 3];
            if (cache[index + 3] == Long.MAX_VALUE) {
                tmpb = solve(a, index + 3);
                cache[index + 3] = tmpb;
            }

            long tmpc = cache[index + 4];
            if (cache[index + 4] == Long.MAX_VALUE) {
                tmpc = solve(a, index + 4);
                cache[index + 4] = tmpc;
            }

            pick1 = a[index] + Math.min(tmpa, Math.min(tmpb, tmpc));
        }

        if (index + 1 < n) {
            // Pick first two only + the minimum of the next options(i+3, i+4, i+5) because the opponent the opponent tries to minimize it
            long tmpa = cache[index + 3];
            if (cache[index + 3] == Long.MAX_VALUE) {
                tmpa = solve(a, index + 3);
                cache[index + 3] = tmpa;
            }

            long tmpb = cache[index + 4];
            if (cache[index + 4] == Long.MAX_VALUE) {
                tmpb = solve(a, index + 4);
                cache[index + 4] = tmpb;
            }

            long tmpc = cache[index + 5];
            if (cache[index + 5] == Long.MAX_VALUE) {
                tmpc = solve(a, index + 5);
                cache[index + 5] = tmpc;
            }

            pick2 = a[index] + a[index + 1] + Math.min(tmpa, Math.min(tmpb, tmpc));
        }

        if (index + 2 < n) {

            long tmpa = cache[index + 4];
            if (cache[index + 4] == Long.MAX_VALUE) {
                tmpa = solve(a, index + 4);
                cache[index + 4] = tmpa;
            }

            long tmpb = cache[index + 5];
            if (cache[index + 5] == Long.MAX_VALUE) {
                tmpb = solve(a, index + 5);
                cache[index + 5] = tmpb;
            }

            long tmpc = cache[index + 6];
            if (cache[index + 6] == Long.MAX_VALUE) {
                tmpc = solve(a, index + 6);
                cache[index + 6] = tmpc;
            }

            pick3 = a[index] + a[index + 1] + a[index + 2] + Math.min(tmpa, Math.min(tmpb, tmpc));
        }

        return Math.max(pick1, Math.max(pick2, pick3));
    }


    public static void main(String[] args) {
        int[] stack = {0, 1, 1, 1, 999};
        int n = stack.length;
        cache = new long[n + 6];
        Arrays.fill(cache, Long.MAX_VALUE);
        System.out.println(solve(stack, 0));
    }
}
