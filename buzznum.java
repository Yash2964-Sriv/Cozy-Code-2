
/**
 * Basic DSA Problems - Buzz Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class buzznum {
    
    // Problem: Check if a Number is Buzz Number
    // A Buzz number is either divisible by 7 OR ends with the digit 7.
    // Examples: 7, 14, 17, 21, 27, 28, 35, 37, 42, 47...
    
    /**
     * Check if a number is Buzz number
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static boolean isBuzzNumber(int n) {
        if (n < 0) return false;
        return n % 7 == 0 || n % 10 == 7;
    }
    
    /**
     * Find all Buzz numbers in a range
     */
    public static ArrayList<Integer> getBuzzNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isBuzzNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Buzz Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 7 (divisible by 7 and ends with 7)
        int n1 = 7;
        boolean r1 = isBuzzNumber(n1);
        System.out.println("Number: " + n1 + " (divisible by 7, ends with 7). Is Buzz: " + r1);
        
        // Test 2: 17 (ends with 7, not divisible by 7)
        int n2 = 17;
        boolean r2 = isBuzzNumber(n2);
        System.out.println("\nNumber: " + n2 + " (ends with 7). Is Buzz: " + r2);
        
        // Test 3: 14 (divisible by 7)
        int n3 = 14;
        boolean r3 = isBuzzNumber(n3);
        System.out.println("\nNumber: " + n3 + " (divisible by 7). Is Buzz: " + r3);
        
        // Test 4: 15 (neither)
        int n4 = 15;
        boolean r4 = isBuzzNumber(n4);
        System.out.println("\nNumber: " + n4 + ". Is Buzz: " + r4);
        
        // Test 5: 47 (ends with 7)
        int n5 = 47;
        boolean r5 = isBuzzNumber(n5);
        System.out.println("\nNumber: " + n5 + ". Is Buzz: " + r5);
        
        // Test 6: Buzz numbers in range
        ArrayList<Integer> buzz = getBuzzNumbersInRange(1, 35);
        System.out.println("\nBuzz numbers in [1, 35]: " + buzz);
    }
}
