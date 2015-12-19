package problems;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author lucas
 *
 */
public class SwapNodesInPairs {

	public static MyLinkedListNode<Integer> solve(MyLinkedListNode<Integer> n) {
		MyLinkedListNode<Integer> tmp = n.next;
		MyLinkedListNode<Integer> first = tmp;

		MyLinkedListNode<Integer> last = n;

		while (n.next != null && n.next.next != null) {
			tmp = n.next;
			n.setNext(tmp.next);
			tmp.setNext(n);

			last = n;
			n = n.next;

			last.setNext(last.next.next);
		}

		last.next.next = n;
		n.next = null;
		return first;
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
		MyLinkedListNode<Integer> n6 = new MyLinkedListNode<Integer>();
		n6.value = 6;

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);

		System.out.println(solve(n1));
	}
}
