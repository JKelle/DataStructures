
public class GenericArrayList<E> {
	private E[] arr;
	private int size;

	@SuppressWarnings("unchecked")
	public GenericArrayList() {
		arr = (E[]) new Object[10];
		size = 0;
	}

	/**
	 * Constructor that initializes this list with specified values.
	 * post: this list does not contian references to vals
	 * @param vals is an array of type E that should be copied into this list
	 */
	@SuppressWarnings("unchecked")
	public GenericArrayList(E[] vals) {
		size = vals.length;
		arr = (E[]) new Object[size];
		for(int i = 0; i < size; ++i) {
			arr[i] = vals[i];
		}
	}

	/**
	 * Return the number of elements in this list
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		E[] newArr = (E[]) new Object[size() * 2];
		for(int i = 0; i < size(); ++i) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	/**
	 * Add a new element to the end of this list.
	 * post: the last element of this list is val
	 * @param val is the element to be added to the end of this list
	 */
	public void add(E val) {
		insert(size(), val);
	}

	/**
	 * Insert a new element into this list at a specified index.
	 * pre: 0 <= pos <= size()
	 * post: val is located at index pos
	 * @param val is the element to be inserted into this list
	 * @param pos is the position (index) in the list at which to insert val
	 */
	public void insert(int pos, E val) {
		if (size() == arr.length) {
			resize();
		}
		for(int i = size(); i > pos; --i) {
			arr[i] = arr[i - 1];
		}
		arr[pos] = val;
		++size;
	}

	/**
	 * Get an element from this list
	 * pre: 0 <= pos < size()
	 * @param pos is the position (index) of the returned element
	 * @return the element at the given index in this list
	 */
	public E get(int pos) {
		return arr[pos];
	}

	/**
	 * Remove the first occurance of val in this list if it exists.
	 * If an element was removed, return true. Otherwise, return false.
	 * @param val is the element to be removed
	 * @return true if an element was removed, false otherwise
	 */
	public boolean remove(E val) {
		int pos = indexOf(val);
		if (pos == -1) {
			return false;
		}
		removePos(pos);
		return true;
	}

	/**
	 * Remove the element at a given position, and return that element.
	 * pre: 0 <= pos < size()
	 * @param pos is the index of the element to remove
	 * @return the removed element
	 */
	public E removePos(int pos) {
		E val = arr[pos];
		for(int i = pos; i < size() - 1; ++i) {
			arr[i] = arr[i + 1];
		}
		--size;
		return val;
	}

	/**
	 * Find the index of a given element
	 * @param val is the element to find
	 * @return the index of val, or -1 if val is not in the list
	 */
	public int indexOf(E val) {
		for(int i = 0; i < size(); ++i) {
			if (arr[i] == val) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Remove all the elements from the list
	 * post: size() = 0
	 */
	public void clear() {
		size = 0;
	}

	/**
	 * Check if this list is equal to another Object
	 * @param other is any Object
	 * @return true if other is also an GenericArrayList and has the same elements in
	 * the same order as this list.
	 */
	public boolean equals(Object other) {
		if (other == null || !(other instanceof GenericArrayList<?>)) {
			return false;
		}

		// cast other to type GenericArrayList
		GenericArrayList<?> otherList = (GenericArrayList<?>)other;

		// If the two lists are equal, they must
		// have the same number of elements.
		if (otherList.size() != this.size()) {
			return false;
		}

		for(int i = 0; i < this.size(); i++) {
			if (!this.get(i).equals(otherList.get(i))) {
				return false;
			}
		}

		return true;
	}

	public String toString() {
	    StringBuilder result = new StringBuilder(size() + 2);
	    result.append("[");
	    for(E element : arr) {
	    	result.append(element.toString() + ", ");
	    }
	    result.append("]");
	    return result.toString();
	}
}