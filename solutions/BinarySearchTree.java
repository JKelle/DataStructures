
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable> implements BST<E> {

	Node root = null;
	int size = 0;

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
		if(root == null) {
			root = new Node(element);
		}
		else {
			add(root, element);
		}
		size++;
	}

	private void add(Node curNode, E newElement) {
		if(newElement.compareTo(curNode.data) < 0) {
			// go left
			if(curNode.left == null) {
				curNode.left = new Node(newElement);
			}
			else {
				add(curNode.left, newElement);
			}
		}
		else if(newElement.compareTo(curNode.data) > 0) {
			// go right
			if(curNode.right == null) {
				curNode.right = new Node(newElement);
			}
			else {
				add(curNode.right, newElement);
			}
		}
		else {
			throw new IllegalArgumentException("element already in tree");
		}
	}

	/**
	 * Determine if the tree contains a specified element.
	 * @return true if this tree contains the specified element, false otherwise.
	 *
	 * Average case: O(log n)
	 * Worst case:   O(n)
	 */
	public boolean contains(E element) {
		Node curNode = root;
		while(curNode != null) {
			if(element.equals(curNode.data)) {
				return true;
			}
			else if(element.compareTo(curNode.data) < 0) {
				curNode = curNode.left;
			}
			else {
				curNode = curNode.right;
			}
		}
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
		// node doesn't exist in the tree; nothing to remove
		if(size() == 0) {
			return false;
		}

		Node curNode = root;
		Node parent = null;

		// find the node to remove and its parent node
		while(curNode != null && element.compareTo(curNode.data) != 0) {
			parent = curNode;

			if(element.compareTo(curNode.data) < 0) {
				curNode = curNode.left;
			}
			else {
				curNode = curNode.right;
			}
		}

		// node doesn't exist in the tree; nothing to remove
		if(curNode == null) {
			return false;
		}

		removeNode(curNode, parent);
		return true;
	}

	private void removeNode(Node curNode, Node parent) {
		// case 1: no children
		// simply remove this node by setting its parent's reference to null
		if(curNode.left == null && curNode.right == null) {
			if(parent == null) {
				// tree is only one node; removing root
				root = null;
			}
			else if(curNode == parent.left) {
				parent.left = null;
			}
			else {
				parent.right = null;
			}

			size--;
			return;
		}

		// case 2: one child
		// remove this node and replace it with its only child
		if(curNode.left == null || curNode.right == null) {
			Node child;
			if(curNode.left != null) {
				child = curNode.left;
			}
			else {
				child = curNode.right;
			}

			if(parent == null) {
				// remove root
				root = child;
			}
			else if(curNode == parent.left) {
				parent.left = child;
			}
			else {
				parent.right = child;
			}

			size--;
			return;
		}

		// case 3: two children
		// 1. find curNode's neighbor in inOrder traversal. Call this node T.
		// 2. overwrite curNode's data with T's data.
		// 3. recursively call remove on T.
		Node t = curNode.right;
		Node tParent = curNode;
		while(t.left != null) {
			tParent = t;
			t = t.left;
		}

		/*

		OR

		Node t = curNode.left;
		Node tParent = curNode;
		while(t.right != null) {
			tParent = t;
			t = t.right;
		}
		*/

		curNode.data = t.data;
		removeNode(t, tParent);
	}

	/**
	 * @return the number of elements in this collection.
	 *
	 * O(1)
	 */
	public int size() {
		return size;
	}

}
