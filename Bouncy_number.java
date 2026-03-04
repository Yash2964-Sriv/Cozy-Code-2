/**
 * Basic DSA Problems - Bouncy Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class Bouncy_number{
    
    // Problem: Check if a Number is Bouncy Number
    // A bouncy number has digits that are neither strictly increasing nor strictly decreasing.
    // Example: 12321 is bouncy (goes up then down); 123 is not (increasing); 321 is not (decreasing)
    // Single-digit numbers are not considered bouncy (need at least 2 digits)
    
    /**
     * Check if a number is bouncy
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static boolean isBouncyNumber(int n) {
        if (n < 10) return false;  // Need at least 2 digits
        
        String s = String.valueOf(n);
        boolean hasIncrease = false;
        boolean hasDecrease = false;
        
        for (int i = 1; i < s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            if (diff > 0) hasIncrease = true;
            if (diff < 0) hasDecrease = true;
            if (hasIncrease && hasDecrease) return true;
        }
        
        return false;
    }
    
    /**
     * Find all bouncy numbers in a range
     */
    public static ArrayList<Integer> getBouncyNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isBouncyNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Bouncy Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 12321 (bouncy - up then down)
        int n1 = 12321;
        boolean r1 = isBouncyNumber(n1);
        System.out.println("Number: " + n1 + " (digits go up then down). Is Bouncy: " + r1);
        
        // Test 2: 123 (strictly increasing - not bouncy)
        int n2 = 123;
        boolean r2 = isBouncyNumber(n2);
        System.out.println("\nNumber: " + n2 + " (strictly increasing). Is Bouncy: " + r2);
        
        // Test 3: 321 (strictly decreasing - not bouncy)
        int n3 = 321;
        boolean r3 = isBouncyNumber(n3);
        System.out.println("\nNumber: " + n3 + " (strictly decreasing). Is Bouncy: " + r3);
        
        // Test 4: 101 (bouncy)
        int n4 = 101;
        boolean r4 = isBouncyNumber(n4);
        System.out.println("\nNumber: " + n4 + ". Is Bouncy: " + r4);
        
        // Test 5: Single digit
        int n5 = 5;
        boolean r5 = isBouncyNumber(n5);
        System.out.println("\nNumber: " + n5 + " (single digit). Is Bouncy: " + r5);
        
        // Test 6: Bouncy numbers in range
        ArrayList<Integer> bouncy = getBouncyNumbersInRange(100, 120);
        System.out.println("\nBouncy numbers in [100, 120]: " + bouncy);
        
        // Test 7: 155349 (bouncy)
        int n7 = 155349;
        boolean r7 = isBouncyNumber(n7);
        System.out.println("\nNumber: " + n7 + ". Is Bouncy: " + r7);
    }
}