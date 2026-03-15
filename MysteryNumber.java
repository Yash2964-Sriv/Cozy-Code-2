/**
 * Basic DSA Problems - Mystery Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class MysteryNumber {
    
    // Problem: Check if a Number is Mystery Number
    // A Mystery number can be expressed as the sum of two numbers that are reverse of each other.
    // Example: 121 = 29 + 92; 44 = 13 + 31; 22 = 11 + 11
    
    /**
     * Reverse the digits of a number
     */
    public static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
    
    /**
     * Check if a number is Mystery number
     * Try all numbers from 1 to n/2, check if i + reverse(i) == n
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isMysteryNumber(int n) {
        if (n <= 0) return false;
        
        for (int i = 1; i <= n / 2; i++) {
            if (i + reverse(i) == n) return true;
        }
        return false;
    }
    
    /**
     * Get a pair (a, b) such that a + b = n and b = reverse(a). Returns int[2] or null.
     */
    public static int[] getMysteryPair(int n) {
        if (!isMysteryNumber(n)) return null;
        
        for (int i = 1; i <= n / 2; i++) {
            if (i + reverse(i) == n) {
                return new int[] { i, reverse(i) };
            }
        }
        return null;
    }
    
    /**
     * Find all Mystery numbers in a range
     */
    public static ArrayList<Integer> getMysteryNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isMysteryNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Mystery Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 121 = 29 + 92
        int n1 = 121;
        boolean r1 = isMysteryNumber(n1);
        int[] pair1 = getMysteryPair(n1);
        System.out.println("Number: " + n1);
        System.out.println("Pair: " + pair1[0] + " + " + pair1[1] + " = " + n1);
        System.out.println("Is Mystery: " + r1);
        
        // Test 2: 44 = 13 + 31
        int n2 = 44;
        boolean r2 = isMysteryNumber(n2);
        int[] pair2 = getMysteryPair(n2);
        System.out.println("\nNumber: " + n2 + " -> " + pair2[0] + " + " + pair2[1] + ". Is Mystery: " + r2);
        
        // Test 3: 22 = 11 + 11
        int n3 = 22;
        boolean r3 = isMysteryNumber(n3);
        System.out.println("\nNumber: " + n3 + " -> 11 + 11. Is Mystery: " + r3);
        
        // Test 4: 5 (no such pair)
        int n4 = 5;
        boolean r4 = isMysteryNumber(n4);
        System.out.println("\nNumber: " + n4 + ". Is Mystery: " + r4);
        
        // Test 5: 33 = 12 + 21
        int n5 = 33;
        boolean r5 = isMysteryNumber(n5);
        int[] pair5 = getMysteryPair(n5);
        System.out.println("\nNumber: " + n5 + " -> " + pair5[0] + " + " + pair5[1] + ". Is Mystery: " + r5);
        
        // Test 6: Mystery numbers in range
        ArrayList<Integer> mystery = getMysteryNumbersInRange(10, 100);
        System.out.println("\nMystery numbers in [10, 100]: " + mystery);
    }
}