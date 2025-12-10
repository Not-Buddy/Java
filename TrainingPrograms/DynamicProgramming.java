public class DynamicProgramming {

    private static int[] fib;

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (fib[n] != -1) {
            return fib[n];
        }

        fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return fib[n];
    }

    public static int fibonacci2(int n, int[] memo) {
    if (n <= 1) {
        return n;
    }

    if (memo[n] != -1) {
        return memo[n];
    }

    memo[n] = fibonacci2(n - 1, memo) + fibonacci2(n - 2, memo);
    return memo[n];
}

    public static void TabulationFibonacci(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println("Fibonacci of " + n + " is: " + fib[n]);
    }


    public static void main(String[] args) {
        int n = 6;
        fib = new int[n + 1];
        for (int i = 0; i <= n; i++) {  
            fib[i] = -1;
        }

        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));

        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        System.out.println("Fibonacci of " + n + " is: " + fibonacci2(n, memo));
    
        TabulationFibonacci(n);
    }
}