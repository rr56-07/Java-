package runtimeAnalysis;

public class FibonacciComparison {

    public static void main(String[] args) {
        int n = 30;  // Adjust the value of n for comparison

        // Measuring recursive Fibonacci time
        long recursiveStartTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        long recursiveEndTime = System.nanoTime();
        long recursiveTime = recursiveEndTime - recursiveStartTime;

        // Measuring iterative Fibonacci time
        long iterativeStartTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        long iterativeEndTime = System.nanoTime();
        long iterativeTime = iterativeEndTime - iterativeStartTime;

        // Output the results
        System.out.println("Recursive Result: " + recursiveResult);
        System.out.println("Recursive Time: " + recursiveTime / 1000000.0 + " ms");

        System.out.println("Iterative Result: " + iterativeResult);
        System.out.println("Iterative Time: " + iterativeTime / 1000000.0 + " ms");
    }

    // Recursive Fibonacci (O(2^n))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        if (n == 0) return a;
        if (n == 1) return b;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
