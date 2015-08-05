
import java.util.Collection;
import java.util.Iterator;

import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

/*
 * Doubly-linked list that uses two dummy Nodes for head and tail.
 */
public class MyLinkedList<E> implements MyList<E>, Iterable<E> {

	private class Node {
		public E data;
		public Node next;
		public Node prev;

		public Node(E data) {
			this.data = data;
		}
	}

	private class MyIterator implements Iterator<E> {

		private Node cur;
		private boolean canRemove;

		public MyIterator() {
			cur = head.next;
			canRemove = false;
		}

		/**
		 * Returns true if the iteration has more elements.
		 */
		public boolean hasNext() {
			return cur != tail;
		}

		/**
		 * Returns the next element in the iteration.
		 */
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}

			E data = cur.data;
			cur = cur.next;
			canRemove = true;
			return data;
		}

		/**
		 * Removes the last element returned by this iterator. This method can
		 * be called only once per call to next(). The behavior of an iterator
		 * is unspecified if the underlying collection is modified while the
		 * iteration is in progress in any way other than by calling this method.
		 */
		public void remove() {
			if(!canRemove) {
				throw new IllegalStateException();
			}

			cur.prev = cur.prev.prev;
			cur.prev.next = cur;
			canRemove = false;
			--size;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public MyLinkedList() {
		head = new Node(null);	// dummy node
		tail = new Node(null);	// dummy node
		clear();
	}

	// O(n)
	public MyLinkedList(E[] elements) {
		this();
		for(int i = 0; i < elements.length; ++i) {
			add(elements[i]);
		}
	}

	// O(1)
	public boolean add(E element) {
		insertAfter(tail.prev, new Node(element));
		return true;
	}

	// O(n)
	public void add(int index, E element) {
		insertAfter(getNode(index).prev, new Node(element));
	}

	// O(c)  number of elements in the Collection c
	public boolean addAll(Collection<? extends E> c) {
		for(E element : c) {
			add(element);
		}
		return c.size() > 0;
	}

	// O(1)
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	// O(n)
	public boolean contains(Object obj) {
		Node cur = head.next;
		while(cur != tail) {
			if(cur.data.equals(obj)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	// O(n^2) time, O(1) space
	public boolean containsAll(Collection<?> c) {
		for(Object x : c) {
			if(!contains(x)){
				return false;
			}
		}
		return true;
	}

	// O(n)
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		return getNode(index).data;
	}

	// O(n)
	// returns tail node for index = size
	private Node getNode(int index) {
		if(index <= size()/2) {
			// front half
			Node cur = head.next;
			for(int i = 0; i < index; ++i) {
				cur = cur.next;
			}
			return cur;
		}

		// back half
		Node cur = tail;
		for(int i = size(); i > index; --i) {
			cur = cur.prev;
		}
		return cur;
	}

	// O(n)
	public int indexOf(Object obj) {
		int index = 0;
		for(E x : this) {
			if(x.equals(obj)) {
				return index;
			}
			++index;
		}
		return -1;
	}

	// O(1)
	private void insertAfter(Node cur, Node newNode) {
		newNode.prev = cur;
		newNode.next = cur.next;
		cur.next = newNode;
		newNode.next.prev = newNode;

		++size;
	}

	// O(1)
	public boolean isEmpty() {
		return size() == 0;
	}

	// O(1)
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	// O(n)
	public int lastIndexOf(Object obj) {
		int index = size() -1;
		Node cur = tail.prev;
		while(cur != head) {
			if(cur.data.equals(obj)) {
				return index;
			}
			--index;
			cur = cur.prev;
		}
		return -1;
	}

	// O(n)
	public E remove(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		E val = null;
		Iterator<E> iter = iterator();
		for(int i = 0; i <= index; ++i) {
			val = iter.next();
		}
		iter.remove();

		return val;
	}

	// O(n)
	public boolean remove(Object obj) {
		Iterator<E> iter = iterator();
		while(iter.hasNext()) {
			if(iter.next().equals(obj)) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

	// Suppose Collection c has C elements.
	// Complexity of removeAll depends on complexity of c.contians().
	// If c.contains() is O(1), then removeAll() is O(n).			Ex. HashSet
	// If c.contains() is O(C), then removeAll() is O(n*C).			Ex. LinkedList or unsorted ArrayList
	// If c.contains() is O(log C) then removeAll() is O(n*log C)	Ex. Sorted ArrayList or binary search tree
	public boolean removeAll(Collection<?> c) {
		Iterator<E> iter = iterator();
		boolean changed = false;
		while(iter.hasNext()) {
			if(c.contains(iter.next())) {
				iter.remove();
				changed = true;
			}
		}
		return changed;
	}

	// same complexity as removeAll()
	public boolean retainAll(Collection<?> c) {
		Iterator<E> iter = iterator();
		boolean changed = false;
		while(iter.hasNext()) {
			if(!c.contains(iter.next())) {
				iter.remove();
				changed = true;
			}
		}
		return changed;
	}

	// O(n)
	public E set(int index, E element) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		Node node = getNode(index);  // O(n)
		E oldData = node.data;
		node.data = element;

		return oldData;
	}

	// O(1)
	public int size() {
		return size;
	}

	// O(n)
	public Object[] toArray() {
		Object[] arr = new Object[size()];
		int i = 0;
		for(E element : this) {
			arr[i] = element;
			++i;
		}
		return arr;
	}

	// O(n)
	public boolean equals(Object obj) {
		if(!(obj instanceof MyLinkedList)) {
			return false;
		}

		MyLinkedList other = (MyLinkedList<?>)obj;
		if(other.size() != size()) {
			return false;
		}

		Iterator<E> iter1 = iterator();
		Iterator<?> iter2 = other.iterator();
		while(iter1.hasNext()) {
			if(!(iter1.next().equals(iter2.next()))) {
				return false;
			}
		}

		return true;
	}

	public String toString() {
	    StringBuilder result = new StringBuilder(size() + 2);
	    result.append("[");
	    for(E element : this) {
	    	result.append(element.toString() + ", ");
	    }
	    result.append("]");
	    return result.toString();
	}

}