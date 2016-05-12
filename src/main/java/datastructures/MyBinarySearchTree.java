package datastructures;

public class MyBinarySearchTree<T extends Comparable<T>> {
	private T data;
	private MyBinarySearchTree<T> leftChild = null;
	private MyBinarySearchTree<T> rightChild = null;
	private MyBinarySearchTree<T> parent;

	public MyBinarySearchTree(T data) {
		this.data = data;
	}

	/**
	 * Add new data to the binary search tree and return the newly created
	 * subtree.
	 * 
	 * @param newData
	 *            the new data to add
	 * @return the newly created subtree
	 */
	public MyBinarySearchTree<T> addNode(T newData) {
		MyBinarySearchTree<T> result;

		if (newData.compareTo(this.data) <= 0) {
			// Go left
			if (leftChild == null) {
				leftChild = new MyBinarySearchTree<T>(newData);
				result = leftChild;
			} else {
				result = leftChild.addNode(newData);
			}
		} else {
			// Go right
			if (rightChild == null) {
				rightChild = new MyBinarySearchTree<T>(newData);
				result = rightChild;
			} else {
				result = rightChild.addNode(newData);
			}
		}

		if (result.getParent() == null) {
			result.setParent(this);
		}

		return result;
	}

	/**
	 * Return true if node is leaf, false otherwise.
	 * 
	 * @return true if node is leaf, false otherwise.
	 */
	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}

	/**
	 * Return String representation of this tree
	 * 
	 * @return String representation of this node and its children
	 */
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		result.append(this.data.toString());
		if (leftChild != null || rightChild != null) {
			result.append("->");
			if (leftChild != null) {
				result.append(leftChild.toString());
			}
			if (rightChild != null) {
				result.append(rightChild.toString());
			}
		}
		result.append("]");
		return result.toString();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public MyBinarySearchTree<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(MyBinarySearchTree<T> leftChild) {
		this.leftChild = leftChild;
	}

	public MyBinarySearchTree<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(MyBinarySearchTree<T> rightChild) {
		this.rightChild = rightChild;
	}

	public MyBinarySearchTree<T> getParent() {
		return parent;
	}

	public void setParent(MyBinarySearchTree<T> parent) {
		this.parent = parent;
	}
}
