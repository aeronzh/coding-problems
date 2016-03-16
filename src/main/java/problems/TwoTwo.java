package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Prof. Twotwo as the name suggests is very fond powers of 2. Moreover he also
 * has special affinity to number 800. He is known for carrying quirky
 * experiments on powers of 2.
 * 
 * One day he played a game is his class. He brought some number plates on each
 * of which a digit from 0 to 9 is written. He made students stand in a row and
 * gave a number plate to each of the student. Now turn by turn, he called for
 * some students who are standing continuously in the row say from index i to
 * index j (i<=j) and asked them to find their strength.
 * 
 * The strength of the group of students from i to j is defined as:
 * 
 * strength(i , j) {
 * 
 * if a[i] = 0 return 0; //If first child has value 0 in the group, strength of
 * group is zero
 * 
 * value = 0;
 * 
 * for k from i to j
 * 
 * value = value*10 + a[k]
 * 
 * return value;
 * 
 * }
 * 
 * Prof called for all possible combinations of i and j and noted down the
 * strength of each group. Now being interested in powers of 2, he wants to find
 * out how many strengths are powers of two. Now its your responsibility to get
 * the answer for prof.
 * 
 * Input Format First line contains number of test cases T Next T line contains
 * the numbers of number plates the students were having when standing in the
 * row in the form of a string A.
 * 
 * @author lucas
 *
 */
public class TwoTwo {
	private static final int MAX = 800;

	static class MyTrie {
		boolean isEnd;
		MyTrie[] children;

		MyTrie() {
			isEnd = false;
			children = new MyTrie[10];
		}

		void add(String str) {
			if (str.length() == 0) {
				isEnd = true;
				return;
			}

			int index = str.charAt(str.length() - 1) - '0';
			if (children[index] == null) {
				children[index] = new MyTrie();
			}
			children[index].add(str.substring(0, str.length() - 1));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		BigInteger[] powers = new BigInteger[MAX];
		MyTrie trie = new MyTrie();

		BigInteger x = BigInteger.ONE;
		trie.add(x.toString());
		for (int i = 0; i < 800; ++i) {
			x = x.shiftLeft(1);
			trie.add(x.toString());
		}

		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
		for (int t = 1; t <= tests; t++) {
			String line = scanner.next();

			int count = 0;

			for (int i = 0; i < line.length(); i++) {
				int digit = Integer.parseInt("" + line.charAt(i));
				MyTrie node = trie.children[digit];
				if (node == null) {
					continue;
				}

				if (node.isEnd) {
					count++;
				}

				for (int j = 1; j < 243; ++j) {
					if ((i - j) >= 0) {
						digit = Integer.parseInt("" + line.charAt(i - j));
						node = node.children[digit];
					} else {
						break;
					}

					if (node == null) {
						break;
					}

					if (node.isEnd) {
						count++;
					}
				}

			}

			long expectedResult = outputScanner.nextLong();
			if (count != expectedResult) {
				System.out.println("*** got= " + count + "    expected= " + expectedResult + "  for " + line);
			} else {
				System.out.println(count);
			}
		}
	}

}
