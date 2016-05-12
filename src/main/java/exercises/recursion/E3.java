package exercises.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a method that returns all subsets of a set.
 * 
 * @author lucas
 *
 */
public class E3 {

	private static <T> List<List<T>> powerSet(List<T> set, List<List<T>> powerSet, int currIndex) {
		if (currIndex < set.size()) {
			List<List<T>> newPowerSet = new ArrayList<List<T>>();
			for (List<T> subSet : powerSet) {
				List<T> newSubSet = new ArrayList<T>();
				newSubSet.addAll(subSet);
				newSubSet.add(set.get(currIndex));

				newPowerSet.add(subSet);
				newPowerSet.add(newSubSet);
			}
			return powerSet(set, newPowerSet, (currIndex + 1));
		} else {
			return powerSet;
		}
	}

	/**
	 * Returns the powerset of the List.
	 * 
	 * @param set
	 * @return List of List representing the powerset.
	 */
	public static <T> List<List<T>> powerSet(List<T> set) {
		List<List<T>> powerSet = new ArrayList<List<T>>();
		powerSet.add(new ArrayList<T>());
		return powerSet(set, powerSet, 0);
	}

	public static void main(String[] args) {
		List<Integer> set = Arrays.asList(1, 2, 3);
		System.out.println(powerSet(set));

	}
}
