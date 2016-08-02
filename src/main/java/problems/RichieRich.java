package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Sandy likes palindromes. A palindrome is a word, phrase, number, or other
 * sequence of characters which reads the same backward as it does forward. For
 * example, madam is a palindrome.
 * 
 * On her 7th birthday, Sandy's uncle, Richie Rich, offered her an n-digit check
 * which she refused because the number was not a palindrome. Richie then
 * challenged Sandy to make the number palindromic by changing no more than k
 * digits. Sandy can only change 1 digit at a time, and cannot add digits to (or
 * remove digits from) the number.
 * 
 * Given and an -digit number, help Sandy determine the largest possible number
 * she can make by changing <=k digits.
 * 
 * Note: Treat the integers as numeric strings. Leading zeros are permitted and
 * can't be ignored (So 0011 is not a palindrome, 0110 is a valid palindrome). A
 * digit can be modified more than once.
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers, n (the number of digits
 * in the number) and k (the maximum number of digits that can be altered),
 * respectively. The second line contains an -digit string of numbers that Sandy
 * must attempt to make palindromic.
 * 
 * @author lucas
 *
 */
public class RichieRich {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();
		String s = in.next();

		if (n == 1 && k >= 1) {
			System.out.println("9");
			return;
		}


        int[] change = new int[n];

		// 6 3
		// 092282
		// -> 992299

		// 6 2
		// 932239
		// -> 992299

		// 5 1
		// 12321
		// -> 12921

		// 8 4
		// 11119111
		// -> 91199119
		
		// 15 8 
		// 128392759430124
		// -> 929394959493929
		char[] num = s.toCharArray();
		for (int l = 0; l < n / 2; l++) {
			int left = num[l] - 48;
			int right = num[n - l - 1] - 48;

			if (left > right) {
				num[n - l - 1] = (char) (left + 48);
				k--;
                change[l] = 1;
                change[n - l - 1] = 1;
			} else if (right > left) {
				num[l] = (char) (right + 48);
				k--;
                change[l] = 1;
                change[n - l - 1] = 1;
			}

			if (k == 0) {
				break;
			}
		}

		for (int l = 0; l < n / 2; l++) {
			int left = num[l] - 48;
			int right = num[n - l - 1] - 48;

            if (left != 9 &&  k >= 2 && change[l] == 0) {
                num[l] = (char) (9 + 48);
                num[n - l - 1] = (char) (9 + 48);
                k -= 2;
            } else if (left != 9 &&  k >= 1 && change[l] == 1) {
				num[l] = (char) (9 + 48);
				num[n - l - 1] = (char) (9 + 48);
				k -= 2;
                k += 1;
			}

			if (k == 0) {
				break;
			}
		}


        for (int l = 0; l < n / 2; l++) {
            int left = num[l] - 48;
            int right = num[n - l - 1] - 48;

            if (left != 9 &&  k >= 2) {
                num[l] = (char) (9 + 48);
                num[n - l - 1] = (char) (9 + 48);
                k -= 2;
            }

            if (k == 0) {
                break;
            }
        }

		if (k > 0 && n % 2 == 1) {
			num[n / 2] = '9';
			k--;
		}

		// check if palidrome
		for (int i = 0; i < n / 2; i++) {
			if (num[i] != num[n - i - 1]) {
				System.out.println("-1");
				return;
			}
		}

        System.out.println(new String(num));

	}
}
