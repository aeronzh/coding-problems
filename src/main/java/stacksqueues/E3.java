package stacksqueues;

import java.util.ArrayList;
import java.util.List;

import datastructures.IStack;
import datastructures.MyStack;

/**
 * Imagine a (literal) stack of plates If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold.
 * 
 * Implement a data structure SetOfStacks that mimics this SetOfStacks should be
 * composed of several stacks, and should create a new stack once the previous
 * one exceeds capacity. SetOfStacks push() and SetOfStacks pop() should behave
 * identically to a single stack (that is, pop() should return the same values
 * as it would if there were just a single stack).
 * 
 * FOLLOW UP
 * 
 * Implement a function popAt(int index) which performs a pop operation on a
 * specific sub-stack.
 * 
 * @author lucas
 *
 */
public class E3 {
	protected static class SetOfStacks<T> {
		private final int stackSize;
		private List<MyStack<T>> stacks;

		public SetOfStacks(int stackSize) {
			this.stackSize = stackSize;
			stacks = new ArrayList<MyStack<T>>();
		}

		/**
		 * Retrieve an element from the stack and remove it from the stack
		 * 
		 * @return the element on top of the stack.
		 */
		public T pop() {
			if (stacks.isEmpty()) {
				throw new IllegalArgumentException("Nothing to pop here.");
			} else {
				IStack<T> lastStack = getLastStack();
				T item = lastStack.pop();
				if (lastStack.isEmpty()) {
					stacks.remove(stacks.size() - 1);
				}
				return item;
			}
		}

		/**
		 * Push element on the stack
		 * 
		 * @param item
		 *            the element to put on the stack
		 */
		public void push(T item) {
			IStack<T> lastStack;
			if (stacks.isEmpty()) {
				addStack();
			} else {
				lastStack = getLastStack();
				if (lastStack.isFull()) {
					addStack();
				}
			}

			lastStack = getLastStack();
			lastStack.push(item);
		}

		/**
		 * Get the last stack in the stack list.
		 * 
		 * @return the last element in the stack list
		 */
		private IStack<T> getLastStack() {
			if (stacks.isEmpty()) {
				throw new IllegalArgumentException("No stacks available");
			} else {
				IStack<T> lastStack = stacks.get(stacks.size() - 1);
				return lastStack;
			}
		}

		/**
		 * Add a new stack to the stack list
		 */
		private void addStack() {
			MyStack<T> stack = new MyStack<T>(stackSize);
			stacks.add(stack);
		}

		/**
		 * Get total number of stacks in the stack list.
		 * 
		 * @return total number of stacks in the stack list.
		 */
		public int getNumberOfStacks() {
			return stacks.size();
		}
	}

}
