package problems;

/**
 * Created by lucas on 30/12/2016.
 */
public class AddTwoNumbers2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(val);

            ListNode dummy = next;
            while (dummy != null) {
                sb.append(",");
                sb.append(dummy.val);
                dummy = dummy.next;
            }

            sb.append("]");
            return sb.toString();
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode(0);
        ListNode head = tail;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int s = x + y + carry;

            if (s >= 10) {
                s = s % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            tail.val = s;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (l1 != null || l2 != null) {
                tail.next = new ListNode(0);
                tail = tail.next;
            }
        }

        if (carry == 1) {
            tail.next = new ListNode(1);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(l1, l2));

        l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l2 = new ListNode(0);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);
        System.out.println(addTwoNumbers(l1, l2));

        l1 = null;
        l2 = new ListNode(0);
        l2.next = new ListNode(1);
        System.out.println(addTwoNumbers(l1, l2));

        l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l2 = new ListNode(1);
        System.out.println(addTwoNumbers(l1, l2));
    }
}

