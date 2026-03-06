
/**
 * Basic DSA Problems - Repdigit Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class Repigit {
    
    // Problem: Check if a Number is Repdigit Number
    // A Repdigit is a natural number composed of repeated instances of the same digit.
    // Examples: 1, 2, 3...9, 11, 22, 33, 111, 2222, 99999
    // Single-digit numbers (1-9) are repdigits; 0 is sometimes excluded (0, 00, 000...)
    
    /**
     * Check if a number is Repdigit
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static boolean isRepdigit(int n) {
        if (n < 0) return false;
        if (n < 10) return true;  // Single digit 0-9 are repdigits
        
        int digit = n % 10;
        while (n > 0) {
            if (n % 10 != digit) return false;
            n /= 10;
        }
        return true;
    }
    
    /**
     * Get the repeated digit and count for a repdigit. Returns int[2] = {digit, count} or null.
     */
    public static int[] getRepdigitInfo(int n) {
        if (!isRepdigit(n) || n < 0) return null;
        if (n == 0) return new int[] { 0, 1 };
        
        int digit = n % 10;
        int count = 0;
        int temp = n;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return new int[] { digit, count };
    }
    
    /**
     * Find all repdigits in a range
     */
    public static ArrayList<Integer> getRepdigitsInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isRepdigit(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Repdigit");
        System.out.println("=".repeat(60));
        
        // Test 1: 111
        int n1 = 111;
        boolean r1 = isRepdigit(n1);
        int[] info1 = getRepdigitInfo(n1);
        System.out.println("Number: " + n1 + " -> digit " + info1[0] + " repeated " + info1[1] + " times. Is Repdigit: " + r1);
        
        // Test 2: 77777
        int n2 = 77777;
        boolean r2 = isRepdigit(n2);
        System.out.println("\nNumber: " + n2 + ". Is Repdigit: " + r2);
        
        // Test 3: 123 (not repdigit)
        int n3 = 123;
        boolean r3 = isRepdigit(n3);
        System.out.println("\nNumber: " + n3 + ". Is Repdigit: " + r3);
        
        // Test 4: Single digit
        int n4 = 5;
        boolean r4 = isRepdigit(n4);
        System.out.println("\nNumber: " + n4 + " (single digit). Is Repdigit: " + r4);
        
        // Test 5: 0
        int n5 = 0;
        boolean r5 = isRepdigit(n5);
        System.out.println("\nNumber: " + n5 + ". Is Repdigit: " + r5);
        
        // Test 6: 222222
        int n6 = 222222;
        boolean r6 = isRepdigit(n6);
        System.out.println("\nNumber: " + n6 + ". Is Repdigit: " + r6);
        
        // Test 7: Repdigits in range
        ArrayList<Integer> repdigits = getRepdigitsInRange(1, 100);
        System.out.println("\nRepdigits in [1, 100]: " + repdigits);
    }
}
