package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * A gene is represented as a string of length n (where n is divisible by 4),
 * composed of the letters A, C, T, and G. It is considered to be steady if each
 * of the four letters occurs exactly n/4 times. For example, GACT and AAGTGCCT
 * are both steady genes.
 * 
 * Bear Limak is a famous biotechnology scientist who specializes in modifying
 * bear DNA to make it steady. Right now, he is examining a gene represented as
 * a string s. It is not necessarily steady. Fortunately, Limak can choose one
 * (maybe empty) substring of s and replace it with any substring of the same
 * length.
 * 
 * Modifying a large substring of bear genes can be dangerous. Given a string s,
 * can you help Limak find the length of the smallest possible substring that he
 * can replace to make s a steady gene?
 * 
 * Note: A substring of a string S is a subsequence made up of zero or more
 * consecutive characters of S.
 * 
 * Output Format
 * 
 * On a new line, print the minimum length of the substring replaced to make s
 * stable.
 * 
 * Input Format
 * 
 * The first line contains an integer n divisible by 4, denoting the length of a
 * string s. The second line contains a string s of length n. Each character is
 * one of the four: A, C, T, G.
 * 
 * 
 * Sample Input
 * 
 * 8
 * 
 * GAAATAAA
 * 
 * Sample Output
 * 
 * 5 
 * 
 * Explanation
 * 
 * One optimal solution is to replace a substring AAATA with TTCCG,
 * resulting in GTTCCGAA. The replaced substring has length 5, so we
 * print 5 on a new line.
 * 
 * @author lucas
 *
 */

// AGCT
// GAAATAAA
// G -> 1
// A -> 6
// T -> 1
// every char must appear 2 times.
// so we need 1xT, 1xG , 2xC and -4xA
// need = n/4 = 2
public class BearAndSteadyGene {

	private static void solve(String str, int n) {	
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('G', 0);
		map.put('C', 0);
		map.put('T', 0);
		
		for (char c:str.toCharArray()) {
			map.put(c, map.get(c)+1);
		}
		
		int reqNum = n/4;
		
		int minLength = 0;
		int toAddTotal = 0;
		for (Character c:map.keySet()) {
			int tmp = reqNum - map.get(c);
			if (tmp < 0) {
				minLength += Math.abs(tmp);
			} else {
				toAddTotal += tmp;
			}
		}
		
		List<String> subs = new ArrayList<String>();
		for (int len=minLength; len<=n; len++) {
			for (int i=0; i<=n-len; i++) {
				String subStr = str.substring(i, i+len);
				boolean keepSubStr = true;
				for (Character c:map.keySet()) {
					int charCount = subStr.length() - subStr.replace(""+c, "").length();
					int mapCount = reqNum - map.get(c);
					if (mapCount<0) {
						// we need to remove character c
						if (Math.abs(mapCount)==charCount) {

						} else {
							keepSubStr = false;
							break;
						}
					}
				}
				
				if (keepSubStr) {
					subs.add(subStr);
				}
			}
		}
		
		for (String subStr:subs) {
			int toBeRemoved = 0;
			for (Character c:map.keySet()) {
				int mapCount = reqNum - map.get(c);
				if (mapCount<0) {
					toBeRemoved += Math.abs(mapCount);
				}
			}
			
			if (toBeRemoved == toAddTotal) {
				System.out.println(subStr.length());
				break;
			}
		}
		

	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String str = scanner.next();
		solve(str, n);
	}
	
	

}
