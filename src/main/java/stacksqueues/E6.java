package stacksqueues;

import datastructures.IStack;
import datastructures.MyStack;

/**
 * Write a program to sort a stack in ascending order. You should not make any
 * assumptions about how the stack is implemented. The following are the only
 * functions that should be used to write this program: push | pop | peek |
 * isEmpty
 * 
 * @author lucas
 *
 */
public class E6 {

	public static <T extends Comparable<T>> IStack<T> sortStack(IStack<T> stack1) {
		IStack<T> stack2 = new MyStack<T>();
		while (!stack1.isEmpty()) {
			T item = stack1.pop();
			while (!stack2.isEmpty() && stack2.peek().compareTo(item) > 0) {
				stack1.push(stack2.pop());
			}
			stack2.push(item);
		}

		return stack2;
	}

	public static void main(String[] args) {
		IStack<Integer> stack1 = new MyStack<Integer>();
		stack1.push(2);
		stack1.push(1);
		stack1.push(20);
		stack1.push(0);
		stack1.push(13);

		MyStack<Integer> sorted = (MyStack<Integer>) sortStack(stack1);
		while (!sorted.isEmpty()) {
			System.out.println(sorted.pop());
		}

	}
}
