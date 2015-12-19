package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author lucas
 *
 */
public class RepeatedDNASequences {

	public static List<String> naive(String dna) {
		List<String> result = new ArrayList<String>();

		Map<String, Integer> map = new HashMap<String, Integer>();

		StringBuilder sb;
		int end = dna.length() - 9;
		for (int i = 0; i < end; i++) {
			sb = new StringBuilder();

			for (int a = 0; a < 10; a++) {
				sb.append(dna.charAt(i + a));
			}

			String key = sb.toString();
			if (map.containsKey(key)) {
				map.put(key, (map.get(key) + 1));
			} else {
				map.put(key, 1);
			}

		}

		for (String key:map.keySet()) {
			if (map.get(key)>1) {
				result.add(key);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(naive("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}
