
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class MyQueue<E> implements MyQueueInterface<E> {

	private LinkedList<E> list;

	public MyQueue() {
		// your code here
	}

	/**
	 * Adds the specified element to the back of this queue.
	 * @param element - the element to add
	 *
	 * O(1)
	 */
	public void add(E element) {
		// your code here
	}

	/**
	 * Tests if this queue is empty.
	 * @return true if and only if this queue contains no items; false otherwise.
	 *
	 * O(1)
	 */
	public boolean isEmpty() {
		// your code here
		return false;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * @return the object at the front of this queue.
	 * @throw NoSuchElementException if this queue is empty.
	 *
	 * O(1)
	 */
	public E peek() {
		// your code here
		return null;
	}

	/**
	 * Retrieves and removes the head of this queue.
	 * @return the head of this queue
	 * @throw NoSuchElementException if this queue is empty.
	 *
	 * O(1)
	 */
	public E remove() {
		// your code here
		return null;
	}
}