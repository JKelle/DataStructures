
import java.util.Stack;

public class MyStackTests {

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
		MyStack<String> stack = new MyStack<String>();
		test("isEmpty() 0", stack.isEmpty(), true);

		String s = "hi";
		test("push() 0", stack.push(s), s);
		test("isEmpty() 1", stack.isEmpty(), false);

		String result = stack.peek();
		test("peek() 0", result, s);
		test("peek() 1", result == s, true);
		test("peek() 2", stack.isEmpty(), false);

		result = stack.pop();
		test("pop() 0", result, s);
		test("pop() 1", result == s, true);
		test("pop() 2", stack.isEmpty(), true);

		test("push() 1", stack.push("a"), "a");
		test("push() 2", stack.push("b"), "b");
		test("push() 3", stack.push("c"), "c");
		test("push() 4", stack.push("d"), "d");
		test("isEmpty() 2", stack.isEmpty(), false);

		test("peek() 3", stack.peek(), "d");
		test("pop() 3", stack.pop(), "d");
		test("pop() 4", stack.pop(), "c");
		test("pop() 5", stack.pop(), "b");
		test("isEmpty() 3", stack.isEmpty(), false);
		test("pop() 6", stack.pop(), "a");

		result = "no exception thrown";
		try {
			stack.pop();
		} catch(Exception e) {
			result = e.getClass().getName();
		}
		test("pop() 7", result, "java.util.EmptyStackException");

		result = "no exception thrown";
		try {
			stack.peek();
		} catch(Exception e) {
			result = e.getClass().getName();
		}
		test("peek() 4", result, "java.util.EmptyStackException");


		System.out.println("Running the big test... (might take a few seconds)");
		boolean passedBigTest = true;
		MyStack<Integer> myStack = new MyStack<Integer>();
		Stack<Integer> javaStack = new Stack<Integer>();
		for(int i = 0; i < 5000000; ++i) {
			int rand = (int)(Math.random() * 1000) - 500;
			javaStack.push(rand);
			Integer returnedVal = myStack.push(rand);
			if(returnedVal == null || returnedVal != rand) {
				passedBigTest = false;
				break;
			}
		}

		while(!javaStack.isEmpty() && passedBigTest) {
			if(!(javaStack.peek().equals(myStack.peek())) ||
			   !(javaStack.pop().equals(myStack.pop())) ||
			   !(javaStack.isEmpty() == myStack.isEmpty())) {

				System.out.println("Failed the big test.");
				--numFailed;
				passedBigTest = false;
			}
		}
		if(passedBigTest) {
			System.out.println("Passed the big test!");
			++numPassed;
		}

		printStats();
	}
}