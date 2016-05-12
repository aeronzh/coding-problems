package problems;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * There's a function that concatenates two strings and returns the length of
 * the resultant string. When called upon a series of strings how do we minimize
 * the cost of using this function. Lets say we have 3 strings, A="abc",
 * B="def", C="gh".
 * 
 * Now cost of merging AB = 6 and cost of merging the resultant string wiht C is
 * 8. Thus the total cost is 6+8= 14. However, if we merge A and C, then the
 * cost is 5 and then merge B with this, the cost is 8, so the total cost is 13.
 * 
 * Find an algorithm that minimizes the cost of adding such a series of strings.
 * 
 * @author lucas
 *
 */
public class StringConcat {

	private static String[] mergesort(String[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			String[] left = Arrays.copyOfRange(array, start, middle+1);
			left = mergesort(left, 0, left.length-1);
			String[] right = Arrays.copyOfRange(array, middle + 1, end+1);
			right = mergesort(right, 0, right.length-1);
			
			return merge(left, right);
		} else {
			return new String[] { array[start] };
		}
	}

	private static String[] merge(String[] a, String[] b) {
		String[] result = new String[a.length + b.length];
		int indexA = 0;
		int indexB = 0;
		int indexResult = 0;

		while (indexA < a.length && indexB < b.length) {
			if (a[indexA].length() < a[indexB].length()) {
				result[indexResult++] = a[indexA++];
			} else {
				result[indexResult++] = b[indexB++];
			}
		}

		while (indexA < a.length) {
			result[indexResult++] = a[indexA++];
		}

		while (indexB < b.length) {
			result[indexResult++] = b[indexB++];
		}

		return result;
	}

	private static String[] sort(String[] array) {
		return mergesort(array, 0, array.length - 1);
	}

	private static void print(String[] array) {
		for (String str : array) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

	// abcdfeg, a, ab, cf, xy,  abc, def
	public static int solve(String[] array) {
		int sum = 0;
		String[] sorted = sort(array);
		LinkedList<String> resultQueue = new LinkedList<String>();
		int index = 0;
		while (index<sorted.length) {
			if (!resultQueue.isEmpty()) {
				String qStr = resultQueue.peek();
				String next = sorted[index];
				boolean choseNextNext = false;
				if (index+1<sorted.length) {
					String nextNext = sorted[index+1];
					if (nextNext.length()<qStr.length()) {
						resultQueue.add(next+nextNext);
						sum += next.length()+nextNext.length();
						choseNextNext = true;
						index +=2;
					}
				}
				
				if (!choseNextNext) {
					qStr = resultQueue.pop();
					resultQueue.add(qStr+next);
					sum += qStr.length()+next.length();
					index +=1;
				}
				
				
			} else {
				String concat = sorted[index];
				if (index+1<sorted.length) {
					concat += sorted[index+1];
				}
				resultQueue.add(concat);
				sum +=concat.length();
				index += 2;
			}
		}
		
		while (!resultQueue.isEmpty()) {
			String concat = resultQueue.pop();
			if (!resultQueue.isEmpty()) {
				concat +=resultQueue.pop();
				resultQueue.add(concat);
				sum += concat.length();
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		//String[] array = new String[] { "a", "ab", "cf", "xy", "abc", "def" };
		//String[] array = new String[] { "a", "a", "a", "a" };
		String[] array = new String[] { "abc", "def", "gh"};
		System.out.println(solve(array));
	}

}
