package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * 
 * 1) Elements in a subset must be in non-descending order.
 * 
 * 2) The solution set must not contain duplicate subsets.
 * 
 * For example, given S = [1,2,3], the method returns:
 * 
 * [
 * 
 * [3],
 * 
 * [1],
 * 
 * [2],
 * 
 * [1,2,3],
 * 
 * [1,3],
 * 
 * [2,3],
 * 
 * [1,2],
 * 
 * []
 * 
 * ]
 * 
 * @author lucas
 *
 */
public class Subsets {

	public static List<List<Integer>> solve(List<Integer> set) {
		Collections.sort(set);

		List<List<Integer>> powerset = new ArrayList<List<Integer>>();
		List<Integer> empty = new ArrayList<Integer>();

		powerset.add(empty);

		for (Integer element : set) {
			List<List<Integer>> newPowerset = new ArrayList<List<Integer>>();
			for (List<Integer> subset : powerset) {
				List<Integer> newSubset = new ArrayList<Integer>(subset);
				newSubset.add(element);

				newPowerset.add(newSubset);
				newPowerset.add(subset);
			}

			powerset = newPowerset;
		}

		return powerset;
	}

	public static void main(String[] args) {
		List<Integer> set = new ArrayList<Integer>();
		set.add(2);
		set.add(1);
		set.add(3);

		List<List<Integer>> powerset = solve(set);
		System.out.println(powerset);

	}

}
