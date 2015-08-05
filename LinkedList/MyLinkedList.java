
import java.util.Collection;
import java.util.Iterator;

/*
 * This file provides skeleton code for a linked list implementation. This class
 * implements the MyList<E> interface, which is a subset of the java List<E>
 * interface. See method descriptions in the MyList.java file.
 *
 * It is up to you whether to use singly-linked or doubly-linked nodes. Doubly-
 * linked nodes make the code easier, however they take up more memory. There is
 * a solution for both doubly- and singly-linked nodes.
 */
public class MyLinkedList<E> implements MyList<E>, Iterable<E> {

	private static class Node<E> {
		// your code here
	}

	private static class MyIterator<E> implements Iterator<E> {

		/**
		 * Returns true if the iteration has more elements.
		 */
		public boolean hasNext() {
			// your code here
			return false;
		}

		/**
		 * Returns the next element in the iteration.
		 */
		public E next() {
			// your code here
			return null;
		}

		/**
		 * Removes the last element returned by this iterator. This method can
		 * be called only once per call to next(). The behavior of an iterator
		 * is unspecified if the underlying collection is modified while the
		 * iteration is in progress in any way other than by calling this method.
		 */
		public void remove() {
			// your code here
		}

	}

	private Node<E> head;
	private Node<E> tail;

	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public boolean add(E element) {
		// your code here
		return false;
	}

	public void add(int index, E element) {
		// your code here
	}

	public boolean addAll(Collection<? extends E> c) {
		// your code here
		return false;
	}

	public void clear() {
		// your code here
	}

	public boolean contains(Object obj) {
		// your code here
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// your code here
		return false;
	}

	public boolean equals(Object obj) {
		// your code here
		return false;
	}

	public E get(int index) {
		// your code here
		return null;
	}

	public int indexOf(Object obj) {
		// your code here
		return -1;
	}

	public boolean isEmpty() {
		// your code here
		return false;
	}

	public Iterator<E> iterator() {
		// your code here
		return null;
	}

	public int lastIndexOf(Object obj) {
		// your code here
		return -1;
	}

	public E remove(int index) {
		// your code here
		return null;
	}

	public boolean remove(Object obj) {
		// your code here
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// your code here
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// your code here
		return false;
	}

	public E set(int index, E element) {
		// your code here
		return null;
	}

	public int size() {
		// your code here
		return -1;
	}

	public Object[] toArray() {
		// your code here
		return null;
	}

}