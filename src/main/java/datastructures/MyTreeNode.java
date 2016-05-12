package datastructures;

import java.util.ArrayList;
import java.util.List;

public class MyTreeNode<T> {
	private MyTreeNode<T> parent;
	private T data;
	private List<MyTreeNode<T>> children;

	/**
	 * Constructor: Create a Tree with one node.
	 * 
	 * @param data
	 *            Data for the node.
	 */
	public MyTreeNode(T data) {
		this.data = data;
		setChildren(new ArrayList<MyTreeNode<T>>());
	}

	/**
	 * Get all children of this Tree
	 * 
	 * @return children of this tree
	 */
	public List<MyTreeNode<T>> getChildren() {
		return children;
	}

	/**
	 * Add a child node to this node's children
	 * 
	 * @param data
	 *            the data the new child node will hold
	 */
	public void addChild(T data) {
		MyTreeNode<T> child = new MyTreeNode<T>(data);
		child.setParent(this);
		getChildren().add(child);
	}

	/**
	 * Add a child node to this node's children
	 * 
	 * @param child
	 *            the new child to add
	 */
	public void addChild(MyTreeNode<T> child) {
		child.setParent(this);
		getChildren().add(child);
	}

	/**
	 * Set the parent of the TreeNode.
	 * 
	 * @param parent
	 *            the parent to be set.
	 */
	private void setParent(MyTreeNode<T> parent) {
		this.parent = parent;
	}

	/**
	 * Get the parent of this TreeNode.
	 * 
	 * @return the parent of this tree node.
	 */
	public MyTreeNode<T> getParent() {
		return parent;
	}

	/**
	 * Get the data of this tree node.
	 * 
	 * @return data that this tree node holds
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data of this node
	 * 
	 * @param data
	 *            the data that this tree node will hold
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Return String representation of this tree
	 * 
	 * @return String representation of this node and its children
	 */
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		result.append(this.data.toString());
		if (!getChildren().isEmpty()) {
			result.append("->");
			for (MyTreeNode<T> child : getChildren()) {
				result.append(child.toString());
			}
		}
		result.append("]");
		return result.toString();
	}

	/**
	 * Returns whether or not this node is a Leaf. A node is considered a leaf
	 * when it doesn't contain any children.
	 * 
	 * @return true if node is leaf node, false otherwise.
	 */
	public boolean isLeaf() {
		return this.getChildren().size() == 0;
	}

	public void setChildren(List<MyTreeNode<T>> children) {
		this.children = children;
	}
}
