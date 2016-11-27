package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	private static String[] num = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };

	private static String[] ten = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	private static final String[] special = { "", "Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Quintillion" };

	private static final String SPACE = " ";
	
	// 104382426112 
	// One Hundred Four Billion Three Hundred Eighty Two Million Four Hundred Twenty Six Thousand One Hundred Twelve
	private static String lessThanThousand(long n) {
		String ans = "";

		// 100
		if (n % 100 < 20) {
			long i = n % 100;
			ans = num[(int)i];
		} else {
			long i = n % 100;
			ans = ten[(int)(i / 10)] + SPACE + num[(int)(i % 10)];
		}

		if (n >= 100) {
			return num[(int)(n/100)] + SPACE +  "Hundred" + SPACE + ans;
		} else {
			return ans;
		}
	}

    
	private static String solve(long n) {
        if (n == 0) {
            return "Zero";
        }
        
        
		String ans = "";
		int specialIndex = 0;
		while (n > 0) {
			long tmp = n % 1000;
			String hundred = lessThanThousand(tmp);
			n = n / 1000;
			ans =  hundred.trim() + SPACE +  special[specialIndex++] + SPACE +  ans.trim();
		}

		return ans.trim();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		for (int t = 0; t < tests; t++) {
			int n = in.nextInt();
			System.out.println(solve(n));
		}
	}
}
