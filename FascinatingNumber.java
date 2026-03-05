/**
 * Basic DSA Problems - Fascinating Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class FascinatingNumber {
    
    // Problem: Check if a Number is Fascinating Number
    // A fascinating number when concatenated with 2*n and 3*n contains
    // all digits 1-9 exactly once (no zero).
    // Example: 192 -> 192 384 576 -> "192384576" has 1,2,3,4,5,6,7,8,9
    // Note: n must have at least 3 digits for the concatenation to work
    
    /**
     * Check if a number is fascinating
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static boolean isFascinatingNumber(int n) {
        if (n < 100) return false;  // Need 3+ digits for valid concatenation
        
        String concat = "" + n + (2L * n) + (3L * n);
        if (concat.length() != 9) return false;  // Must have exactly 9 digits
        
        boolean[] seen = new boolean[10];
        for (char c : concat.toCharArray()) {
            int d = c - '0';
            if (d == 0 || seen[d]) return false;  // No zero, no duplicate
            seen[d] = true;
        }
        return true;
    }
    
    /**
     * Get the concatenated string for a fascinating number
     * Returns null if not fascinating
     */
    public static String getFascinatingConcatenation(int n) {
        if (!isFascinatingNumber(n)) return null;
        return "" + n + (2L * n) + (3L * n);
    }
    
    /**
     * Find all fascinating numbers in a range (100 to 333, beyond that 3*n has 4 digits)
     */
    public static ArrayList<Integer> getFascinatingNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = Math.max(start, 100); num <= Math.min(end, 333); num++) {
            if (isFascinatingNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Fascinating Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 192 (classic fascinating number)
        int n1 = 192;
        boolean r1 = isFascinatingNumber(n1);
        String concat1 = getFascinatingConcatenation(n1);
        System.out.println("Number: " + n1);
        System.out.println("Concatenation: " + n1 + " " + (2*n1) + " " + (3*n1) + " = " + concat1);
        System.out.println("Is Fascinating: " + r1);
        
        // Test 2: 219
        int n2 = 219;
        boolean r2 = isFascinatingNumber(n2);
        System.out.println("\nNumber: " + n2 + " -> " + n2 + " " + (2*n2) + " " + (3*n2));
        System.out.println("Is Fascinating: " + r2);
        
        // Test 3: Not fascinating (too small)
        int n3 = 12;
        boolean r3 = isFascinatingNumber(n3);
        System.out.println("\nNumber: " + n3 + " (less than 100). Is Fascinating: " + r3);
        
        // Test 4: Not fascinating (has duplicate/zero in concat)
        int n4 = 111;
        boolean r4 = isFascinatingNumber(n4);
        System.out.println("\nNumber: " + n4 + ". Is Fascinating: " + r4);
        
        // Test 5: All fascinating numbers (100-333)
        ArrayList<Integer> fascNums = getFascinatingNumbersInRange(100, 500);
        System.out.println("\nFascinating numbers in [100, 500]: " + fascNums);
        
        // Test 6: 273
        int n6 = 273;
        boolean r6 = isFascinatingNumber(n6);
        System.out.println("\nNumber: " + n6 + " -> " + n6 + " " + (2*n6) + " " + (3*n6));
        System.out.println("Is Fascinating: " + r6);
    }
}