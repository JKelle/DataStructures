
public interface MyStackInterface<E> {

	/**
	 * Tests if this stack is empty.
	 * @return true if and only if this stack contains no items; false otherwise.
	 *
	 * O(1)
	 */
	public boolean isEmpty();

	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return the object at the top of this stack.
	 * @throw EmptyStackException if this stack is empty.
	 *
	 * O(1)
	 */
	public E peek();

	/**
	 * Removes and returns the object at the top of this stack.
	 * @return the object at the top of this stack.
	 * @throw EmptyStackException if this stack is empty.
	 *
	 * O(1)
	 */
	public E pop();

	/**
	 * Pushes an item onto the top of this stack.
	 * @param item - the item to be pushed onto this stack.
	 * @return the item argument.
	 *
	 * O(1)
	 */
	public E push(E item);
}