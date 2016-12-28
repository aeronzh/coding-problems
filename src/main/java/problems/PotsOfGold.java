package problems;

/**
 * Created by lucas on 25/12/2016.
 */
public class PotsOfGold {
    private static int choose(int[] pots, int start, int end) {
        if (start > end) {
            return 0;
        }

        int chooseFromStart = pots[start] + Math.min(choose(pots, start + 2, end), choose(pots, start + 1, end - 1));

        int chooseFromEnd = pots[end] + Math.min(choose(pots, start + 1, end - 1), choose(pots, start, end - 2));

        // Now return the maximum of the two choices.
        return Math.max(chooseFromStart, chooseFromEnd);
    }

    public static void main(String[] args) {
        int[] pots = new int[] {100,1,20,30,40,10,20,30,90};

        int result = choose(pots, 0, pots.length - 1);
        System.out.println(result);
    }
}
