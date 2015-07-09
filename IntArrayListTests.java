
public class IntArrayListTests {

	private static void test(String name, int result, int answer) {
		if (result == answer) {
			System.out.println(name + ": Passed");
		}
		else {
			System.out.print(name + ": FAILED");
			System.out.println("\texpected " + answer + ", got " + result);
		}
	}

	private static void test(String name, IntArrayList result, IntArrayList answer) {
		if (answer.equals(result)) {
			System.out.println(name + ": Passed");
		}
		else {
			System.out.print(name + ": FAILED");
			System.out.println("\texpected " + answer.toString() + ", got " + result.toString());
		}
	}

	private static void test(String name, boolean result, boolean answer) {
		if (answer == result) {
			System.out.println(name + ": Passed");
		}
		else {
			System.out.print(name + ": FAILED");
			System.out.println("\texpected " + answer + ", got " + result);
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


		// test set(int val, int pos)
		list = new IntArrayList(new int[]{4, 1, 1, 3, 4, 10});
		list.set(0, 0);
		test("set 0", list, new IntArrayList(new int[]{0, 1, 1, 3, 4, 10}));

		list.set(2, 2);
		test("set 1", list, new IntArrayList(new int[]{0, 1, 2, 3, 4, 10}));

		list.set(5, 100);
		test("set 1", list, new IntArrayList(new int[]{0, 1, 2, 3, 4, 100}));


		// test get(int pos)
		list = new IntArrayList(new int[]{4, 1, 1, 3, 4, 10});
		test("get 0", list.get(0), 4);

		test("get 1", list.get(5), 10);

		test("get 2", list.get(3), 3);

		for(int i = 0; i < 100; ++i) {
			list.add(-1*i);
		}
		test("get 3", list.get(100), -94);

	}
}
