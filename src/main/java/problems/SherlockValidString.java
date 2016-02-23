package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * A "valid" string is a string SS such that for all distinct characters in SS
 * each such character occurs the same number of times in S.
 * 
 * For example, aabb is a valid string because the frequency of both characters
 * a and b is 2, whereas aabbc is not a valid string because the frequency of
 * characters a, b, and c is not the same.
 * 
 * Watson gives a string S to Sherlock and asks him to remove some characters
 * from the string such that the new string is a "valid" string.
 * 
 * Sherlock wants to know from you if it's possible to be done with less than or
 * equal to one removal.
 * 
 * @author lucas
 *
 */
public class SherlockValidString {

	private static String solve(String str) {
		char[] chars = str.toCharArray();
		Map<Character, Integer> char2count = new HashMap<Character, Integer>();

		for (Character c : chars) {
			int count = 1;
			if (char2count.containsKey(c)) {
				count = char2count.get(c);
				count++;
				char2count.put(c, count);
			} else {
				char2count.put(c, count);
			}

		}

		int max = 0;
		int min = Integer.MAX_VALUE;
		for (Character key : char2count.keySet()) {
			int count = char2count.get(key);
			if (count > max) {
				max = count;
			}

			if (count < min) {
				min = count;
			}
		}

		int n = str.length();
		int distinctCount = char2count.keySet().size();

		//System.out.println(char2count);

		int maxCount = 0;
		int minCount = 0;
		for (Character key : char2count.keySet()) {
			int count = char2count.get(key);
			if (count == max) {
				maxCount++;
			}
			if (count == min) {
				minCount++;
			}
		}

		//System.out.println("n=" + n + " distinctCount=" + distinctCount + "  max=" + max + "  min=" + min + "  maxcount=" + maxCount + "  minCount=" + minCount);

		if (maxCount == distinctCount) {
			return "YES";
		}

		if (maxCount + minCount == distinctCount && minCount == 1 && min - 1 == 0) {
			return "YES";
		} else if (maxCount + minCount == distinctCount && maxCount == 1 && max - 1 == min) {
			return "YES";
		} else {
			return "NO";
		}

	}

	public static void main(String[] args) {
		//String str = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		//String str = "aabbcd";
		String str = "hfchdkkbfifgbgebfaahijchgeeeiagkadjfcbekbdaifchkjfejckbiiihegacfbchdihkgbkbddgaefhkdgccjejjaajgijdkd";
		System.out.println(solve(str)); // YES
	}
}
