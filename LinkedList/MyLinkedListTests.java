
import java.util.Iterator;

public class MyLinkedListTests {

	private static void test(String name, Object result, Object answer) {
		if(answer.equals(result)) {
			System.out.println(name + ":  Passed");
		}
		else {
			System.out.print(name + ":  FAILED");
			System.out.println("  expected " + answer.toString() + ", got " + result.toString());
		}
	}

	public static void main(String[] args) {

		MyLinkedList<Integer> iList1 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> iList2 = new MyLinkedList<Integer>();

		// MyIterator hasNext()
		Iterator<Integer> iter1 = iList1.iterator();
		Iterator<Integer> iter2 = iList1.iterator();
		test("iterator() 0", iter1 == iter2, false);
		test("hasNext() 0", iter1.hasNext(), false);

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
	}

}