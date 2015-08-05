
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Arrays;

public class MyLinkedListTests {

	private static void printPassed(String name) {
		System.out.println(name + ":  Passed");
	}

	private static void printFailed(String name, Object result, Object answer) {
		System.out.print(name + ":  FAILED");
		System.out.println("  expected " + answer.toString() + ", got " + result.toString());
	}

	private static void test(String name, Object result, Object answer) {
		if(answer.equals(result)) {
			printPassed(name);
		}
		else {
			printFailed(name, result, answer);
		}
	}

	public static void main(String[] args) {

		MyLinkedList<Integer> iList1 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> iList2 = new MyLinkedList<Integer>();

		// MyIterator hasNext(), next(), remove()
		Iterator<Integer> iter1 = iList1.iterator();
		Iterator<Integer> iter2 = iList1.iterator();

		test("iterator() 0", iter1 == iter2, false);

		test("hasNext() 0", iter1.hasNext(), false);

		iList1 = new MyLinkedList<Integer>(new Integer[]{1, 2, 3, 4});
		test("hasNext() 1", iter1.hasNext(), false);

		Iterator<Integer> iter = iList1.iterator();
		test("hasNext() 2", iter.hasNext(), true);

		String name = "remove() 0";
		try {
			iter.remove();
		}
		catch(Exception e) {
			if(e instanceof IllegalStateException){
				printPassed(name);
			}
			else {
				Exception expected = new IllegalStateException();
				printFailed(name, e, expected);
			}
		}

		test("next() 0", iter.next(), 1);

		iter.remove();
		test("remove() 1", iList1, new MyLinkedList<Integer>(new Integer[]{2, 3, 4}));

		name = "remove() 2";
		try {
			iter.remove();
		}
		catch(Exception e) {
			if(e instanceof IllegalStateException){
				printPassed(name);
			}
			else {
				Exception expected = new IllegalStateException();
				printFailed(name, e, expected);
			}
		}

		test("hasNext() 3", iter.hasNext(), true);

		test("next() 1", iter.next(), 2);
		test("hasNext() 4", iter.hasNext(), true);
		test("next() 2", iter.next(), 3);
		test("hasNext() 5", iter.hasNext(), true);
		test("next() 3", iter.next(), 4);
		test("hasNext() 6", iter.hasNext(), false);

		iter.remove();
		test("remove() 3", iList1, new MyLinkedList<Integer>(new Integer[]{2, 3}));

		test("hasNext() 7", iter.hasNext(), false);

		name = "remove() 4";
		try {
			iter.remove();
		}
		catch(Exception e) {
			if(e instanceof IllegalStateException){
				printPassed(name);
			}
			else {
				Exception expected = new IllegalStateException();
				printFailed(name, e, expected);
			}
		}

		test("hasNext() 8", iter.hasNext(), false);


		System.out.println();


		// add(E element)
		iList1 = new MyLinkedList<Integer>();
		iList2 = new MyLinkedList<Integer>();
		test("add(E element) 0", iList1, iList2);

		iList1.add(8);
		test("add(E element) 1", iList1.equals(iList2), false);

		iList2.add(4);
		test("add(E element) 2", iList1.equals(iList2), false);

		test("add(E element) 3", iList2, new MyLinkedList<Integer>(new Integer[]{4}));

		iList2 = new MyLinkedList<Integer>();
		iList2.add(8);
		test("add(E element) 4", iList1, iList2);

		iList1.add(1);
		iList1.add(2);
		iList1.add(4);
		iList1.add(8);
		iList1.add(16);
		iList2 = new MyLinkedList<Integer>(new Integer[]{8, 1, 2, 4, 8, 16});
		test("add(E element) 5", iList1, iList2);

		test("add(E element) 6", iList1.size(), 6);


		System.out.println();


		// add(int index, E element)
		MyLinkedList<String> sList1 = new MyLinkedList<String>();

		sList1.add(0, "Hello");
		test("add(int index, E element) 0", sList1, new MyLinkedList<String>(new String[]{"Hello"}));

		sList1.add(1, "World");
		test("add(int index, E element) 1", sList1, new MyLinkedList<String>(new String[]{"Hello", "World"}));

		sList1.add(0, "burrito");
		test("add(int index, E element) 2", sList1, new MyLinkedList<String>(new String[]{"burrito", "Hello", "World"}));

		sList1.add(3, "java");
		test("add(int index, E element) 3", sList1, new MyLinkedList<String>(new String[]{"burrito", "Hello", "World", "java"}));

		sList1.add(2, "LinkedList");
		test("add(int index, E element) 3", sList1, new MyLinkedList<String>(new String[]{"burrito", "Hello", "LinkedList", "World", "java"}));

		test("add(int index, E element) 4", sList1.size(), 5);


		System.out.println();


		// addAll(Collection c)
		MyLinkedList<Character> cList = new MyLinkedList<Character>();
		Collection<Character> c = new ArrayList<Character>();

		c.add('a');
		c.add('p');
		c.add('p');
		c.add('l');
		c.add('e');
		boolean changed = cList.addAll(c);
		test("addAll(Collection c) 0", cList, new MyLinkedList<Character>(new Character[]{'a', 'p', 'p', 'l', 'e'}));
		test("addAll(Collection c) 1", changed, true);
		test("addAll(Collection c) 2", cList.size(), 5);

		changed = cList.addAll(new ArrayList<Character>());
		test("addAll(Collection c) 3", cList, new MyLinkedList<Character>(new Character[]{'a', 'p', 'p', 'l', 'e'}));
		test("addAll(Collection c) 4", changed, false);
		test("addAll(Collection c) 5", cList.size(), 5);

		c.clear();
		c.add('b');
		c.add('a');
		c.add('n');
		c.add('a');
		c.add('n');
		c.add('a');
		changed = cList.addAll(c);
		test("addAll(Collection c) 6", cList, new MyLinkedList<Character>(new Character[]{'a', 'p', 'p', 'l', 'e', 'b', 'a', 'n', 'a', 'n', 'a'}));
		test("addAll(Collection c) 7", changed, true);
		test("addAll(Collection c) 8", cList.size(), 11);


		System.out.println();


		// clear()
		cList.clear();
		test("clear() 0", cList.size(), 0);
		test("clear() 1", cList, new MyLinkedList<Character>());

		cList.clear();
		test("clear() 2", cList.size(), 0);
		test("clear() 3", cList, new MyLinkedList<Character>());

		cList.add('q');
		c.clear();
		c.add('w');
		c.add('r');
		c.add('t');
		c.add('y');
		cList.addAll(c);
		cList.add(2, 'e');
		test("clear() 4", cList, new MyLinkedList<Character>(new Character[]{'q', 'w', 'e', 'r', 't', 'y'}));
		test("clear() 5", cList.size(), 6);

		cList.clear();
		test("clear() 6", cList.size(), 0);
		test("clear() 7", cList, new MyLinkedList<Character>());

		cList.clear();
		cList.clear();
		cList.clear();
		cList.clear();
		cList.clear();
		test("clear() 8", cList.size(), 0);
		test("clear() 9", cList, new MyLinkedList<Character>());


		System.out.println();


		// contains(Object obj)
		MyLinkedList<Integer> iList = new MyLinkedList<Integer>(new Integer[]{0, 1, 2, 3, 5, 6, 8, 9});
		test("contains(Object obj) 0", iList.contains(0), true);
		test("contains(Object obj) 1", iList.contains(1), true);
		test("contains(Object obj) 2", iList.contains(3), true);
		test("contains(Object obj) 3", iList.contains(4), false);
		test("contains(Object obj) 4", iList.contains(5), true);
		test("contains(Object obj) 5", iList.contains(8), true);
		test("contains(Object obj) 6", iList.contains(9), true);
		test("contains(Object obj) 7", iList.contains(-1), false);
		test("contains(Object obj) 8", iList.contains(10), false);

		iList.clear();
		test("contains(Object obj) 9", iList.contains(0), false);
		test("contains(Object obj) 10", iList.contains(9), false);

		sList1 = new MyLinkedList<String>();
		test("contains(Object obj) 11", sList1.contains(""), false);

		sList1.add("");
		sList1.add("burrito");
		test("contains(Object obj) 12", sList1.contains(""), true);
		test("contains(Object obj) 13", sList1.contains("burrito"), true);
		test("contains(Object obj) 14", sList1.contains("Burrito"), false);


		System.out.println();


		// containsAll(Collection c)
		cList = new MyLinkedList<Character>();
		c = new ArrayList<Character>();
		test("containsAll(Collection c) 0", cList.containsAll(c), true);

		c.add('a');
		test("containsAll(Collection c) 1", cList.containsAll(c), false);

		cList.add('b');
		cList.add('u');
		cList.add('r');
		cList.add('r');
		cList.add('i');
		cList.add('t');
		cList.add('o');
		test("containsAll(Collection c) 2", cList.containsAll(c), false);

		c.add('b');
		c.add('u');
		c.add('r');
		c.add('r');
		c.add('i');
		c.add('t');
		c.add('o');
		test("containsAll(Collection c) 3", cList.containsAll(c), false);

		cList.add('a');
		test("containsAll(Collection c) 4", cList.containsAll(c), true);

		c.clear();
		test("containsAll(Collection c) 5", cList.containsAll(c), true);

		c.add('t');
		test("containsAll(Collection c) 6", cList.containsAll(c), true);

		c.add('r');
		c.add('b');
		c.add('o');
		test("containsAll(Collection c) 6", cList.containsAll(c), true);

		c.add('x');
		c.add('b');
		c.add('u');
		test("containsAll(Collection c) 7", cList.containsAll(c), false);


		System.out.println();


		// get(int index)
		sList1.clear();
		sList1.add("red");
		sList1.add("orange");
		sList1.add("yellow");
		sList1.add("green");
		sList1.add("blue");
		sList1.add("purple");
		test("get(int index) 0", sList1.get(0), "red");
		test("get(int index) 1", sList1.get(4), "blue");
		test("get(int index) 2", sList1.get(5), "purple");

		name = "get(int index) 3";
		try {
			sList1.get(-1);
		}
		catch(Exception e) {
			if(e instanceof IndexOutOfBoundsException){
				printPassed(name);
			}
			else {
				Exception expected = new IndexOutOfBoundsException();
				printFailed(name, e, expected);
			}
		}

		name = "get(int index) 4";
		try {
			sList1.get(6);
		}
		catch(Exception e) {
			if(e instanceof IndexOutOfBoundsException){
				printPassed(name);
			}
			else {
				Exception expected = new IndexOutOfBoundsException();
				printFailed(name, e, expected);
			}
		}


		System.out.println();


		// indexOf(Object obj)
		test("indexOf(Object obj) 0", sList1.indexOf("red"), 0);
		test("indexOf(Object obj) 1", sList1.indexOf("orange"), 1);
		test("indexOf(Object obj) 2", sList1.indexOf("yellow"), 2);
		test("indexOf(Object obj) 3", sList1.indexOf("purple"), 5);
		test("indexOf(Object obj) 4", sList1.indexOf("brown"), -1);
		test("indexOf(Object obj) 5", sList1.indexOf(123), -1);


		System.out.println();


		// isEmpty()
		test("isEmpty() 0", sList1.isEmpty(), false);

		sList1.clear();
		test("isEmpty() 1", sList1.isEmpty(), true);

		sList1.add("Hello");
		test("isEmpty() 2", sList1.isEmpty(), false);

		test("isEmpty() 3", new MyLinkedList<Double>().isEmpty(), true);


		System.out.println();


		// lastIndexOf(Object obj)
		iList.clear();
		test("lastIndexOf(Object obj) 0", iList.lastIndexOf(2), -1);

		//										 0  1  2  3  4  5  6  7  8  9  10 11
		iList.addAll(Arrays.asList(new Integer[]{1, 2, 2, 3, 2, 4, 2, 3, 4, 3, 4, 4}));
		test("lastIndexOf(Object obj) 1", iList.lastIndexOf(2), 6);
		test("lastIndexOf(Object obj) 2", iList.lastIndexOf(4), 11);
		test("lastIndexOf(Object obj) 3", iList.lastIndexOf(3), 9);
		test("lastIndexOf(Object obj) 4", iList.lastIndexOf(1), 0);
		test("lastIndexOf(Object obj) 5", iList.lastIndexOf("burrito"), -1);
		test("lastIndexOf(Object obj) 6", iList.lastIndexOf(null), -1);


		System.out.println();


		// remove(int index)
		sList1.clear();
		name = "remove(int index) 0";
		try {
			sList1.remove(0);
		}
		catch(Exception e) {
			if(e instanceof IndexOutOfBoundsException){
				printPassed(name);
			}
			else {
				Exception expected = new IndexOutOfBoundsException();
				printFailed(name, e, expected);
			}
		}

		sList1.add("red");
		test("remove(int index) 1", sList1.remove(0), "red");
		test("remove(int index) 2", sList1, new MyLinkedList<String>());

		sList1.add("red");
		sList1.add("orange");
		sList1.add("yellow");
		sList1.add("green");
		sList1.add("blue");
		sList1.add("purple");

		name = "remove(int index) 3";
		try {
			sList1.remove(6);
		}
		catch(Exception e) {
			if(e instanceof IndexOutOfBoundsException){
				printPassed(name);
			}
			else {
				Exception expected = new IndexOutOfBoundsException();
				printFailed(name, e, expected);
			}
		}

		name = "remove(int index) 4";
		try {
			sList1.remove(-1);
		}
		catch(Exception e) {
			if(e instanceof IndexOutOfBoundsException){
				printPassed(name);
			}
			else {
				Exception expected = new IndexOutOfBoundsException();
				printFailed(name, e, expected);
			}
		}

		test("remove(int index) 5", sList1.remove(3), "green");
		test("remove(int index) 6", sList1.remove(3), "blue");
		test("remove(int index) 7", sList1.remove(3), "purple");
		test("remove(int index) 8", sList1, new MyLinkedList<String>(new String[]{"red", "orange", "yellow"}));


		System.out.println();


		// remove(Object obj)
		sList1.clear();
		sList1.add("red");
		sList1.add("orange");
		sList1.add("yellow");
		sList1.add("green");
		sList1.add("blue");
		sList1.add("purple");

		test("remove(Object obj) 0", sList1.remove("red"), true);
		test("remove(Object obj) 1", sList1, new MyLinkedList<String>(new String[]{"orange", "yellow", "green", "blue", "purple"}));

		test("remove(Object obj) 2", sList1.remove("red"), false);
		test("remove(Object obj) 3", sList1, new MyLinkedList<String>(new String[]{"orange", "yellow", "green", "blue", "purple"}));

		test("remove(Object obj) 4", sList1.remove("purple"), true);
		test("remove(Object obj) 5", sList1, new MyLinkedList<String>(new String[]{"orange", "yellow", "green", "blue"}));

		test("remove(Object obj) 6", sList1.remove(new Character('x')), false);
		test("remove(Object obj) 7", sList1, new MyLinkedList<String>(new String[]{"orange", "yellow", "green", "blue"}));

		test("remove(Object obj) 8", sList1.remove(sList1), false);
		test("remove(Object obj) 9", sList1, new MyLinkedList<String>(new String[]{"orange", "yellow", "green", "blue"}));

		test("remove(Object obj) 10", sList1.remove("green"), true);
		test("remove(Object obj) 11", sList1, new MyLinkedList<String>(new String[]{"orange", "yellow", "blue"}));

		sList1.remove("yellow");
		sList1.remove("orange");
		sList1.remove("red");
		sList1.remove("green");
		sList1.remove("green");
		sList1.remove("green");
		sList1.remove("blue");
		test("remove(Object obj) 12", sList1, new MyLinkedList<String>());


		System.out.println();


		// removeAll(Collection c)
		iList.clear();
		Collection<Integer> iCol = new ArrayList<Integer>();

		test("removeAll(Collection c) 0", iList.removeAll(iCol), false);

		iCol.add(8);
		test("removeAll(Collection c) 1", iList.removeAll(iCol), false);

		iList.add(3);
		test("removeAll(Collection c) 2", iList.removeAll(iCol), false);
		test("removeAll(Collection c) 3", iList.size(), 1);

		iCol.add(3);
		test("removeAll(Collection c) 4", iList.removeAll(iCol), true);
		test("removeAll(Collection c) 5", iList, new MyLinkedList<Integer>());

		iList = new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2});
		iCol = Arrays.asList(new Integer[]{1, 2, 6});
		test("removeAll(Collection c) 6", iList.removeAll(iCol), true);
		test("removeAll(Collection c) 7", iList, new MyLinkedList<Integer>(new Integer[]{3, 5, 4}));

		iList = new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2});
		iCol = Arrays.asList(new Integer[]{1, 14, 2, 6, 8, -10});
		test("removeAll(Collection c) 8", iList.removeAll(iCol), true);
		test("removeAll(Collection c) 9", iList, new MyLinkedList<Integer>(new Integer[]{3, 5, 4}));

		iList = new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2});
		iCol = Arrays.asList(new Integer[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
		test("removeAll(Collection c) 10", iList.removeAll(iCol), true);
		test("removeAll(Collection c) 11", iList, new MyLinkedList<Integer>());


		System.out.println();


		// retainAll(Collection c)
		iList.clear();
		iCol = new ArrayList<Integer>();

		test("retainAll(Collection c) 0", iList.retainAll(iCol), false);

		iCol.add(8);
		test("retainAll(Collection c) 1", iList.retainAll(iCol), false);

		iList.add(3);
		test("retainAll(Collection c) 2", iList.retainAll(iCol), true);
		test("retainAll(Collection c) 3", iList, new MyLinkedList<Integer>());

		iList.clear();
		iList.add(3);
		iList.add(8);
		iList.add(3);
		iList.add(8);
		iList.add(3);
		test("retainAll(Collection c) 4", iList.retainAll(iCol), true);
		test("retainAll(Collection c) 5", iList, new MyLinkedList<Integer>(new Integer[]{8, 8}));

		iList = new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2});
		iCol = Arrays.asList(new Integer[]{1, 2, 6});
		test("retainAll(Collection c) 6", iList.retainAll(iCol), true);
		test("retainAll(Collection c) 7", iList, new MyLinkedList<Integer>(new Integer[]{1, 6, 6, 2}));

		iList = new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2});
		iCol = Arrays.asList(new Integer[]{3, 4, 5});
		test("retainAll(Collection c) 8", iList.retainAll(iCol), true);
		test("retainAll(Collection c) 9", iList, new MyLinkedList<Integer>(new Integer[]{3, 5, 4}));

		iList = new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2});
		iCol = Arrays.asList(new Integer[]{1, 14, 2, 6, 8, -10});
		test("retainAll(Collection c) 10", iList.retainAll(iCol), true);
		test("retainAll(Collection c) 11", iList, new MyLinkedList<Integer>(new Integer[]{1, 6, 6, 2}));

		iList = new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2});
		iCol = Arrays.asList(new Integer[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
		test("retainAll(Collection c) 12", iList.retainAll(iCol), false);
		test("retainAll(Collection c) 13", iList, new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2}));

		iList = new MyLinkedList<Integer>(new Integer[]{1, 3, 5, 6, 6, 4, 2});
		iCol = Arrays.asList(new Integer[]{-10, 0, 10, 20, 30, 40});
		test("retainAll(Collection c) 14", iList.retainAll(iCol), true);
		test("retainAll(Collection c) 15", iList, new MyLinkedList<Integer>());


		System.out.println();


		// set(int index, E element)
		cList = new MyLinkedList<Character>(new Character[]{'a', 'b', 'c', 'd', 'e'});
		test("set(int index, E element) 0", cList.set(0, 'z'), 'a');
		test("set(int index, E element) 1", cList, new MyLinkedList<Character>(new Character[]{'z', 'b', 'c', 'd', 'e'}));

		test("set(int index, E element) 2", cList.set(1, 'y'), 'b');
		test("set(int index, E element) 3", cList, new MyLinkedList<Character>(new Character[]{'z', 'y', 'c', 'd', 'e'}));

		test("set(int index, E element) 4", cList.set(4, 'v'), 'e');
		test("set(int index, E element) 5", cList, new MyLinkedList<Character>(new Character[]{'z', 'y', 'c', 'd', 'v'}));

		cList = new MyLinkedList<Character>();
		cList.add('a');
		test("set(int index, E element) 6", cList.set(0, 'a'), 'a');
		test("set(int index, E element) 7", cList, new MyLinkedList<Character>(new Character[]{'a'}));

		name = "set(int index, E element) 8";
		try {
			cList.set(1, 'a');
		}
		catch(Exception e) {
			if(e instanceof IndexOutOfBoundsException){
				printPassed(name);
			}
			else {
				Exception expected = new IndexOutOfBoundsException();
				printFailed(name, e, expected);
			}
		}

		name = "set(int index, E element) 9";
		try {
			cList.set(-1, 'a');
		}
		catch(Exception e) {
			if(e instanceof IndexOutOfBoundsException){
				printPassed(name);
			}
			else {
				Exception expected = new IndexOutOfBoundsException();
				printFailed(name, e, expected);
			}
		}


		System.out.println();


		// size()
		iList = new MyLinkedList<Integer>();
		test("size() 0", iList.size(), 0);

		iList.clear();
		test("size() 1", iList.size(), 0);

		iList.addAll(Arrays.asList(new Integer[]{5, 3, -1, -1, 0}));
		test("size() 2", iList.size(), 5);

		iList.clear();
		test("size() 3", iList.size(), 0);

		for(int i = 0; i < 1000000; ++i) {
			iList.add(i);
		}
		test("size() 4", iList.size(), 1000000);

		iList.remove(0);
		test("size() 5", iList.size(), 999999);

		iList.set(10, -1);
		test("size() 6", iList.size(), 999999);
 	}

}