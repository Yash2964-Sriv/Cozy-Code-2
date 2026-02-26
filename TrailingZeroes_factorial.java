/**
 * Basic DSA Problems - Trailing Zeros in Factorial
 * Simple and essential DSA problems for beginners
 */
public class TrailingZeroes_factorial {

    // Problem: Count trailing zeros in n!
    // Trailing zeros = count of (2*5) pairs in prime factorization of n!
    // Since 2s are more than 5s, count = number of 5s = n/5 + n/25 + n/125 + ...
    // Example: 10! = 3628800 -> 2 trailing zeros; 25! -> 6 trailing zeros

    /**
     * Count trailing zeros in n! using 5-count formula
     * Time Complexity: O(log n base 5)
     * Space Complexity: O(1)
     */
    public static int countTrailingZerosInFactorial(int n) {
        if (n < 0) return 0;
        int count = 0;
        for (long p = 5; p <= n; p *= 5) {
            count += n / p;
        }
        return count;
    }

    /**
     * Compute factorial (for small n, to verify)
     * Note: overflows for n > 20
     */
    public static long factorial(int n) {
        if (n < 0) return 0;
        long f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    /**
     * Count trailing zeros in a given number (by converting to string or division)
     */
    public static int countTrailingZeros(long num) {
        if (num == 0) return 0;
        int count = 0;
        while (num % 10 == 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Count Trailing Zeros in Factorial");
        System.out.println("=".repeat(60));

        // Test 1: 10! = 3628800
        int n1 = 10;
        int z1 = countTrailingZerosInFactorial(n1);
        long f1 = factorial(n1);
        System.out.println("n = " + n1 + ", n! = " + f1);
        System.out.println("Trailing zeros: " + z1);

        // Test 2: 5! = 120
        int n2 = 5;
        int z2 = countTrailingZerosInFactorial(n2);
        System.out.println("\nn = " + n2 + ", 5! = 120. Trailing zeros: " + z2);

        // Test 3: 25!
        int n3 = 25;
        int z3 = countTrailingZerosInFactorial(n3);
        System.out.println("\nn = " + n3 + ". Trailing zeros in 25!: " + z3);

        // Test 4: 0
        int n4 = 0;
        int z4 = countTrailingZerosInFactorial(n4);
        System.out.println("\nn = " + n4 + ". Trailing zeros: " + z4);

        // Test 5: 100
        int n5 = 100;
        int z5 = countTrailingZerosInFactorial(n5);
        System.out.println("\nn = " + n5 + ". Trailing zeros in 100!: " + z5);

        // Test 6: Verify with small factorial
        int n6 = 14;
        long f6 = factorial(n6);
        int actualZeros = countTrailingZeros(f6);
        int formulaZeros = countTrailingZerosInFactorial(n6);
        System.out.println("\nn = " + n6 + ", 14! has " + actualZeros + " zeros. Formula: " + formulaZeros);
    }
}