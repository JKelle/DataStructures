
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

		test("case 0 - isValid()", bst.isValid(), true);
		test("case 0 - size()", bst.size(), 0);
		test("case 0 - contains(5)", bst.contains(5), false);
		test("case 0 - contains(9)", bst.contains(9), false);
		test("case 0 - contains(4)", bst.contains(4), false);

		System.out.println();

		// 5

		bst.add(5);
		test("case 1 - isValid()", bst.isValid(), true);
		test("case 1 - size()", bst.size(), 1);
		test("case 1 - contains(5)", bst.contains(5), true);
		test("case 1 - contains(9)", bst.contains(9), false);
		test("case 1 - contains(4)", bst.contains(4), false);

		System.out.println();

		//      5
		//    1

		bst.add(1);
		test("case 2 - isValid()", bst.isValid(), true);
		test("case 2 - size()", bst.size(), 2);
		test("case 2 - contains(5)", bst.contains(5), true);
		test("case 2 - contains(9)", bst.contains(9), false);
		test("case 2 - contains(4)", bst.contains(4), false);

		System.out.println();

		//      5
		//    1   9

		bst.add(9);
		test("case 3 - isValid()", bst.isValid(), true);
		test("case 3 - size()", bst.size(), 3);
		test("case 3 - contains(5)", bst.contains(5), true);
		test("case 3 - contains(9)", bst.contains(9), true);
		test("case 3 - contains(4)", bst.contains(4), false);

		System.out.println();

		//      5
		//   1     9
		//     3

		bst.add(3);
		test("case 4 - isValid()", bst.isValid(), true);
		test("case 4 - size()", bst.size(), 4);
		test("case 4 - contains(5)", bst.contains(5), true);
		test("case 4 - contains(9)", bst.contains(9), true);
		test("case 4 - contains(4)", bst.contains(4), false);

		System.out.println();

		//       5
		//   1       9
		//     3   7

		bst.add(7);
		test("case 5 - isValid()", bst.isValid(), true);
		test("case 5 - size()", bst.size(), 5);
		test("case 5 - contains(5)", bst.contains(5), true);
		test("case 5 - contains(9)", bst.contains(9), true);
		test("case 5 - contains(4)", bst.contains(4), false);

		System.out.println();

		//       5
		//   1       9
		// 0   3   7

		bst.add(0);
		test("case 6 - isValid()", bst.isValid(), true);
		test("case 6 - size()", bst.size(), 6);
		test("case 6 - contains(5)", bst.contains(5), true);
		test("case 6 - contains(9)", bst.contains(9), true);
		test("case 6 - contains(4)", bst.contains(4), false);

		System.out.println();

		//       5
		//   1       9
		// 0   3   7   10

		bst.add(10);
		test("case 7 - isValid()", bst.isValid(), true);
		test("case 7 - size()", bst.size(), 7);
		test("case 7 - contains(5)", bst.contains(5), true);
		test("case 7 - contains(9)", bst.contains(9), true);
		test("case 7 - contains(4)", bst.contains(4), false);

		System.out.println();

		//       5
		//   1       9
		// 0   3   7

		boolean result = bst.remove(10);
		test("case 8 - remove(10)", result, true);
		test("case 8 - isValid()", bst.isValid(), true);
		test("case 8 - size()", bst.size(), 6);
		test("case 8 - contains(5)", bst.contains(5), true);
		test("case 8 - contains(9)", bst.contains(9), true);
		test("case 8 - contains(4)", bst.contains(4), false);

		System.out.println();

		//       5
		//   1       7
		// 0   3

		result = bst.remove(9);
		test("case 9 - remove(9)", result, true);
		test("case 9 - isValid()", bst.isValid(), true);
		test("case 9 - size()", bst.size(), 5);
		test("case 9 - contains(5)", bst.contains(5), true);
		test("case 9 - contains(9)", bst.contains(9), false);
		test("case 9 - contains(4)", bst.contains(4), false);

		System.out.println();

		//       5						       5
		//   0       7			or		   3       7
		//     3						 0

		result = bst.remove(1);
		test("case 10 - remove(1)", result, true);
		test("case 10 - isValid()", bst.isValid(), true);
		test("case 10 - size()", bst.size(), 4);
		test("case 10 - contains(5)", bst.contains(5), true);
		test("case 10 - contains(9)", bst.contains(9), false);
		test("case 10 - contains(4)", bst.contains(4), false);

		System.out.println();

		//       3						       7
		//   0       7			or		   3
		//								 0

		result = bst.remove(5);
		test("case 11 - remove(5)", result, true);
		test("case 11 - isValid()", bst.isValid(), true);
		test("case 11 - size()", bst.size(), 3);
		test("case 11 - contains(5)", bst.contains(5), false);
		test("case 11 - contains(9)", bst.contains(9), false);
		test("case 11 - contains(4)", bst.contains(4), false);

		System.out.println();

		//       3						       7
		//   0       7			or		   3
		//								 1

		result = bst.remove(5);
		test("case 12 - remove(5)", result, false);
		test("case 12 - isValid()", bst.isValid(), true);
		test("case 12 - size()", bst.size(), 3);
		test("case 12 - contains(5)", bst.contains(5), false);
		test("case 12 - contains(9)", bst.contains(9), false);
		test("case 12 - contains(4)", bst.contains(4), false);

		printStats();
	}
}
