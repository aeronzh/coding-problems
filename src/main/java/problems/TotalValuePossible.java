package problems;

/**
 * From a given integer array values, find if a Total value is possible or not? The numbers in the array can be used more than once.
 * <p/>
 * int[] points = {3, 7};
 * <p/>
 * <p/>
 * isScorePossible(points, 10) = true
 * <p/>
 * isScorePossible(points, 9) = true
 */
public class TotalValuePossible {

    private static boolean solve(int[] a, int total) {
        if (total == 0) {
            return true;
        }

        if (total < 0) {
            return false;
        }

        for (int num: a) {
            boolean result = solve(a,total-num);
            if (result) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 7}, 10));
        System.out.println(solve(new int[]{3, 7}, 9));
        System.out.println(solve(new int[]{3, 7}, 5));
    }

}
