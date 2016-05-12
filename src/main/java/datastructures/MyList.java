package datastructures;

public class MyList<T> {

	private class Node {
		private Node next = null;
		private T data;

		public Node(T data) {
			this.data = data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public T getData() {
			return this.data;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return this.next;
		}
	}

	private Node head = null;
	private int size = 0;

	public MyList() {
		this.head = new Node(null);
	}

	/**
	 * Append value at the end of the List
	 * 
	 * @param value
	 */
	public void add(T value) {
		Node end = new Node(value);

		// search the end of the list
		Node n = this.head;
		while (n.getNext() != null) {
			n = n.getNext();
		}

		n.setNext(end);
		size++;
	}

	/**
	 * Removes the first element to be found that is equal to value
	 * 
	 * @param value
	 *            the value to be removed
	 */
	public void remove(T value) {
		Node n = this.head;
		while (n.getNext() != null) {
			if (n.getNext().getData().equals(value)) {
				n.setNext(n.getNext().getNext());
				size--;
				break;
			}
			n = n.getNext();
		}
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index out of bounds: " + index);
		}

		int count = 0;
		Node n = this.head;
		while (n.getNext() != null) {
			if (count == index) {
				n.setNext(n.getNext().getNext());
				size--;
				break;
			}
			n = n.getNext();
			count++;
		}
	}

	/**
	 * Get the element at position index from the List
	 * 
	 * @param index
	 *            the position of the element starting from 0.
	 * @throws IllegalArgumentException
	 *             when the index is out of bounds
	 * @return
	 */
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index out of bounds: " + index);
		}

		int count = 0;
		Node n = this.head;
		while (n.getNext() != null) {
			n = n.getNext();
			if (count == index) {
				return n.getData();
			}
			count++;
		}

		return null;
	}

	/**
	 * Returns the size of the list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		Node n = this.head;
		while (n.getNext() != null) {
			n = n.getNext();
			T data = n.getData();
			sb.append(data.toString());
			if (n.getNext() != null)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	/***************************/
	public T getKthFromLast(int k) {
		Node front = this.head;
		Node back = this.head;

		// move front k steps ahead
		for (int i = 0; i < k; i++) {
			front = front.getNext();
			if (front == null) {
				return null;
			}
		}

		// move both pointers
		while (front.getNext() != null) {
			front = front.getNext();
			back = back.getNext();
		}

		// we reached the end of the list. front now points to the last element
		// of the list. Back points k steps behind the last
		return back.getData();
	}

	public boolean isEmpty() {
		return this.size == 0;
	}
}
