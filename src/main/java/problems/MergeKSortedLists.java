package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author lucas
 *
 */
public class MergeKSortedLists {

	public static List<Integer> solve(List<Integer>... lists) {
		int[] index = new int[lists.length];
		List<Integer> result = new ArrayList<Integer>();
		PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>(lists.length, new Comparator<List<Integer>>() {

			public int compare(List<Integer> n1, List<Integer> n2) {
				if (n1.get(0) < n2.get(0))
					return -1;
				if (n1.get(0) > n2.get(0))
					return 1;
				return 0;
			}

		});

		for (List<Integer> list : lists) {
			queue.add(list);
		}

		while (!queue.isEmpty()) {
			List<Integer> list = queue.poll();
			result.add(list.remove(0));
			if (!list.isEmpty()) {
				queue.add(list);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList(Arrays.asList(1, 2, 3, 4));
		List<Integer> l2 = new ArrayList(Arrays.asList(10, 21, 31, 41));
		List<Integer> l3 = new ArrayList(Arrays.asList(11, 13, 100));
		List<Integer> l4 = new ArrayList(Arrays.asList(1, 2, 13, 44, 666));
		List<Integer> l5 = new ArrayList(Arrays.asList(1, 1, 13, 114));

		System.out.println(solve(l1, l2, l3, l4, l5));
	}

}
