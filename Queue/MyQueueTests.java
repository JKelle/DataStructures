
import java.util.concurrent.ConcurrentLinkedDeque;


public class MyQueueTests {

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
		MyQueue<String> queue = new MyQueue<String>();
		test("isEmpty() 0", queue.isEmpty(), true);

		String s = "hi";
		queue.add(s);
		test("isEmpty() 1", queue.isEmpty(), false);

		String result = queue.peek();
		test("peek() 0", result, s);
		test("peek() 1", result == s, true);
		test("peek() 2", queue.isEmpty(), false);

		result = queue.remove();
		test("remove() 0", result, s);
		test("remove() 1", result == s, true);
		test("remove() 2", queue.isEmpty(), true);

		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.add("d");
		test("isEmpty() 2", queue.isEmpty(), false);

		test("peek() 3", queue.peek(), "a");
		test("remove() 3", queue.remove(), "a");
		test("remove() 4", queue.remove(), "b");
		test("remove() 5", queue.remove(), "c");
		test("isEmpty() 3", queue.isEmpty(), false);
		test("remove() 6", queue.remove(), "d");
		test("isEmpty() 4", queue.isEmpty(), true);

		result = "no exception thrown";
		try {
			queue.remove();
		} catch(Exception e) {
			result = e.getClass().getName();
		}
		test("remove() 7", result, "java.util.NoSuchElementException");

		result = "no exception thrown";
		try {
			queue.peek();
		} catch(Exception e) {
			result = e.getClass().getName();
		}
		test("peek() 4", result, "java.util.NoSuchElementException");


		System.out.println("Running the big test... (might take a few seconds)");
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		ConcurrentLinkedDeque<Integer> javaQueue = new ConcurrentLinkedDeque<Integer>();
		for(int i = 0; i < 5000000; ++i) {
			int rand = (int)(Math.random() * 1000) - 500;
			javaQueue.add(rand);
			myQueue.add(rand);
		}

		boolean passedBigTest = true;
		while(!javaQueue.isEmpty() && passedBigTest) {
			if(!(javaQueue.peek().equals(myQueue.peek())) ||
			   !(javaQueue.remove().equals(myQueue.remove())) ||
			   !(javaQueue.isEmpty() == myQueue.isEmpty())) {

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