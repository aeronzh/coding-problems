package com.lucaslouca.other;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0. You may
 * assume that the version strings are non-empty and contain only digits and the
 * . character. The . character does not represent a decimal point and is used
 * to separate number sequences. Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author lucas
 *
 */
public class CompareVersionNumbers {

	public static int solve(String v1Str, String v2Str) {
		String[] v1 = v1Str.split("\\.");
		String[] v2 = v2Str.split("\\.");

		int a = 0;
		int b = 0;

		while ((a < v1.length && b < v2.length) && (Integer.parseInt(v1[a]) == Integer.parseInt(v2[b]))) {
			a++;
			b++;
		}

		if (a != v1.length && b == v2.length) {
			return 1;
		} else if (a == v1.length && b != v2.length) {
			return -1;
		}

		if ((a < v1.length && b < v2.length) && Integer.parseInt(v1[a]) < Integer.parseInt(v2[b])) {
			return -1;
		} else if ((a < v1.length && b < v2.length) && Integer.parseInt(v1[a]) > Integer.parseInt(v2[b])) {
			return 1;
		} else {
			return 0;
		}

	}

	public static void main(String[] args) {
		System.out.println(solve("13", "13"));

	}

}
