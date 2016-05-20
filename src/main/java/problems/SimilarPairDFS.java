package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * You are given a tree where each node is labeled from to . How many similar
 * pairs(S) are there in this tree?
 * 
 * A pair (A,B) is a similar pair if the following are true:
 * 
 * - node A is the ancestor of node B
 * 
 * - abs(A-B) <= T
 * 
 * Input format: The first line of the input contains two integers, n and T.
 * This is followed by n-1 lines, each containing two integers s_i and e_i where
 * node s_i is a parent to node e_i.
 * 
 * Output format:
 * 
 * Output a single integer which denotes the number of similar pairs in the
 * tree.
 * 
 * Sample Input:
 * 
 * 5 2
 * 
 * 3 2
 * 
 * 3 1
 * 
 * 1 4
 * 
 * 1 5
 * 
 * 
 * Sample Output:
 * 
 * 4
 * 
 * Explanation:
 * 
 * The similar pairs are: (3, 2) (3, 1) (3, 4) (3, 5).
 * 
 * 
 * @author lucas
 *
 */
public class SimilarPairDFS {
	static class MyTreeNode<T> {
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
	
	static class FasterScanner {
		private InputStream mIs;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FasterScanner() {
			this(System.in);
		}

		public FasterScanner(InputStream is) {
			mIs = is;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = mIs.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}

	// 5 2
	//
	// 3 2
	// 3 1
	// 1 4
	// 1 5
	

	private static int computePairsForParent(MyTreeNode<Integer> node, Integer ancestorValue,  int t, int count) {
		if (node.getChildren().isEmpty()) {
			return count;
		} else {
			for (MyTreeNode<Integer> child:node.getChildren()) {
				if (Math.abs(ancestorValue - child.getData()) <= t) {
					count++;
				}
				
				count += computePairsForParent(child, ancestorValue, t, 0);
			}
			
			return count;
		}
	}
	
	private static int solve(MyTreeNode<Integer>[] treeNodes, int t) {
		int n = treeNodes.length-1;
		
		int count = 0;
		for (int i=0; i<=n; i++) {
			if (treeNodes[i] != null) {
				count += computePairsForParent(treeNodes[i], treeNodes[i].getData(), t, 0);
			}
		}
		
		return count;
	}


	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		FasterScanner scanner = new FasterScanner(System.in);

		int n = scanner.nextInt();
		int t = scanner.nextInt();
		MyTreeNode<Integer>[] treeNodes = new MyTreeNode[n+1];
		for (int i = 0; i < n-1; i++) {
			int parent = scanner.nextInt();
			int child = scanner.nextInt();
			
			if (treeNodes[child] == null) {
				treeNodes[child] = new MyTreeNode<Integer>(child);
			}
			
			if (treeNodes[parent] == null) {
				treeNodes[parent] = new MyTreeNode<Integer>(parent);
			}
			
			
			treeNodes[parent].addChild(treeNodes[child]);
		}

		int result = solve(treeNodes, t);
		System.out.println(result);

	}

}
