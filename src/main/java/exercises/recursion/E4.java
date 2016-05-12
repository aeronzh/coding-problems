package exercises.recursion;

/**
 * Write a method to compute all permutations of a string.
 * 
 * @author lucas
 *
 */
public class E4 {

	private static void permute(char[] str, int n, int i) {
		if (i == n) {
			System.out.println(new String(str));
		} else {
			for (int j = i; j < n; j++) {
				char tmp = str[i];
				str[i] = str[j];
				str[j] = tmp;

				permute(str, n, (i + 1));

				tmp = str[i];
				str[i] = str[j];
				str[j] = tmp;
			}
		}
	}

	/**
	 * Prints all permutations of a string.
	 * 
	 * @param str
	 *            String
	 */
	public static void permute(String str) {
		permute(str.toCharArray(), str.length(), 0);
	}

	public static void main(String[] args) {
		permute("abc");
	}

}
