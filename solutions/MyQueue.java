
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class MyQueue<E> implements MyQueueInterface<E> {

	private LinkedList<E> list;

	public MyQueue() {
		list = new LinkedList<E>();
	}

	/**
	 * Adds the specified element to the back of this queue.
	 * @param element - the element to add
	 *
	 * O(1)
	 */
	public void add(E element) {
		list.add(element);
	}

	/**
	 * Tests if this queue is empty.
	 * @return true if and only if this queue contains no items; false otherwise.
	 *
	 * O(1)
	 */
	public boolean isEmpty() {
		return list.size() == 0;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue.
	 * @return the object at the front of this queue.
	 * @throw NoSuchElementException if this queue is empty.
	 *
	 * O(1)
	 */
	public E peek() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		return list.get(0);
	}

	/**
	 * Retrieves and removes the head of this queue.
	 * @return the head of this queue
	 * @throw NoSuchElementException if this queue is empty.
	 *
	 * O(1)
	 */
	public E remove() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		return list.remove(0);
	}
}