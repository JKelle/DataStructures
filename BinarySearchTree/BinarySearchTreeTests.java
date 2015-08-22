
import java.util.Arrays;
import java.util.ArrayList;

public class BinarySearchTreeTests {

	private static int numFailed = 0;
	private static int numPassed = 0;

	private static void printPassed(String name) {
		System.out.println(name + ":  Passed");
	}

	private static void printFailed(String name, Object result, Object answer) {
		System.out.print(name + ":  FAILED");
		System.out.println("  expected " + answer + ", got " + result);
	}

	private static void test(String name, Object result, Object answer) {
		boolean passed = false;
		try {
			passed = answer.equals(result);
		} catch(Exception e) {}

		if(passed) {
			printPassed(name);
			++numPassed;
		}
		else {
			printFailed(name, result, answer);
			++numFailed;
		}
	}

	private static void printStats() {
		System.out.println();
		System.out.println("---------------------");
		int total = numPassed + numFailed;
		System.out.println("Passed " + numPassed + " of " + total + " tests.");

		if(numPassed == total) {
			System.out.println("All tests passing! :)");
		}
		else {
			System.out.println("Failed " + numFailed + " tests.");
		}
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		System.out.println();

		test("case 0 - size()", bst.size(), 0);
		test("case 0 - contains(5)", bst.contains(5), false);
		test("case 0 - contains(9)", bst.contains(9), false);
		test("case 0 - contains(4)", bst.contains(4), false);
		test("case 0 - inOrderIterative()", bst.inOrderIterative(), new ArrayList<Integer>());
		test("case 0 - inOrderRecursive()", bst.inOrderRecursive(), new ArrayList<Integer>());
		test("case 0 - postOrderIterative()", bst.postOrderIterative(), new ArrayList<Integer>());
		test("case 0 - postOrderRecursive()", bst.postOrderRecursive(), new ArrayList<Integer>());
		test("case 0 - preOrderIterative()", bst.preOrderIterative(), new ArrayList<Integer>());
		test("case 0 - preOrderRecursive()", bst.preOrderRecursive(), new ArrayList<Integer>());


		System.out.println();

		// 5

		bst.add(5);
		test("case 1 - size()", bst.size(), 1);
		test("case 1 - contains(5)", bst.contains(5), true);
		test("case 1 - contains(9)", bst.contains(9), false);
		test("case 1 - contains(4)", bst.contains(4), false);
		test("case 1 - inOrderIterative()", bst.inOrderIterative(), Arrays.asList(new int[]{5}));
		test("case 1 - inOrderRecursive()", bst.inOrderRecursive(), Arrays.asList(new int[]{5}));
		test("case 1 - postOrderIterative()", bst.postOrderIterative(), Arrays.asList(new int[]{5}));
		test("case 1 - postOrderRecursive()", bst.postOrderRecursive(), Arrays.asList(new int[]{5}));
		test("case 1 - preOrderIterative()", bst.preOrderIterative(), Arrays.asList(new int[]{5}));
		test("case 1 - preOrderRecursive()", bst.preOrderRecursive(), Arrays.asList(new int[]{5}));

		System.out.println();

		//      5
		//    1

		bst.add(1);
		test("case 2 - size()", bst.size(), 2);
		test("case 2 - contains(5)", bst.contains(5), true);
		test("case 2 - contains(9)", bst.contains(9), false);
		test("case 2 - contains(4)", bst.contains(4), false);
		test("case 2 - inOrderIterative()", bst.inOrderIterative(), Arrays.asList(new int[]{1, 5}));
		test("case 2 - inOrderRecursive()", bst.inOrderRecursive(), Arrays.asList(new int[]{1, 5}));
		test("case 2 - postOrderIterative()", bst.postOrderIterative(), Arrays.asList(new int[]{1, 5}));
		test("case 2 - postOrderRecursive()", bst.postOrderRecursive(), Arrays.asList(new int[]{1, 5}));
		test("case 2 - preOrderIterative()", bst.preOrderIterative(), Arrays.asList(new int[]{5, 1}));
		test("case 2 - preOrderRecursive()", bst.preOrderRecursive(), Arrays.asList(new int[]{5, 1}));

		System.out.println();

		//      5
		//    1   9

		bst.add(9);
		test("case 3 - size()", bst.size(), 3);
		test("case 3 - contains(5)", bst.contains(5), true);
		test("case 3 - contains(9)", bst.contains(9), true);
		test("case 3 - contains(4)", bst.contains(4), false);
		test("case 3 - inOrderIterative()", bst.inOrderIterative(), Arrays.asList(new int[]{1, 5, 9}));
		test("case 3 - inOrderRecursive()", bst.inOrderRecursive(), Arrays.asList(new int[]{1, 5, 9}));
		test("case 3 - postOrderIterative()", bst.postOrderIterative(), Arrays.asList(new int[]{1, 9, 5}));
		test("case 3 - postOrderRecursive()", bst.postOrderRecursive(), Arrays.asList(new int[]{1, 9, 5}));
		test("case 3 - preOrderIterative()", bst.preOrderIterative(), Arrays.asList(new int[]{5, 1, 9}));
		test("case 3 - preOrderRecursive()", bst.preOrderRecursive(), Arrays.asList(new int[]{5, 1, 9}));

		System.out.println();

		//      5
		//   1     9
		//     3

		bst.add(3);
		test("case 4 - size()", bst.size(), 4);
		test("case 4 - contains(5)", bst.contains(5), true);
		test("case 4 - contains(9)", bst.contains(9), true);
		test("case 4 - contains(4)", bst.contains(4), false);
		test("case 4 - inOrderIterative()", bst.inOrderIterative(), Arrays.asList(new int[]{1, 3, 5, 9}));
		test("case 4 - inOrderRecursive()", bst.inOrderRecursive(), Arrays.asList(new int[]{1, 3, 5, 9}));
		test("case 4 - postOrderIterative()", bst.postOrderIterative(), Arrays.asList(new int[]{3, 1, 9, 5}));
		test("case 4 - postOrderRecursive()", bst.postOrderRecursive(), Arrays.asList(new int[]{3, 1, 9, 5}));
		test("case 4 - preOrderIterative()", bst.preOrderIterative(), Arrays.asList(new int[]{5, 1, 3, 9}));
		test("case 4 - preOrderRecursive()", bst.preOrderRecursive(), Arrays.asList(new int[]{5, 1, 3, 9}));

		System.out.println();

		//       5
		//   1       9
		//     3   7

		bst.add(7);
		test("case 5 - size()", bst.size(), 5);
		test("case 5 - contains(5)", bst.contains(5), true);
		test("case 5 - contains(9)", bst.contains(9), true);
		test("case 5 - contains(4)", bst.contains(4), false);
		test("case 5 - inOrderIterative()", bst.inOrderIterative(), Arrays.asList(new int[]{1, 3, 5, 7, 9}));
		test("case 5 - inOrderRecursive()", bst.inOrderRecursive(), Arrays.asList(new int[]{1, 3, 5, 7, 9}));
		test("case 5 - postOrderIterative()", bst.postOrderIterative(), Arrays.asList(new int[]{3, 1, 7, 9, 5}));
		test("case 5 - postOrderRecursive()", bst.postOrderRecursive(), Arrays.asList(new int[]{3, 1, 7, 9, 5}));
		test("case 5 - preOrderIterative()", bst.preOrderIterative(), Arrays.asList(new int[]{5, 1, 3, 9, 7}));
		test("case 5 - preOrderRecursive()", bst.preOrderRecursive(), Arrays.asList(new int[]{5, 1, 3, 9, 7}));

		System.out.println();

		//       5
		//   1       9
		// 0   3   7

		bst.add(0);
		test("case 6 - size()", bst.size(), 6);
		test("case 6 - contains(5)", bst.contains(5), true);
		test("case 6 - contains(9)", bst.contains(9), true);
		test("case 6 - contains(4)", bst.contains(4), false);
		test("case 6 - inOrderIterative()", bst.inOrderIterative(), Arrays.asList(new int[]{0, 1, 3, 5, 7, 9}));
		test("case 6 - inOrderRecursive()", bst.inOrderRecursive(), Arrays.asList(new int[]{0, 1, 3, 5, 7, 9}));
		test("case 6 - postOrderIterative()", bst.postOrderIterative(), Arrays.asList(new int[]{0, 3, 1, 7, 9, 5}));
		test("case 6 - postOrderRecursive()", bst.postOrderRecursive(), Arrays.asList(new int[]{0, 3, 1, 7, 9, 5}));
		test("case 6 - preOrderIterative()", bst.preOrderIterative(), Arrays.asList(new int[]{5, 1, 0, 3, 9, 7}));
		test("case 6 - preOrderRecursive()", bst.preOrderRecursive(), Arrays.asList(new int[]{5, 1, 0, 3, 9, 7}));

		System.out.println();

		//       5
		//   1       9
		// 0   3   7   10

		bst.add(10);
		test("case 7 - size()", bst.size(), 7);
		test("case 7 - contains(5)", bst.contains(5), true);
		test("case 7 - contains(9)", bst.contains(9), true);
		test("case 7 - contains(4)", bst.contains(4), false);
		test("case 7 - inOrderIterative()", bst.inOrderIterative(), Arrays.asList(new int[]{0, 1, 3, 5, 7, 9, 10}));
		test("case 7 - inOrderRecursive()", bst.inOrderRecursive(), Arrays.asList(new int[]{0, 1, 3, 5, 7, 9, 10}));
		test("case 7 - postOrderIterative()", bst.postOrderIterative(), Arrays.asList(new int[]{0, 3, 1, 7, 10, 9, 5}));
		test("case 7 - postOrderRecursive()", bst.postOrderRecursive(), Arrays.asList(new int[]{0, 3, 1, 7, 10, 9, 5}));
		test("case 7 - preOrderIterative()", bst.preOrderIterative(), Arrays.asList(new int[]{5, 1, 0, 3, 9, 7, 10}));
		test("case 7 - preOrderRecursive()", bst.preOrderRecursive(), Arrays.asList(new int[]{5, 1, 0, 3, 9, 7, 10}));


		printStats();
	}
}

























