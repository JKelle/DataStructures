
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
			System.out.println("\texpected " + answer + ", got " + result);
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
	}
}