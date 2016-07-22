public class LongestPalidromicSubsequence {

	private static int longestPalidromicSubsequence(char[] s, int start, int end) {
		if (start == end) {
			return 1;
		}

		if (s[start] == s[end] && Math.abs(start - end) == 1) {
			// so we dont cross over from 0,1 to 1,0
			return 2;
		} else if (s[start] == s[end]) {
			return longestPalidromicSubsequence(s, start + 1, end - 1) + 2;
		} else {
			return Math.max(longestPalidromicSubsequence(s, start + 1, end), longestPalidromicSubsequence(s, start, end - 1));
		}
	}

	private static int longestPalidromicSubsequence(String s) {
		int n = s.length();
		char[] str = s.toCharArray();
		int[][] l = new int[n][n]; // l[i][j] holds length of longest palidromic subsequence in range i..j 

		for (int i = 0; i < n; i++) {
			l[i][i] = 1;
		}

		for (int fill = 0; fill < n; fill++) {
			for (int end = fill + 1; end < n; end++) {
				int start = end - fill - 1;

				if (str[start] == str[end] && start+1==end) {
					l[start][end] = 2;
				}else if (str[start] == str[end]) {
					l[start][end] = l[start + 1][end - 1] + 2;
				} else {
					l[start][end] = Math.max(l[start + 1][end], l[start][end - 1]);
				}
			}
		}

		return l[0][n - 1];
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		String s = in.next();
		System.out.println(longestPalidromicSubsequence(s.toCharArray(), 0, s.length() - 1));
		System.out.println(longestPalidromicSubsequence(s));

	}

}
