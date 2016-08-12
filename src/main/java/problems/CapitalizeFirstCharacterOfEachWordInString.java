package problems;

/**
 * Given a sentence, how would you transform each word to start with a capital
 * letter.
 */
public class CapitalizeFirstCharacterOfEachWordInString {
	private static void solve(String sentence) {
		char[] s = sentence.toCharArray();
		int len = s.length;
		int i = 0;
		while (i < len) {
			// find next start
			while (i < len && s[i] == ' ') {
				i++;
			}

			if (i < len && s[i] >= 'a' && s[i] <= 'z') {
				s[i] = (char) (s[i] - 'a' + 'A');

				// find next space
				while (i < len && s[i] != ' ') {
					i++;
				}
			}

			i++;
		}

		System.out.println(new String(s));

	}

	public static void main(String[] args) {
		String sentence = "i love cats   and clouds!";
		solve(sentence);
	}
}
