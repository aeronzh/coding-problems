package problems;

/**
 * Given a singly linked list L: L0->L1-> ... ->Ln-1->Ln, reorder it to:
 * L0->Ln->L1->Ln-1->L2->Ln-2->...
 * 
 * For example, given {1,2,3,4}, reorder it to {1,4,2,3}. You must do this
 * in-place without altering the nodes' values.
 * 
 * @author lucas
 *
 */
public class ReorderList {

	public static void solve(MyLinkedListNode<Integer> list) {
		System.out.println(list);
		int size = list.size();

		int b = size - 1;
		MyLinkedListNode<Integer> current = list.get(0);
		MyLinkedListNode<Integer> last = list.get(b);
		while (!current.equals(last)) {
			MyLinkedListNode<Integer> tmpANext = current.getNext();
			last = list.get(b);
			current.setNext(last);
			last.setNext(tmpANext);
			current = tmpANext;
			list.get(b).setNext(null);
		}
		System.out.println(list);
	}

	public static void main(String[] args) {
		MyLinkedListNode<Integer> list = new MyLinkedListNode<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		solve(list);
	}

}
