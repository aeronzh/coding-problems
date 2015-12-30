package problems;

import java.util.Arrays;

public class BoyerMoore {
    /**
     * Bad Character Rule
     * <p/>
     * Preprocess the pattern string. Returns array with
     * array[c] = position of rightmost occurrence of c in the pattern
     *
     * @param pattern pattern
     * @return lookup table
     */
    private static int[] preprocess(String pattern) {
        final int alphabet = 256;
        int n = pattern.length();
        int[] lookup = new int[alphabet];
        Arrays.fill(lookup, -1);

        for (int index = 0; index < n; index++) {
            lookup[pattern.charAt(index)] = index;
        }

        return lookup;
    }

<<<<<<< HEAD
    /**
     * Returns the index of the first occurrence of the pattern string
     * in the text string.
     *
     * @param pattern
     * @param text
     * @return
     */
    public static int search(String pattern, String text) {
        int[] lookup = preprocess(pattern);
        int n = pattern.length();
        int m = text.length();
=======
	/**
	 * Simple constant-time lookup solution is as follows: create a 2D table
	 * which is indexed first by the index of the character c in the alphabet
	 * and second by the index i in the pattern. This lookup will return the
	 * occurrence of c in P with the next-highest index j<i or -1 if there is no
	 * such occurrence. The proposed shift will then be i-j, with O(1) lookup
	 * time and O(kn) space, assuming a finite alphabet of length k.
	 * 
	 * 
	 * @param p
	 *            patern
	 * @return lookup table
	 */
	private static int[][] preprocess(String p) {
		final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int k = alphabet.length();
		int n = p.length();
		int[][] lookup = new int[k][n];
		for (int[] row: lookup)
		    Arrays.fill(row, -1);
		
>>>>>>> 06429ccef51c280d442078cd21b77c21c2dc8f97

        int ti = n - 1;
        while (ti < m) {

            int pi = n - 1;
            while (text.charAt(ti) == pattern.charAt(pi)) {
                pi--;
                ti--;
                if (pi < 0) {
                    return (ti + 1);
                }
            }

            // Not found. Get the position of the right most occurence of text.charAt(ti) in pattern
            int right = lookup[text.charAt(ti)];

            // Shift pattern to the right
            int shift = Math.max(1, pi - right);
            ti += shift;
        }

        return -1;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr,"
                + "sed diam nonumy eirmod tempor invidunt ut labore et dolore"
                + "magna aliquyam erat, sed diam voluptua. At vero eos et accusam"
                + "et justo duo dolores et ea rebum. Stet clita kasd gubergren, no"
                + "sea takimata sanctus est Lorem ipsum dolor sit amet. Loabbarem ipsum"
                + "dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod"
                + "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."
                + "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd "
                + "gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

        System.out.println("result = " + search(pattern, text));
    }

}
