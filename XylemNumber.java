/**
 * Basic DSA Problems - Xylem Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class XylemNumber {
    
    // Problem: Check if a Number is Xylem Number
    // A Xylem number: sum of extreme digits (first and last) equals sum of mean digits (all middle).
    // Example: 1234 -> extreme: 1+4=5, mean: 2+3=5 -> Xylem
    // 12345 -> extreme: 1+5=6, mean: 2+3+4=9 -> Not Xylem (Phloem)
    // Single-digit and 2-digit numbers: extreme = sum of digits, mean = 0 -> Xylem if digit sum != 0
    
    /**
     * Check if a number is Xylem number
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static boolean isXylemNumber(int n) {
        if (n < 0) return false;
        if (n < 10) return true;  // Single digit: mean=0, extreme=digit, considered xylem
        
        String s = String.valueOf(n);
        int extreme = (s.charAt(0) - '0') + (s.charAt(s.length() - 1) - '0');
        int mean = 0;
        
        for (int i = 1; i < s.length() - 1; i++) {
            mean += s.charAt(i) - '0';
        }
        
        return extreme == mean;
    }
    
    /**
     * Get extreme and mean sums for a number. Returns int[2] = {extreme, mean}
     */
    public static int[] getXylemSums(int n) {
        String s = String.valueOf(Math.abs(n));
        if (s.length() == 1) {
            return new int[] { s.charAt(0) - '0', 0 };
        }
        int extreme = (s.charAt(0) - '0') + (s.charAt(s.length() - 1) - '0');
        int mean = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            mean += s.charAt(i) - '0';
        }
        return new int[] { extreme, mean };
    }
    
    /**
     * Find all Xylem numbers in a range
     */
    public static ArrayList<Integer> getXylemNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isXylemNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Xylem Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 1234 (extreme 1+4=5, mean 2+3=5)
        int n1 = 1234;
        boolean r1 = isXylemNumber(n1);
        int[] sums1 = getXylemSums(n1);
        System.out.println("Number: " + n1 + " -> extreme=" + sums1[0] + ", mean=" + sums1[1] + ". Is Xylem: " + r1);
        
        // Test 2: 12345 (extreme 6, mean 9 - Phloem)
        int n2 = 12345;
        boolean r2 = isXylemNumber(n2);
        int[] sums2 = getXylemSums(n2);
        System.out.println("\nNumber: " + n2 + " -> extreme=" + sums2[0] + ", mean=" + sums2[1] + ". Is Xylem: " + r2);
        
        // Test 3: 48 (extreme 4+8=12, mean 0 - not equal, so Phloem)
        int n3 = 48;
        boolean r3 = isXylemNumber(n3);
        System.out.println("\nNumber: " + n3 + " -> extreme=12, mean=0. Is Xylem: " + r3);
        
        // Test 4: 6 (single digit)
        int n4 = 6;
        boolean r4 = isXylemNumber(n4);
        System.out.println("\nNumber: " + n4 + " (single digit). Is Xylem: " + r4);
        
        // Test 5: 171 (1+1=2, mean 7 - Phloem)
        int n5 = 171;
        boolean r5 = isXylemNumber(n5);
        System.out.println("\nNumber: " + n5 + " -> extreme=2, mean=7. Is Xylem: " + r5);
        
        // Test 6: 121 (1+1=2, mean 2 - Xylem)
        int n6 = 121;
        boolean r6 = isXylemNumber(n6);
        System.out.println("\nNumber: " + n6 + " -> extreme=2, mean=2. Is Xylem: " + r6);
        
        // Test 7: Xylem numbers in range
        ArrayList<Integer> xylem = getXylemNumbersInRange(100, 150);
        System.out.println("\nXylem numbers in [100, 150]: " + xylem);
    }
}