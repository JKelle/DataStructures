
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