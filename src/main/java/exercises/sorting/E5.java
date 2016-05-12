package exercises.sorting;

/**
 * Given a sorted array of strings which is interspersed with empty strings,
 * write a method to find the location of a given string.
 * <p/>
 * Example:
 * <p/>
 * find 'ball' in ['at', '', '', '', 'ball', '', '', 'car', '', '', 'dad', '',
 * ''] will return 4
 * <p/>
 * Example:
 * <p/>
 * find 'ballcar' in ['at', '', '', '', '', 'ball', 'car', '', '', 'dad', '',
 * ''] will return -1
 *
 * @author lucas
 */
public class E5 {

    public static int search(String[] a, String s, int start, int end) {
        if (end >= start) {
            int middle = start + (end - start) / 2;
            if (s.equals(a[middle])) {
                return middle;
            } else if ("".equals(a[middle])) {
                // go right and left
                return Math.max(search(a, s, start, middle - 1), search(a, s, middle + 1, end));
            } else {
                if (s.compareTo(a[middle]) == -1) {
                    // a[middle] is greater. Search left
                    return search(a, s, start, middle - 1);
                } else {
                    // a[middle] is smaller. Search right
                    return search(a, s, middle + 1, end);
                }
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] a = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        int result = search(a, "car", 0, a.length - 1);
        System.out.println("result = " + result);
    }

}
