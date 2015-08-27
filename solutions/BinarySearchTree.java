
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
	 * Performs an in-order traversal of this tree. The implementation is iterative.
	 * @return a List with the elements in sorted order.
	 *
	 * O(n)
	 */
	public List<E> inOrderIterative() {
		ArrayList<E> list = new ArrayList<E>(size());
		Stack<Node> stack = new Stack<Node>();
		Node curNode = null;
		boolean goLeft = true;

		while(list.size() < size()) {
			if(curNode == null) {
				curNode = root;
				goLeft = true;
			}
			else if(curNode.right == null) {
				// go back up the tree
				curNode = stack.pop();
				goLeft = false;
			}
			else {
				// keep going down the tree
				curNode = curNode.right;
				goLeft = true;
			}

			while(goLeft && curNode.left != null) {
				stack.push(curNode);
				curNode = curNode.left;
			}

			list.add(curNode.data);
		}

		return list;
	}

	/**
	 * Performs an in-order traversal of this tree. The implementation is recursive.
	 * @return a List with the elements in sorted order.
	 *
	 * O(n)
	 */
	public List<E> inOrderRecursive() {
		ArrayList<E> list = new ArrayList<E>(size());
		inOrderRecursiveHelper(root, list);
		return list;
	}

	private void inOrderRecursiveHelper(Node curNode, List<E> list) {
		if(curNode != null) {
			inOrderRecursiveHelper(curNode.left, list);
			list.add(curNode.data);
			inOrderRecursiveHelper(curNode.right, list);
		}
	}

	/**
	 * Performs a post-order traversal of this tree. The implementation is iterative.
	 * @return a List with the elements in post order.
	 *
	 * O(n)
	 */
	public List<E> postOrderIterative() {
		ArrayList<E> list = new ArrayList<E>(size());

		if(size() == 0) {
			return list;
		}

		Stack<Node> stack1 = new Stack<Node>();
		stack1.add(root);
		Stack<E> stack2 = new Stack<E>();
		Node curNode = null;

		// compute the reverse of postOrder, storing the data in stack2
		while(!stack1.isEmpty()) {
			curNode = stack1.pop();
			stack2.push(curNode.data);

			if(curNode.left != null) {
				stack1.push(curNode.left);
			}
			if(curNode.right != null) {
				stack1.push(curNode.right);
			}
		}

		// reverse the reversed ordering
		while(!stack2.isEmpty()) {
			list.add(stack2.pop());
		}

		return list;
	}

	/**
	 * Performs a post-order traversal of this tree. The implementation is recursive.
	 * @return a List with the elements in post order.
	 *
	 * O(n)
	 */
	public List<E> postOrderRecursive() {
		ArrayList<E> list = new ArrayList<E>(size());
		postOrderRecursiveHelper(root, list);
		return list;
	}

	private void postOrderRecursiveHelper(Node curNode, List<E> list) {
		if(curNode != null) {
			postOrderRecursiveHelper(curNode.left, list);
			postOrderRecursiveHelper(curNode.right, list);
			list.add(curNode.data);
		}
	}

	/**
	 * Performs a pre-order traversal of this tree. The implementation is iterative.
	 * @return a List with the elements in pre order.
	 *
	 * O(n)
	 */
	public List<E> preOrderIterative() {
		ArrayList<E> list = new ArrayList<E>(size());

		// if the tree is empty, just return an empty list
		if(size() == 0) {
			return list;
		}

		// create a stack, and push the root to it
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		Node curNode = null;

		while(!stack.isEmpty()) {
			// take the first Node off the stack, and add it's data to the list
			curNode = stack.pop();
			list.add(curNode.data);

			// push the current node's children to the stack.
			// push the right child first, so the left subtree will be evaluated first.
			if(curNode.right != null) {
				stack.push(curNode.right);
			}
			if(curNode.left != null) {
				stack.push(curNode.left);
			}
		}

		return list;
	}

	/**
	 * Performs a pre-order traversal of this tree. The implementation is recursive.
	 * @return a List with the elements in pre order.
	 *
	 * O(n)
	 */
	public List<E> preOrderRecursive() {
		ArrayList<E> list = new ArrayList<E>(size());
		preOrderRecursiveHelper(root, list);
		return list;
	}

	private void preOrderRecursiveHelper(Node curNode, List<E> list) {
		if(curNode != null) {
			list.add(curNode.data);
			preOrderRecursiveHelper(curNode.left, list);
			preOrderRecursiveHelper(curNode.right, list);
		}
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



























