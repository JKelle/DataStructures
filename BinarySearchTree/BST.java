
import java.util.List;

public interface BST<E> {

	/**
	 * Adds the specified element to this tree.
	 * @param element: the element to add to the tree.
	 *
	 * Average case: O(log n)
	 * Worst case:   O(n)
	 */
	public void add(E element);

	/**
	 * Determine if the tree contains a specified element.
	 * @return true if this tree contains the specified element, false otherwise.
	 *
	 * Average case: O(log n)
	 * Worst case:   O(n)
	 */
	public boolean contains(E element);

	/**
	 * Performs an in-order traversal of this tree. The implementation is iterative.
	 * @return a List with the elements in sorted order.
	 *
	 * O(n)
	 */
	public List<E> inOrderIterative();

	/**
	 * Performs an in-order traversal of this tree. The implementation is recursive.
	 * @return a List with the elements in sorted order.
	 *
	 * O(n)
	 */
	public List<E> inOrderRecursive();

	/**
	 * Performs a post-order traversal of this tree. The implementation is iterative.
	 * @return a List with the elements in post order.
	 *
	 * O(n)
	 */
	public List<E> postOrderIterative();

	/**
	 * Performs a post-order traversal of this tree. The implementation is recursive.
	 * @return a List with the elements in post order.
	 *
	 * O(n)
	 */
	public List<E> postOrderRecursive();

	/**
	 * Performs a pre-order traversal of this tree. The implementation is iterative.
	 * @return a List with the elements in pre order.
	 *
	 * O(n)
	 */
	public List<E> preOrderIterative();

	/**
	 * Performs a pre-order traversal of this tree. The implementation is recursive.
	 * @return a List with the elements in pre order.
	 *
	 * O(n)
	 */
	public List<E> preOrderRecursive();

	/**
	 * Removes the first occurance specified element from this tree, if it's present.
	 * @param element: the element to remove
	 * @return true of the tree changed as a result of this call, false otherwise.
	 *
	 * Average case: O(log n)
	 * Worst case:   O(n)
	 */
	public boolean remove(E element);

	/**
	 * @return the number of elements in this collection.
	 *
	 * O(1)
	 */
	public int size();

}