package problems;

/**
 * Given a BST write a maxDepth() function that returns the max depth of the
 * tree.
 * 
 * @author lucas
 *
 */
public class BSTMaxDepth {

	static class BSTNode {
		private int value;
		private BSTNode left = null;
		private BSTNode right = null;

		public BSTNode(int value) {
			this.value = value;
		}

		public void add(int value) {
			if (value <= this.value) {
				if (this.left == null) {
					this.left = new BSTNode(value);
				} else {
					this.left.add(value);
				}
			} else {
				if (this.right == null) {
					this.right = new BSTNode(value);
				} else {
					this.right.add(value);
				}
			}
		}

		public int maxDepth() {
			int l = 0;
			int r = 0;

			if (this.left != null) {
				l = left.maxDepth();
			}

			if (this.right != null) {
				r = right.maxDepth();
			}

			return Math.max(l, r) + 1;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("[");

			sb.append(this.value);
			if (this.left != null || this.right != null) {
				sb.append("->");
			}

			if (this.left != null) {
				sb.append(this.left.toString());
				sb.append(", ");
			}

			if (this.right != null) {
				sb.append(this.right.toString());
			}

			sb.append("]");

			return sb.toString();
		}

	}

	public static void main(String[] args) {
		BSTNode tree = new BSTNode(6);
		tree.add(3);
		tree.add(2);
		tree.add(4);
		tree.add(7);
		tree.add(8);
		tree.add(9);
		tree.add(10);

		System.out.println(tree);
		System.out.println(tree.maxDepth());
	}

}
