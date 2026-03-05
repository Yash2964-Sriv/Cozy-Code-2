/**
 * Basic DSA Problems - Power of Four
 * Simple and essential DSA problems for beginners
 */
public class PowerOfFour {

    // Problem: Check if a Number is Power of Four
    // A number is power of 4 if it can be written as 4^k for some non-negative integer k.
    // Examples: 1, 4, 16, 64, 256... (4^0, 4^1, 4^2, 4^3...)
    // Note: Power of 4 must be power of 2 AND the set bit must be at even position
    // (0, 2, 4, 6...) - mask 0x55555555 has bits at even positions

    /**
     * Check using bitwise - power of 4: exactly one bit set at even position
     * 0x55555555 = 01010101... (bits at positions 0,2,4,6...)
     * Time Complexity: O(1)
     */
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    /**
     * Check using loop - repeatedly divide by 4
     * Time Complexity: O(log n)
     */
    public static boolean isPowerOfFourLoop(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) n /= 4;
        return n == 1;
    }

    /**
     * Get exponent k if n = 4^k, else -1
     */
    public static int getPowerOfFourExponent(int n) {
        if (!isPowerOfFour(n)) return -1;
        int k = 0;
        while (n > 1) {
            n /= 4;
            k++;
        }
        return k;
    }

    /**
     * Get all powers of 4 in a range
     */
    public static java.util.ArrayList<Integer> getPowersOfFourInRange(int start, int end) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        for (int p = 0; ; p++) {
            long val = (long) Math.pow(4, p);
            if (val > end) break;
            if (val >= start) list.add((int) val);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Power of Four");
        System.out.println("=".repeat(60));

        // Test 1: 16
        int n1 = 16;
        boolean r1 = isPowerOfFour(n1);
        int exp1 = getPowerOfFourExponent(n1);
        System.out.println("Number: " + n1 + " = 4^" + exp1 + ". Is Power of 4: " + r1);

        // Test 2: 8 (power of 2 but not 4)
        int n2 = 8;
        boolean r2 = isPowerOfFour(n2);
        System.out.println("\nNumber: " + n2 + " (power of 2 only). Is Power of 4: " + r2);

        // Test 3: 64
        int n3 = 64;
        boolean r3 = isPowerOfFour(n3);
        System.out.println("\nNumber: " + n3 + ". Is Power of 4: " + r3);

        // Test 4: 1
        int n4 = 1;
        boolean r4 = isPowerOfFour(n4);
        System.out.println("\nNumber: " + n4 + " (4^0). Is Power of 4: " + r4);

        // Test 5: 5
        int n5 = 5;
        boolean r5 = isPowerOfFour(n5);
        System.out.println("\nNumber: " + n5 + ". Is Power of 4: " + r5);

        // Test 6: Powers of 4 in range
        java.util.ArrayList<Integer> powers = getPowersOfFourInRange(1, 100);
        System.out.println("\nPowers of 4 in [1, 100]: " + powers);
    }
}