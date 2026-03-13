/**
 * Basic DSA Problems - Keith Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class KeithNumber{
    
    // Problem: Check if a Number is Keith Number (Repfigit Number)
    // A Keith number appears in a Fibonacci-like sequence where each term is the sum
    // of the previous d terms (d = number of digits). Sequence starts with the d digits of n.
    // Example: 197 -> 1, 9, 7 -> 17, 33, 57, 107, 197. So 197 is Keith.
    
    /**
     * Check if a number is Keith number
     * Time Complexity: O(n) in worst case
     * Space Complexity: O(d) where d is number of digits
     */
    public static boolean isKeithNumber(int n) {
        if (n <= 0) return false;
        
        ArrayList<Integer> digits = new ArrayList<>();
        int temp = n;
        while (temp > 0) {
            digits.add(0, temp % 10);
            temp /= 10;
        }
        
        int d = digits.size();
        if (d == 1) return true;  // Single digit: sequence is just that digit
        
        // Build sequence until we reach or pass n
        while (true) {
            int next = 0;
            for (int i = digits.size() - d; i < digits.size(); i++) {
                next += digits.get(i);
            }
            
            if (next > n) return false;
            if (next == n) return true;
            
            digits.add(next);
        }
    }
    
    /**
     * Get the sequence leading to n (if Keith). Returns null otherwise.
     */
    public static ArrayList<Integer> getKeithSequence(int n) {
        if (n <= 0) return null;
        
        ArrayList<Integer> digits = new ArrayList<>();
        int temp = n;
        while (temp > 0) {
            digits.add(0, temp % 10);
            temp /= 10;
        }
        
        int d = digits.size();
        if (d == 1) return new ArrayList<>(digits);
        
        while (true) {
            int next = 0;
            for (int i = digits.size() - d; i < digits.size(); i++) {
                next += digits.get(i);
            }
            
            if (next > n) return null;
            digits.add(next);
            if (next == n) return new ArrayList<>(digits);
        }
    }
    
    /**
     * Find Keith numbers in a range
     */
    public static ArrayList<Integer> getKeithNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isKeithNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Keith Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 197
        int n1 = 197;
        boolean r1 = isKeithNumber(n1);
        ArrayList<Integer> seq1 = getKeithSequence(n1);
        System.out.println("Number: " + n1);
        System.out.println("Sequence: " + seq1);
        System.out.println("Is Keith: " + r1);
        
        // Test 2: 14 (1,4 -> 5 -> 9 -> 14)
        int n2 = 14;
        boolean r2 = isKeithNumber(n2);
        ArrayList<Integer> seq2 = getKeithSequence(n2);
        System.out.println("\nNumber: " + n2 + " -> Sequence: " + seq2 + ". Is Keith: " + r2);
        
        // Test 3: 19 (1,9 -> 10 -> 19)
        int n3 = 19;
        boolean r3 = isKeithNumber(n3);
        System.out.println("\nNumber: " + n3 + ". Is Keith: " + r3);
        
        // Test 4: 15 (not Keith: 1,5 -> 6 -> 11, never 15)
        int n4 = 15;
        boolean r4 = isKeithNumber(n4);
        System.out.println("\nNumber: " + n4 + ". Is Keith: " + r4);
        
        // Test 5: Single digit
        int n5 = 7;
        boolean r5 = isKeithNumber(n5);
        System.out.println("\nNumber: " + n5 + " (single digit). Is Keith: " + r5);
        
        // Test 6: Keith numbers in range
        ArrayList<Integer> keith = getKeithNumbersInRange(1, 100);
        System.out.println("\nKeith numbers in [1, 100]: " + keith);
    }
}