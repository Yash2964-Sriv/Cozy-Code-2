/**
 * Basic DSA Problems - Power of Two
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class poweroftwo {
    
    // Problem: Check if a Number is Power of Two
    // A number is power of 2 if it can be written as 2^k for some non-negative integer k.
    // Examples: 1, 2, 4, 8, 16, 32... (2^0, 2^1, 2^2, 2^3...)
    // Bit trick: n > 0 && (n & (n-1)) == 0 (only one bit set)
    
    /**
     * Check using bitwise - power of 2 has exactly one bit set
     * n & (n-1) clears the lowest set bit; for powers of 2, result is 0
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static boolean isPowerOfTwoBitwise(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    /**
     * Check using loop - repeatedly divide by 2
     * Time Complexity: O(log n)
     */
    public static boolean isPowerOfTwoLoop(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }
    
    /**
     * Get the exponent k if n = 2^k, else -1
     */
    public static int getPowerOfTwoExponent(int n) {
        if (!isPowerOfTwoBitwise(n)) return -1;
        int k = 0;
        while (n > 1) {
            n /= 2;
            k++;
        }
        return k;
    }
    
    /**
     * Find all powers of 2 in a range
     */
    public static ArrayList<Integer> getPowersOfTwoInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int p = 0; ; p++) {
            int val = (int) Math.pow(2, p);
            if (val > end) break;
            if (val >= start) result.add(val);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Power of Two");
        System.out.println("=".repeat(60));
        
        // Test 1: 8
        int n1 = 8;
        boolean r1 = isPowerOfTwoBitwise(n1);
        int exp1 = getPowerOfTwoExponent(n1);
        System.out.println("Number: " + n1 + " = 2^" + exp1 + ". Is Power of 2: " + r1);
        
        // Test 2: 16
        int n2 = 16;
        boolean r2 = isPowerOfTwoBitwise(n2);
        System.out.println("\nNumber: " + n2 + ". Is Power of 2: " + r2);
        
        // Test 3: 6 (not power of 2)
        int n3 = 6;
        boolean r3 = isPowerOfTwoBitwise(n3);
        System.out.println("\nNumber: " + n3 + ". Is Power of 2: " + r3);
        
        // Test 4: 1 (2^0)
        int n4 = 1;
        boolean r4 = isPowerOfTwoBitwise(n4);
        System.out.println("\nNumber: " + n4 + ". Is Power of 2: " + r4);
        
        // Test 5: 0
        int n5 = 0;
        boolean r5 = isPowerOfTwoBitwise(n5);
        System.out.println("\nNumber: " + n5 + ". Is Power of 2: " + r5);
        
        // Test 6: Bitwise vs Loop
        int n6 = 1024;
        System.out.println("\nNumber: " + n6 + " -> Bitwise: " + isPowerOfTwoBitwise(n6) + 
            ", Loop: " + isPowerOfTwoLoop(n6));
        
        // Test 7: Powers of 2 in range
        ArrayList<Integer> powers = getPowersOfTwoInRange(1, 50);
        System.out.println("\nPowers of 2 in [1, 50]: " + powers);
    }
}