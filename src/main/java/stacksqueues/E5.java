package stacksqueues;

import datastructures.IQueue;
import datastructures.IStack;
import datastructures.MyStack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * 
 * @author lucas
 *
 */
public class E5 {

	protected static class MyQueue<T> implements IQueue<T> {
		IStack<T> stack1;
		IStack<T> stack2;

		public MyQueue() {
			stack1 = new MyStack<T>();
			stack2 = new MyStack<T>();
		}

		public void enqueue(T item) {
			stack1.push(item);
		}

		/**
		 * Get first element in the queue using FIFO method.
		 */
		public T dequeue() {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}

			T item = stack2.pop();

			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}

			return item;
		}

		public T peek() {
			return stack1.peek();
		}

		public boolean isEmpty() {
			return stack1.isEmpty();
		}
	}
}
