
public class GenericArrayListTests {

	private static String getString(Object obj) {
		if (obj == null) {
			return "null";
		}
		return obj.toString();
	}

	private static void test(String name, Object result, Object answer) {
		if (answer.equals(result)) {
			System.out.println(name + ":  Passed");
		}
		else {
			System.out.print(name + ":  FAILED");
			System.out.println("  expected " + getString(answer) + ", got " + getString(result));
		}
	}

	public static void main(String[] args) {

		// test size()
		GenericArrayList<Integer> listI = new GenericArrayList<Integer>();
		test("size 0", listI.size(), 0);

		listI.add(2);
		test("size 1", listI.size(), 1);

		listI.add(4);
		listI.add(6);
		listI.add(8);
		test("size 2", listI.size(), 4);

		listI = new GenericArrayList<Integer>(new Integer[]{1, 2, 3, 4, 5, 6});
		test("size 3", listI.size(), 6);


		System.out.println();


		// test equals(Object other)
		GenericArrayList<String> list1 = new GenericArrayList<String>();
		GenericArrayList<String> list2 = new GenericArrayList<String>();
		test("equals 0", list1.equals(list2), true);

		list1.add("hello");
		test("equals 1", list1.equals(list2), false);

		list2.add("hello");
		test("equals 2", list1.equals(list2), true);

		list1.add("world");
		list1.add("data");
		list1.add("structures!");
		test("equals 3", list1.equals(new GenericArrayList<String>(new String[]{"hello", "world", "data", "structures!"})), true);

		list1 = new GenericArrayList<String>(new String[]{"hello", "world"});
		list2 = new GenericArrayList<String>(new String[]{"world", "hello"});
		test("equals 4", list1.equals(list2), false);

		System.out.println();


		// test add(E val)
		GenericArrayList<Double> listD = new GenericArrayList<Double>();
		listD.add(10.5);
		test("add 0", listD, new GenericArrayList<Double>(new Double[]{10.5}));

		listD.add(10.6);
		test("add 1", listD, new GenericArrayList<Double>(new Double[]{10.5, 10.6}));

		listD.add(-1.2345);
		test("add 2", listD, new GenericArrayList<Double>(new Double[]{10.5, 10.6, -1.2345}));

		listD = new GenericArrayList<Double>();
		Double[] arr = new Double[1000000];
		for(int i = 0; i < 1000000; ++i) {
			listD.add(0.1 + i);
			arr[i] = 0.1 + i;
		}
		test("add 3", listD, new GenericArrayList<Double>(arr));


		System.out.println();


		// test insert(E val, int pos)
		GenericArrayList<Character> listC = new GenericArrayList<Character>();
		listC.add('d');
		listC.add('o');
		listC.add('s');
		listC.insert(2, 'g');
		test("insert 0", listC, new GenericArrayList<Character>(new Character[]{'d', 'o', 'g', 's'}));

		listC.insert(4, '!');
		test("insert 1", listC, new GenericArrayList<Character>(new Character[]{'d', 'o', 'g', 's', '!'}));

		listC.insert(0, '*');
		test("insert 2", listC, new GenericArrayList<Character>(new Character[]{'*', 'd', 'o', 'g', 's', '!'}));


		System.out.println();


		// test get(int pos)
		listI = new GenericArrayList<Integer>(new Integer[]{4, 1, 1, 3, 4, 10});
		test("get 0", listI.get(0), 4);

		test("get 1", listI.get(5), 10);

		test("get 2", listI.get(3), 3);

		for(int i = 0; i < 100; ++i) {
			listI.add(-1*i);
		}
		test("get 3", listI.get(100), -94);


		System.out.println();


		// test remove(E val)
		GenericArrayList<String> listS = new GenericArrayList<String>(new String[]{"burrito", "tacos", "nachos"});
		test("remove 0.0", listS.remove("tacos"), true);
		test("remove 0.1", listS, new GenericArrayList<String>(new String[]{"burrito", "nachos"}));
		test("remove 0.2", listS.size(), 2);

		test("remove 1.0", listS.remove("tacos"), false);
		test("remove 1.1", listS, new GenericArrayList<String>(new String[]{"burrito", "nachos"}));
		test("remove 1.2", listS.size(), 2);

		test("remove 2.0", listS.remove("nachos"), true);
		test("remove 2.1", listS, new GenericArrayList<String>(new String[]{"burrito"}));
		test("remove 2.2", listS.size(), 1);

		test("remove 3.0", listS.remove("burrito"), true);
		test("remove 3.1", listS, new GenericArrayList<String>());
		test("remove 3.2", listS.size(), 0);

		test("remove 4.0", listS.remove("nothing"), false);
		test("remove 4.1", listS, new GenericArrayList<String>());
		test("remove 4.2", listS.size(), 0);

		listI = new GenericArrayList<Integer>(new Integer[]{1, 2, 3, 2, 4});
		test("remove 5.0", listI.remove(2), true);
		test("remove 5.1", listI, new GenericArrayList<Integer>(new Integer[]{1, 3, 2, 4}));
		test("remove 5.2", listI.size(), 4);


		System.out.println();


		// test removePos(int pos)
		listI = new GenericArrayList<Integer>(new Integer[]{7});
		test("removePos 0.0", listI.removePos(0), 7);
		test("removePos 0.1", listI, new GenericArrayList<Integer>());
		test("removePos 0.2", listI.size(), 0);

		listI = new GenericArrayList<Integer>(new Integer[]{7, 8, 9, 10});
		test("removePos 1.0", listI.removePos(2), 9);
		test("removePos 1.1", listI, new GenericArrayList<Integer>(new Integer[]{7, 8, 10}));
		test("removePos 1.2", listI.size(), 3);


		System.out.println();


		// test indexOf(E val)
		listC = new GenericArrayList<Character>(new Character[]{'S', 'u', 'n', 'n', 'y'});
		test("indexOf 0", listC.indexOf('S'), 0);
		test("indexOf 1", listC.indexOf('u'), 1);
		test("indexOf 2", listC.indexOf('n'), 2);
		test("indexOf 3", listC.indexOf('y'), 4);
		test("indexOf 3", listC.indexOf('s'), -1);
		test("indexOf 4", listC.size(), 5);


		System.out.println();


		// test clear()
		listS = new GenericArrayList<String>(new String[]{"Red", "Blue", "Yellow"});
		listS.clear();
		test("clear 0", listS, new GenericArrayList<String>());
		test("clear 1", listS.size(), 0);

		listS.clear();
		test("clear 2", listS, new GenericArrayList<String>());
		test("clear 3", listS.size(), 0);

		listS.add("Gold");
		listS.add("Silver");
		listS.clear();
		test("clear 4", listS, new GenericArrayList<String>());
		test("clear 5", listS.size(), 0);

	}
}
