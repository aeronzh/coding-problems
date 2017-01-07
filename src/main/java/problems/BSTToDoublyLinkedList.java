package problems;

/**
 * Created by lucas on 07/01/2017.
 */
public class BSTToDoublyLinkedList {
    static class BST<T extends Comparable<T>> {
        private T data;
        private BST<T> left = null;
        private BST<T> right = null;

        private BST<T> next = null;
        private BST<T> prev = null;

        public BST(T data) {
            this.data = data;
        }

        public BST<T> addNode(T newData) {
            BST<T> result;

            if (newData.compareTo(this.data) <= 0) {
                // Go left
                if (left == null) {
                    left = new BST<T>(newData);
                    result = left;
                } else {
                    result = left.addNode(newData);
                }
            } else {
                // Go right
                if (right == null) {
                    right = new BST<T>(newData);
                    result = right;
                } else {
                    result = right.addNode(newData);
                }
            }

            return result;
        }

        public String toString() {
            StringBuilder result = new StringBuilder("[");
            result.append(this.data.toString());
            if (left != null || right != null) {
                result.append("->");
                if (left != null) {
                    result.append(left.toString());
                }
                if (right != null) {
                    result.append(right.toString());
                }
            }
            result.append("]");
            return result.toString();
        }
    }


    static BST<Integer> prev = null;
    static BST<Integer> head = null;

    private static void inorderTraversal(BST<Integer> node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        node.prev = prev;
        if (prev != null) {
            prev.next = node;
        } else {
            head = node;
        }

        // Uncomment for circled linked list
//        head.prev = node;
//        node.next = head;


        prev = node;

        inorderTraversal(node.right);
    }


    public static void main(String[] args) {
        BST<Integer> root = new BST<Integer>(5);
        root.addNode(1);
        root.addNode(10);
        root.addNode(8);
        root.addNode(2);

        inorderTraversal(root);

        // Print Tree
        System.out.println(root);

        // Print List
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
