package datastructures;

public class MyBinaryTreeNode<T> {

	private T data;
	private MyBinaryTreeNode<T> left;
	private MyBinaryTreeNode<T> right;

	public MyBinaryTreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public MyBinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(MyBinaryTreeNode<T> left) {
		this.left = left;
	}

	public MyBinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(MyBinaryTreeNode<T> right) {
		this.right = right;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(" + this.data + " -> ");

		if (this.left != null) {
			sb.append(this.left.toString());
		} else {
			sb.append("null");
		}

		sb.append(", ");

		if (this.right != null) {
			sb.append(this.right.toString());
		} else {
			sb.append("null");
		}

		sb.append(")");

		return sb.toString();
	}
}
