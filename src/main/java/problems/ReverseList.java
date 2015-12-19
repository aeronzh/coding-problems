package problems;

/**
 * Reverse a singly linked list.
 * 
 * @author lucas
 *
 */
public class ReverseList {

	public static MyLinkedListNode<Integer> solveRecursive(MyLinkedListNode<Integer> n) {
		if (n.next == null) {
			// Reached last node
			return n;
		} else {
			// Call until we reach the last node and make that one the new first: 1->2->3->4->5 ==> 5->4->3->2->1
			MyLinkedListNode<Integer> newFirst = solveRecursive(n.next);
			newFirst.next = n;
			n.next = null;

			return n;
		}
	}

	public static void main(String[] args) {
		MyLinkedListNode<Integer> n1 = new MyLinkedListNode<Integer>();
		n1.value = 1;
		MyLinkedListNode<Integer> n2 = new MyLinkedListNode<Integer>();
		n2.value = 2;
		MyLinkedListNode<Integer> n3 = new MyLinkedListNode<Integer>();
		n3.value = 3;
		MyLinkedListNode<Integer> n4 = new MyLinkedListNode<Integer>();
		n4.value = 4;
		MyLinkedListNode<Integer> n5 = new MyLinkedListNode<Integer>();
		n5.value = 5;

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);

		System.out.println(n1);
		solveRecursive(n1);
		System.out.println(n5);
	}

}
