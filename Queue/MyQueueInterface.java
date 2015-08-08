
public interface MyQueueInterface<E> {

	/**
	 * Adds the specified element to the back of this queue.
	 * @param element - the element to add
	 *
	 * O(1)
	 */
	public void add(E element);

	/**
	 * Tests if this queue is empty.
	 * @return true if and only if this queue contains no items; false otherwise.
	 *
	 * O(1)
	 */
	public boolean isEmpty();

	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * @return the object at the front of this queue.
	 * @throw NoSuchElementException if this queue is empty.
	 *
	 * O(1)
	 */
	public E peek();

	/**
	 * Retrieves and removes the head of this queue.
	 * @return the head of this queue
	 * @throw NoSuchElementException if this queue is empty.
	 *
	 * O(1)
	 */
	public E remove();

}