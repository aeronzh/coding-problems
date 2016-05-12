package stacksqueues;

import java.util.ArrayList;
import java.util.List;

import datastructures.MyStack;

/**
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in O(1) time.
 * 
 * @author lucas
 *
 */
public class E2 {
	protected static class MyStackWithMin<T extends Comparable<T>> extends MyStack<T> {
		List<T> mins;

		public MyStackWithMin() {
			mins = new ArrayList<T>();
		}

		public void push(T item) {
			super.push(item);

			if (mins.isEmpty()) {
				mins.add(item);
			} else {
				T lastMin = mins.get(mins.size() - 1);
				if (item.compareTo(lastMin) < 0) {
					// item is less than last
					mins.add(item);
				}
			}
		}

		public T pop() {
			T item = super.pop();
			int lastIndex = mins.size() - 1;
			T lastMin = mins.get(lastIndex);
			if (item.compareTo(lastMin) == 0) {
				mins.remove(lastIndex);
			}

			return item;
		}

		/**
		 * Return min element on stack
		 * 
		 * @return
		 */
		public T min() {
			if (mins.isEmpty()) {
				throw new IllegalArgumentException("Nothing in here!");
			} else {
				return mins.get(mins.size() - 1);
			}
		}
	}
}
