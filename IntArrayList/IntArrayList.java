
public class IntArrayList {
	private int[] arr;
	private int size;

	public IntArrayList() {
		arr = new int[10];
		size = 0;
	}

	/**
	 * Constructor that initializes this list with specified values.
	 * post: this list does not contian references to vals
	 * @param vals is an array of numbers that should be copied into this list
	 */
	public IntArrayList(int[] vals) {
		size = vals.length;
		arr = new int[size];
		for(int i = 0; i < size; ++i) {
			arr[i] = vals[i];
		}
	}

	/**
	 * Return the number of elements in this list
	 * @return the number of elements in this list
	 */
	public int size() {
		// your code here
		return -1;
	}

	/**
	 * Add a new element to the end of this list.
	 * post: the last element of this list is val
	 * @param val is the element to be added to the end of this list
	 */
	public void add(int val) {
		// your code here
	}

	/**
	 * Add a new element to the front of this list.
	 * post: the first element of this list is val
	 * @param val is the element to be added to the front of this list
	 */
	public void addFront(int val) {
		// your code here
	}

	/**
	 * Insert a new element into this list at a specified index.
	 * pre: 0 <= pos <= size()
	 * post: val is located at index pos
	 * @param val is the element to be inserted into this list
	 * @param pos is the position (index) in the list at which to insert val
	 */
	public void insert(int pos, int val) {
		// your code here
	}

	/**
	 * Sets the value of the element at a given index
	 * pre: 0 <= pos < size()
	 * post: val is located at index pos
	 * @param val is the new element that will overwrite the element at index pos
	 * @param pos is the position (index) in the list at which to insert val
	 */
	public void set(int pos, int val) {
		// your code here
	}

	/**
	 * Get an element from this list
	 * pre: 0 <= pos < size()
	 * @param pos is the position (index) of the returned element
	 * @return the element at the given index in this list
	 */
	public int get(int pos) {
		// your code here
		return -1;
	}

	/**
	 * Remove the first occurance of val in this list if it exists.
	 * If an element was removed, return true. Otherwise, return false.
	 * @param val is the element to be removed
	 * @return true if an element was removed, false otherwise
	 */
	public boolean remove(int val) {
		// your code here
		return false;
	}

	/**
	 * Remove all occurances of val in this list if it exists.
	 * If an element was removed, return true. Otherwise, return false.
	 * @param val is the element to be removed
	 * @return true if an element was removed, false otherwise
	 */
	public boolean removeAll(int val) {
		// your code here
		return false;
	}

	/**
	 * Remove the element at a given position, and return that element.
	 * pre: 0 <= pos < size()
	 * @param pos is the index of the element to remove
	 * @return the removed element
	 */
	public int removePos(int pos) {
		// your code here
		return -1;
	}

	/**
	 * Remove the first element in this list
	 * pre: size() > 0
	 * @return the removed element
	 */
	public int removeFront() {
		// your code here
		return -1;
	}

	/**
	 * Remove the last element in this list
	 * pre: size() > 0
	 * @return the removed element
	 */
	public int removeBack() {
		// your code here
		return -1;
	}

	/**
	 * Remove a range of elements
	 * pre: 0 <= start <= end <= size()
	 * @param start is the starting index of the range, inclusive
	 * @param end is the ending index of the range, exclusive
	 */
	public void removeRange(int start, int end) {
		// your code here
	}

	/**
	 * Find the index of a given element
	 * @param val is the element to find
	 * @return the index of val, or -1 if val is not in the list
	 */
	public int indexOf(int val) {
		// your code here
		return -1;
	}

	/**
	 * Find the index of a given element, starting from a given position
	 * pre: pos >= 0
	 * post: this list is unchanged
	 * @param val is the element to find
	 * @param pos is the first element to consider. Ignore any elements before pos
	 * @return the index of val, or -1 if val is not in the list
	 */
	public int indexOf(int val, int pos) {
		// your code here
		return -1;
	}

	/**
	 * Remove all the elements from the list
	 * post: size() = 0
	 */
	public void clear() {
		// your code here
	}

	/**
	 * Create a new IntArrayList that is a contiguous sublist of this list
	 * pre: 0 <= start <= end <= size()
	 * post: this list is unchanged
	 * @param start is the starting index of the range, inclusive
	 * @param end is the ending index of the range, exclusive
	 * @return new IntArrayList
	 */
	public IntArrayList getSubList(int start, int end) {
		// your code here
		return new IntArrayList();
	}

	/**
	 * Check if this list is equal to another Object
	 * @param other is any Object
	 * @return true if other is also an IntArrayList and has the same elements in
	 * the same order as this list.
	 */
	public boolean equals(Object other) {
		if (other == null || !(other instanceof IntArrayList)) {
			return false;
		}

		// cast other to type IntArrayList
		IntArrayList otherList = (IntArrayList)other;

		// If the two lists are equal, they must
		// have the same number of elements.
		if (otherList.size() != this.size()) {
			return false;
		}

		for(int i = 0; i < this.size(); i++) {
			if (this.get(i) != otherList.get(i)) {
				return false;
			}
		}

		return true;
	}

	public String toString() {
	    StringBuilder result = new StringBuilder(size() + 2);
	    result.append("[");
	    for(int x : arr) {
	    	result.append(x + ", ");
	    }
	    result.append("]");
	    return result.toString();
	}
}
