package problems;

import java.util.Arrays;

public class CheckIfAnagram {

	private static boolean anagrams(String a, String b) {
		char[] cha = a.toCharArray();
		char[] chb = b.toCharArray();

		Arrays.sort(cha);
		Arrays.sort(chb);

		return Arrays.equals(cha, chb);
	}

	private static boolean anagrams2(String a, String b) {
		char[] cha = a.toCharArray();
		char[] chb = b.toCharArray();

		int[] histogram = new int[26];
		for (char c : cha) {
			histogram[c - 'a'] = histogram[c - 'a'] + 1;
		}

		for (char c : chb) {
			histogram[c - 'a'] = histogram[c - 'a'] - 1;
		}

		for (int count : histogram) {
			if (count != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(anagrams2("abc", "abc"));

	}

}
