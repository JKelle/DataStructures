
import java.util.List;

public class BinarySearchTree<E extends Comparable> implements BST<E> {

	private Node root;
	private int size;

	/**
	 * Node class. You shouldn't need to edit this class.
	 */
	private class Node {
		public E data;
		public Node left;
		public Node right;

		public Node(E data) {
			this.data = data;
		}
	}

	/**
	 * Adds the specified element to this tree.
	 * @param element: the element to add to the tree.
	 *
	 * Average case: O(log n)
	 * Worst case:   O(n)
	 */
	public void add(E element) {
		// your code here
	}

	/**
	 * Determine if the tree contains a specified element.
	 * @return true if this tree contains the specified element, false otherwise.
	 *
	 * Average case: O(log n)
	 * Worst case:   O(n)
	 */
	public boolean contains(E element) {
		// your code here
		return false;
	}

	/**
	 * Removes the first occurance specified element from this tree, if it's present.
	 * @param element: the element to remove
	 * @return true of the tree changed as a result of this call, false otherwise.
	 *
	 * Average case: O(log n)
	 * Worst case:   O(n)
	 */
	public boolean remove(E element) {
		// your code here
		return false;
	}

	/**
	 * @return the number of elements in this collection.
	 *
	 * O(1)
	 */
	public int size() {
		// your code here
		return -1;
	}

	/**
	 * Inspects the internal structure of this tree (how the nodes are linked),
	 * and checks if it's a valid binary search tree.
	 * 1. All nodes in the left sub-tree are less than this node.
	 * 2. All nodes in the right sub-tree are greater than this node.
	 * You shouldn't edit this method.
	 * @return true if this is a valid binary search tree, false otherwise.
	 *
	 * O(n)
	 */
	public boolean isValid() {
		if(root == null) {
			return true;
		}

		return isValidHelper(root.left, null, root.data) &&
		       isValidHelper(root.right, root.data, null);
	}

	/**
	 * recursive helper method for isValid()
	 */
	private boolean isValidHelper(Node cur, E lowerBound, E upperBound) {
		if(cur == null) {
			return true;
		}

		if(!(lowerBound == null || cur.data.compareTo(lowerBound) > 0)) {
			// current element is too large
			return false;
		}

		if(!(upperBound == null || cur.data.compareTo(upperBound) < 0)) {
			// current element is too small
			return false;
		}

		return isValidHelper(cur.left, lowerBound, min(cur.data, upperBound)) &&
		       isValidHelper(cur.left, max(cur.data, lowerBound), upperBound);
	}

	private E min(E elem1, E elem2) {
		if(elem1.compareTo(elem1) < 0) {
			return elem1;
		}
		return elem2;
	}

	private E max(E elem1, E elem2) {
		if(elem1.compareTo(elem1) > 0) {
			return elem1;
		}
		return elem2;
	}

}
