package problems;

// 1, 11, 21, 1211, 111221
public class WordNumbers {

	// 1, 11, 21, 1211, 111221
	/**
	 * return nth number
	 * 
	 * @param n
	 */
	private static String solve(int n) {
		String result = "1";

		for (int i = 2; i <= n; i++) {
			String newResult = "";
			int index = 0;
			char t = result.charAt(index);
			int count = 1;
			while (index < result.length()-1) {
				if (result.charAt(index+1) != t) {
					newResult += count +"" + t;
					count = 1;
					t = result.charAt(index+1);
				} else {
					count++;
				}

				index++;
			}
			
			newResult += count +"" + t;
			result = newResult;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solve(5));

	}

}
