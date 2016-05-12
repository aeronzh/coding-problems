package datastructures;

public interface IStack<T> {

	/**
	 * Get the last element on the stac and remove it from the stack.
	 * 
	 * @return the last element in the stack list
	 */
	T pop();

	/**
	 * Push element on the stack
	 * 
	 * @param item
	 *            the element to put on the stack
	 */
	void push(T item);

	/**
	 * Get the last element on the stack without removing it.
	 * 
	 * @return last element on the stack
	 */
	T peek();

	/**
	 * Check if the stack is full.
	 * 
	 * @return true if the stack is full, false otherwise.
	 */
	boolean isFull();

	/**
	 * Check if the stack is empty.
	 * 
	 * @return true if the stack is empty, false otherwise.
	 */
	boolean isEmpty();

}