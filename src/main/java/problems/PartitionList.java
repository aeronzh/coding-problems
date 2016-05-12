package problems;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * 
 * @author lucas
 *
 */
public class PartitionList {

	public static void solve(MyLinkedListNode<Integer> n, int x) {
		MyLinkedListNode<Integer> node = n;
		MyLinkedListNode<Integer> tmp = node;
		while (node != null) {
			while (node!=null && node.value < x) {
				node = node.next;
			} 
			
			if (node== null) {
				return;
			}
			
			// found one that is >= swap current with next
			tmp = node.next;

			node.next = node;
			node = tmp;
			
			
		}
		System.out.println(n + " - "+node);
	}

	public static void main(String[] args) {
		MyLinkedListNode<Integer> n1 = new MyLinkedListNode<Integer>();
		n1.value = 1;
		MyLinkedListNode<Integer> n2 = new MyLinkedListNode<Integer>();
		n2.value = 4;
		MyLinkedListNode<Integer> n3 = new MyLinkedListNode<Integer>();
		n3.value = 3;
		MyLinkedListNode<Integer> n4 = new MyLinkedListNode<Integer>();
		n4.value = 2;
		MyLinkedListNode<Integer> n5 = new MyLinkedListNode<Integer>();
		n5.value = 5;
		MyLinkedListNode<Integer> n6 = new MyLinkedListNode<Integer>();
		n6.value = 2;

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);

		System.out.println(n1);
		solve(n1, 3);
		System.out.println(n1);
	}

}
