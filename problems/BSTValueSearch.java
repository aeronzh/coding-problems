package problems;

/**
 * Given a BST write a function that looks for a value.
 * 
 * @author lucas
 *
 */
public class BSTValueSearch {

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

		public int search(int value) {
			if (this.value == value) {
				return value;
			} else {
				if (value <= this.value) {
					if (this.left != null) {
						return this.left.search(value);
					}
				} else {
					if (this.right != null) {
						return this.right.search(value);
					}
				}
				
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		BSTNode tree = new BSTNode(6);
		tree.add(3);
		tree.add(2);
		tree.add(4);
		tree.add(7);

		System.out.println(tree.toString());
		System.out.println(tree.search(4));
	}

}
