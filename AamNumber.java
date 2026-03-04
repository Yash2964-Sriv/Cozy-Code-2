/**
 * Basic DSA Problems - Adam Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class AamNumber {
    
    // Problem: Check if a Number is Adam Number
    // An Adam number satisfies: reverse(square(n)) == square(reverse(n))
    // Example: 12 -> 12^2=144, reverse(144)=441; reverse(12)=21, 21^2=441. Equal!
    // Another: 13 -> 169, reverse=961; 31^2=961. Adam number.
    
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
    
    /** Reverse digits of a long (for large squares) */
    public static long reverseLong(long n) {
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
    
    /**
     * Check if a number is Adam number
     * reverse(square(n)) == square(reverse(n))
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static boolean isAdamNumber(int n) {
        if (n < 0) return false;
        
        long squareN = (long) n * n;
        int revN = reverse(n);
        long squareRevN = (long) revN * revN;
        long revSquareN = reverseLong(squareN);
        
        return revSquareN == squareRevN;
    }
    
    /**
     * Get the values: [square(n), reverse(square), square(reverse(n))]
     */
    public static long[] getAdamValues(int n) {
        if (n < 0) return null;
        long sq = (long) n * n;
        int rev = reverse(n);
        long sqRev = (long) rev * rev;
        long revSq = reverseLong(sq);
        return new long[] { sq, revSq, sqRev };
    }
    
    /**
     * Find Adam numbers in a range
     */
    public static ArrayList<Integer> getAdamNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isAdamNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Adam Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 12 (12^2=144, rev=441; 21^2=441)
        int n1 = 12;
        boolean r1 = isAdamNumber(n1);
        long[] v1 = getAdamValues(n1);
        System.out.println("Number: " + n1);
        System.out.println("Square=" + v1[0] + ", reverse(square)=" + v1[1] + ", square(reverse)=" + v1[2]);
        System.out.println("Is Adam: " + r1);
        
        // Test 2: 13
        int n2 = 13;
        boolean r2 = isAdamNumber(n2);
        System.out.println("\nNumber: " + n2 + " -> 169 rev=961, 31^2=961. Is Adam: " + r2);
        
        // Test 3: 11 (palindrome: 11^2=121, rev(121)=121; 11^2=121. Adam)
        int n3 = 11;
        boolean r3 = isAdamNumber(n3);
        System.out.println("\nNumber: " + n3 + ". Is Adam: " + r3);
        
        // Test 4: 5 (5^2=25, rev=52; reverse(5)=5, 5^2=25. 52!=25)
        int n4 = 5;
        boolean r4 = isAdamNumber(n4);
        System.out.println("\nNumber: " + n4 + ". Is Adam: " + r4);
        
        // Test 5: 1
        int n5 = 1;
        boolean r5 = isAdamNumber(n5);
        System.out.println("\nNumber: " + n5 + ". Is Adam: " + r5);
        
        // Test 6: Adam numbers in range
        ArrayList<Integer> adam = getAdamNumbersInRange(1, 50);
        System.out.println("\nAdam numbers in [1, 50]: " + adam);
    }
}