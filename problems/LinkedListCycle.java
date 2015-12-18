package problems;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * @author lucas
 *
 */
public class LinkedListCycle {
	private static class Node<T> {
		public Node next = null;
		public T data;

		public Node(T data) {
			this.data = data;
		}
	}

	public static boolean detect(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head;

		// a -> b -> a
		while (fast != null) {
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			}

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Node<Integer> head = new Node(1);
		Node<Integer> node2 = new Node(2);
		Node<Integer> node3 = new Node(3);
		Node<Integer> node4 = new Node(4);
		Node<Integer> node5 = new Node(5);
		Node<Integer> node6 = new Node(6);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;

		System.out.println(detect(head));
	}

}
