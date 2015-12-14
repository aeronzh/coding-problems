package problems;

public class MyLinkedListNode<T> {
	public T value;
	public MyLinkedListNode<T> next = null;
	public MyLinkedListNode<T> tail = null;
	private int size;

	public MyLinkedListNode() {
		tail = this;
	}

	public void add(T data) {
		MyLinkedListNode<T> node = new MyLinkedListNode<T>();
		node.value = data;

		MyLinkedListNode<T> oldTail = tail;
		tail = node;
		oldTail.next = node;

		size++;
	}

	public MyLinkedListNode<T> get(int index) {
		MyLinkedListNode<T> node = next;
		int count = 0;
		while (node != null) {
			if (count == index) {
				return node;
			}
			node = node.next;
			count++;
		}

		return null;
	}

	public MyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(MyLinkedListNode<T> next) {
		this.next = next;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		MyLinkedListNode<T> node = this;
		while (node != null) {
			sb.append(node.value + " ");

			node = node.next;
		}
		sb.append("]");

		return sb.toString();
	}

	public int size() {
		return size;
	}

}
