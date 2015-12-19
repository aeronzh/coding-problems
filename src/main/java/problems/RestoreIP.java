package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: given "25525511135",return ["255.255.11.135", "255.255.111.35"].
 * 
 * @author lucas
 *
 */
public class RestoreIP {

	private static String create(String digits, List<Integer> indices) {
		StringBuilder sb = new StringBuilder();
		int c = 0;
		int d = indices.get(c);
		for (int i = 0; i < digits.length(); i++) {
			if (i == d) {
				sb.append(".");
				c++;
				if (c < indices.size()) {
					d = indices.get(c);
				}
			}
			sb.append(digits.charAt(i));
		}

		return sb.toString();
	}

	public static void solve(String digits, List<Integer> indices) {
		if (indices.size() == 3) {
			int lastIndex = indices.get(indices.size() - 1);
			String sub = digits.substring(lastIndex, digits.length());
			if (Integer.parseInt(sub) > 255) {
				return;
			}

			int remainingLen = digits.length() - lastIndex;
			if (remainingLen <= 3) {
				System.out.println(create(digits, indices));
			}
		} else {
			int lastIndex = 0;
			if (!indices.isEmpty()) {
				lastIndex = indices.get(indices.size() - 1);
			}

			int remainingLen = digits.length() - lastIndex;
			int numIndices = indices.size();
			int numOfAvailableIndices = 3 - numIndices;
			if (Math.ceil((double) remainingLen / ((double) numOfAvailableIndices + 1.0)) > 3) {
				return;
			}

			for (int i = 1; i <= 3; i++) {
				if (lastIndex + i < digits.length()) {
					String sub = digits.substring(lastIndex, lastIndex + i);
					if (Integer.parseInt(sub) > 255) {
						break;
					}
				}
				indices.add(lastIndex + i);
				solve(digits, indices);
				indices.remove(indices.size() - 1);
			}

		}
	}

	public static void main(String[] args) {
		solve("25525511135", new ArrayList<Integer>());
	}

}
