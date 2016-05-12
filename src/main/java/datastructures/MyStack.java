package datastructures;

public class MyStack<T> implements IStack<T> {
	private MyList<T> list;
	private int space = 10000;

	/**
	 * Initialize stack with a given size.
	 * 
	 * @param space
	 */
	public MyStack(int space) {
		this();
		this.space = space;
	}

	/**
	 * Initialize stack with space of 10000
	 * 
	 */
	public MyStack() {
		list = new MyList<T>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lucaslouca.stacksqueues.IStack#pop()
	 */
	public T pop() {
		if (list.isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		} else {
			T item = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			space++;
			return item;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lucaslouca.stacksqueues.IStack#push(T)
	 */
	public void push(T item) {
		if (space == 0) {
			throw new RuntimeException("Stack is full!");
		} else {
			list.add(item);
			space--;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lucaslouca.stacksqueues.IStack#peek()
	 */
	public T peek() {
		return list.get(list.size() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lucaslouca.stacksqueues.IStack#isFull()
	 */
	public boolean isFull() {
		return this.space == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lucaslouca.stacksqueues.IStack#isEmpty()
	 */
	public boolean isEmpty() {
		return this.list.size() == 0;
	}

	/**
	 * String representation of the stack.
	 * 
	 * @return String representation of the stack.
	 */
	@Override
	public String toString() {
		String t = this.list.toString();
		return t.substring(0, t.length() - 1);
	}
}
