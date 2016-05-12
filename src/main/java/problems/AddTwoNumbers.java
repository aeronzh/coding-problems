package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * 465
 * 
 * 342
 * 
 * 708
 * 
 * @author lucas
 *
 */
public class AddTwoNumbers {

	public static List<Integer> add(List<Integer> numA, List<Integer> numB) {
		List<Integer> result = new ArrayList<Integer>();

		Iterator<Integer> numAIter = numA.iterator();
		Iterator<Integer> numBIter = numB.iterator();

		int carry = 0;
		while (numAIter.hasNext() || numBIter.hasNext()) {
			int da = 0;
			if (numAIter.hasNext()) {
				da = numAIter.next();
			}

			int db = 0;
			if (numBIter.hasNext()) {
				db = numBIter.next();
			}

			int sum = da + db + carry;

			if (sum >= 10) {
				carry = 1;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			result.add(sum);
		}

		if (carry == 1) {
			result.add(1);
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> numA = Arrays.asList(2, 4, 3);
		List<Integer> numB = Arrays.asList(5, 6, 4);

		System.out.println(add(numA, numB));
	}

}
