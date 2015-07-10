
public class IntArrayListTests {

	private static void test(String name, int result, int answer) {
		if (result == answer) {
			System.out.println(name + ":  Passed");
		}
		else {
			System.out.print(name + ":  FAILED");
			System.out.println("  expected " + answer + ", got " + result);
		}
	}

	private static void test(String name, IntArrayList result, IntArrayList answer) {
		if (answer.equals(result)) {
			System.out.println(name + ":  Passed");
		}
		else {
			System.out.print(name + ":  FAILED");
			System.out.println("  expected " + answer.toString() + ", got " + result.toString());
		}
	}

	private static void test(String name, boolean result, boolean answer) {
		if (answer == result) {
			System.out.println(name + ":  Passed");
		}
		else {
			System.out.print(name + ":  FAILED");
			System.out.println("  expected " + answer + ", got " + result);
		}
	}

	public static void main(String[] args) {

		// test size()
		IntArrayList list = new IntArrayList();
		test("size 0", list.size(), 0);

		list.add(2);
		test("size 1", list.size(), 1);

		list.add(4);
		list.add(6);
		list.add(8);
		test("size 2", list.size(), 4);

		list = new IntArrayList(new int[]{1, 2, 3, 4, 5, 6});
		test("size 3", list.size(), 6);


		System.out.println();


		// test equals(Object other)
		IntArrayList list1 = new IntArrayList();
		IntArrayList list2 = new IntArrayList();
		test("equals 0", list1.equals(list2), true);

		list1.add(1);
		test("equals 1", list1.equals(list2), false);

		list2.add(1);
		test("equals 2", list1.equals(list2), true);

		list1.add(2);
		list1.add(3);
		list1.add(4);
		test("equals 3", list1.equals(new IntArrayList(new int[]{1, 2, 3, 4})), true);

		list1 = new IntArrayList(new int[]{1, 2});
		list2 = new IntArrayList(new int[]{2, 1});
		test("equals 4", list1.equals(list2), false);


		System.out.println();


		// test add(int val)
		list = new IntArrayList();
		list.add(10);
		test("add 0", list, new IntArrayList(new int[]{10}));

		list.add(10);
		test("add 1", list, new IntArrayList(new int[]{10, 10}));

		list.add(-1);
		test("add 2", list, new IntArrayList(new int[]{10, 10, -1}));

		list = new IntArrayList();
		int[] arr = new int[1000000];
		for(int i = 0; i < 1000000; ++i) {
			list.add(i);
			arr[i] = i;
		}
		test("add 3", list, new IntArrayList(arr));


		System.out.println();


		// test addFront(int val)
		list = new IntArrayList();
		list.addFront(10);
		test("addFront 0", list, new IntArrayList(new int[]{10}));

		list.addFront(9);
		test("addFront 1", list, new IntArrayList(new int[]{9, 10}));

		list.addFront(-1);
		test("addFront 2", list, new IntArrayList(new int[]{-1, 9, 10}));

		list = new IntArrayList();
		arr = new int[10000];
		for(int i = 0; i < 10000; ++i) {
			list.addFront(i);
			arr[10000 - i - 1] = i;
		}
		test("addFront 3", list, new IntArrayList(arr));


		System.out.println();


		// test insert(int val, int pos)
		list = new IntArrayList();
		list.add(0);
		list.add(1);
		list.add(3);
		list.insert(2, 2);
		test("insert 0", list, new IntArrayList(new int[]{0, 1, 2, 3}));

		list.insert(4, 4);
		test("insert 1", list, new IntArrayList(new int[]{0, 1, 2, 3, 4}));

		list.insert(0, -1);
		test("insert 2", list, new IntArrayList(new int[]{-1, 0, 1, 2, 3, 4}));

		list.insert(5, 99);
		test("insert 3", list, new IntArrayList(new int[]{-1, 0, 1, 2, 3, 99, 4}));


		System.out.println();


		// test set(int val, int pos)
		list = new IntArrayList(new int[]{4, 1, 1, 3, 4, 10});
		list.set(0, 0);
		test("set 0", list, new IntArrayList(new int[]{0, 1, 1, 3, 4, 10}));

		list.set(2, 2);
		test("set 1", list, new IntArrayList(new int[]{0, 1, 2, 3, 4, 10}));

		list.set(5, 100);
		test("set 1", list, new IntArrayList(new int[]{0, 1, 2, 3, 4, 100}));


		System.out.println();


		// test get(int pos)
		list = new IntArrayList(new int[]{4, 1, 1, 3, 4, 10});
		test("get 0", list.get(0), 4);

		test("get 1", list.get(5), 10);

		test("get 2", list.get(3), 3);

		for(int i = 0; i < 100; ++i) {
			list.add(-1*i);
		}
		test("get 3", list.get(100), -94);


		System.out.println();


		// test remove(int val)
		list = new IntArrayList(new int[]{1, 2, 3});
		test("remove 0.0", list.remove(1), true);
		test("remove 0.1", list, new IntArrayList(new int[]{2, 3}));
		test("remove 0.2", list.size(), 2);

		test("remove 1.0", list.remove(1), false);
		test("remove 1.1", list, new IntArrayList(new int[]{2, 3}));
		test("remove 1.2", list.size(), 2);

		test("remove 2.0", list.remove(3), true);
		test("remove 2.1", list, new IntArrayList(new int[]{2}));
		test("remove 2.2", list.size(), 1);

		list = new IntArrayList(new int[]{1, 2, 3, 2, 4});
		test("remove 3.0", list.remove(2), true);
		test("remove 3.1", list, new IntArrayList(new int[]{1, 2, 3, 4}));
		test("remove 3.2", list.size(), 4);


		System.out.println();


		// test removeAll(int val)
		list = new IntArrayList(new int[]{1, 2, 3});
		test("removeAll 0.0", list.removeAll(3), true);
		test("removeAll 0.1", list, new IntArrayList(new int[]{1, 2}));
		test("removeAll 0.2", list.size(), 2);

		list = new IntArrayList(new int[]{1, 2, 2, 3});
		test("removeAll 1.0", list.removeAll(2), true);
		test("removeAll 1.1", list, new IntArrayList(new int[]{1, 3}));
		test("removeAll 1.2", list.size(), 2);


		System.out.println();


		// test removePos(int pos)
		list = new IntArrayList(new int[]{7});
		test("removePos 0.0", list.removePos(0), 7);
		test("removePos 0.1", list, new IntArrayList());
		test("removePos 0.2", list.size(), 0);

		list = new IntArrayList(new int[]{7, 8, 9, 10});
		test("removePos 1.0", list.removePos(2), 9);
		test("removePos 1.1", list, new IntArrayList(new int[]{7, 8, 10}));
		test("removePos 1.2", list.size(), 4);


		System.out.println();


		// test removeFront()
		list = new IntArrayList(new int[]{7});
		test("removeFront 0.0", list.removeFront(), 7);
		test("removeFront 0.1", list, new IntArrayList());
		test("removeFront 0.2", list.size(), 0);

		list = new IntArrayList(new int[]{7, 8, 9, 10});
		test("removeFront 1.0", list.removeFront(), 7);
		test("removeFront 1.1", list, new IntArrayList(new int[]{8, 9, 10}));
		test("removeFront 1.2", list.size(), 4);


		System.out.println();


		// test removeBack()
		list = new IntArrayList(new int[]{7});
		test("removeBack 0.0", list.removeBack(), 7);
		test("removeBack 0.1", list, new IntArrayList());
		test("removeBack 0.2", list.size(), 0);

		list = new IntArrayList(new int[]{7, 8, 9, 10});
		test("removeBack 1.0", list.removeBack(), 10);
		test("removeBack 1.1", list, new IntArrayList(new int[]{7, 8, 9}));
		test("removeBack 1.2", list.size(), 4);


		System.out.println();


		// test removeRange(int start, int end)
		list = new IntArrayList(new int[]{0, 1, 2, 3, 4});
		list.removeRange(0, 2);
		test("removeRange 0.0", list, new IntArrayList(new int[]{2, 3, 4}));
		test("removeRange 0.1", list.size(), 3);

		list.removeRange(0, 2);
		test("removeRange 1.0", list, new IntArrayList(new int[]{4}));
		test("removeRange 1.1", list.size(), 1);

		list.removeRange(0, 1);
		test("removeRange 2.0", list, new IntArrayList());
		test("removeRange 2.1", list.size(), 0);

		list = new IntArrayList(new int[]{0, 1, 2, 3, 4, 8, 8, 1, 2, 9});
		list.removeRange(4, 8);
		test("removeRange 3.0", list, new IntArrayList(new int[]{0, 1, 2, 3, 2, 9}));
		test("removeRange 3.1", list.size(), 6);


		System.out.println();


		// test indexOf(int val)
		list = new IntArrayList(new int[]{2, 5, 4, 4, 4, 5});
		test("indexOf 0", list.indexOf(2), 0);
		test("indexOf 1", list.indexOf(5), 1);
		test("indexOf 2", list.indexOf(4), 2);
		test("indexOf 3", list.indexOf(1), -1);
		test("indexOf 4", list.size(), 6);


		System.out.println();


		// test indexOf(int val, int pos)
		list = new IntArrayList(new int[]{2, 5, 4, 4, 4, 5});
		test("indexOf 0", list.indexOf(2, 0), 0);
		test("indexOf 1", list.indexOf(2, 1), -1);
		test("indexOf 2", list.indexOf(2, 4), -1);

		test("indexOf 3", list.indexOf(5, 0), 1);
		test("indexOf 4", list.indexOf(5, 1), 1);
		test("indexOf 5", list.indexOf(5, 2), 5);

		test("indexOf 3", list.indexOf(4, 0), 2);
		test("indexOf 4", list.indexOf(4, 1), 2);
		test("indexOf 5", list.indexOf(4, 2), 2);
		test("indexOf 6", list.indexOf(4, 3), 3);
		test("indexOf 7", list.indexOf(4, 4), 4);
		test("indexOf 8", list.indexOf(4, 5), -1);

		test("indexOf 9", list.indexOf(1), -1);
		test("indexOf 10", list.size(), 6);


		System.out.println();


		// test clear()
		list = new IntArrayList(new int[]{2, 5, 4, 4, 4, 5});
		list.clear();
		test("clear 0", list, new IntArrayList());
		test("clear 1", list.size(), 0);

		list.clear();
		test("clear 2", list, new IntArrayList());
		test("clear 3", list.size(), 0);

		list.add(1);
		list.add(1000000);
		list.clear();
		test("clear 4", list, new IntArrayList());
		test("clear 5", list.size(), 0);


		System.out.println();


		// test getSubList(int start, int end)
		list = new IntArrayList(new int[]{2, 5, 4, 4, 4, 5});
		IntArrayList subList = list.getSubList(2, 5);
		test("getSubList 0", subList.size(), 3);
		test("getSubList 1", subList, new IntArrayList(new int[]{4, 4, 4}));
		test("getSubList 2", list.size(), 6);
		test("getSubList 3", list, new IntArrayList(new int[]{2, 5, 4, 4, 4, 5}));

		arr = new int[1000];
		for(int i = 0; i < 1000; ++i) {
			arr[i] = (int)(Math.random() * 100);
		}
		int[] subArr = new int[250];
		for(int i = 0; i < 250; ++i) {
			subArr[i] = arr[500 + i];
		}

		list = new IntArrayList(arr);
		subList = list.getSubList(500, 750);
		test("getSubList 4", subList.size(), 250);
		test("getSubList 5", subList, new IntArrayList(subArr));
		test("getSubList 6", list.size(), 1000);
		test("getSubList 7", list, new IntArrayList(arr));

	}
}
