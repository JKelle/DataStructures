
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


		printStats();
	}
}