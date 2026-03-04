/**
 * Basic DSA Problems - Autobiographical Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class autobio_number {
    
    // Problem: Check if a Number is Autobiographical Number
    // An autobiographical number describes itself: the digit at position i
    // counts how many times digit i appears in the number.
    // Example: 1210 -> 1 zero, 2 ones, 1 two, 0 threes. Length must be 4.
    // Valid: 1210, 2020, 21200. Max length is 10 (digits 0-9).
    
    /**
     * Check if a number is autobiographical
     * Time Complexity: O(d) where d is number of digits
     * Space Complexity: O(1)
     */
    public static boolean isAutobiographicalNumber(int n) {
        if (n < 0) return false;
        
        String s = String.valueOf(n);
        int len = s.length();
        if (len > 10) return false;
        
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d >= len) return false;  // Digit can't be >= length
            count[d]++;
        }
        
        for (int i = 0; i < len; i++) {
            if (count[i] != (s.charAt(i) - '0')) return false;
        }
        return true;
    }
    
    /**
     * Find all autobiographical numbers (there are only 4: 1210, 2020, 21200, 3211000)
     */
    public static ArrayList<Integer> getAutobiographicalNumbersInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isAutobiographicalNumber(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Autobiographical Number");
        System.out.println("=".repeat(60));
        
        // Test 1: 1210 (1 zero, 2 ones, 1 two, 0 threes)
        int n1 = 1210;
        boolean r1 = isAutobiographicalNumber(n1);
        System.out.println("Number: " + n1 + " -> 1 zero, 2 ones, 1 two, 0 threes. Is Autobiographical: " + r1);
        
        // Test 2: 2020
        int n2 = 2020;
        boolean r2 = isAutobiographicalNumber(n2);
        System.out.println("\nNumber: " + n2 + ". Is Autobiographical: " + r2);
        
        // Test 3: 123 (not autobiographical)
        int n3 = 123;
        boolean r3 = isAutobiographicalNumber(n3);
        System.out.println("\nNumber: " + n3 + ". Is Autobiographical: " + r3);
        
        // Test 4: 21200
        int n4 = 21200;
        boolean r4 = isAutobiographicalNumber(n4);
        System.out.println("\nNumber: " + n4 + ". Is Autobiographical: " + r4);
        
        // Test 5: 3211000
        int n5 = 3211000;
        boolean r5 = isAutobiographicalNumber(n5);
        System.out.println("\nNumber: " + n5 + ". Is Autobiographical: " + r5);
        
        // Test 6: Find all in range
        ArrayList<Integer> autoNums = getAutobiographicalNumbersInRange(0, 3500000);
        System.out.println("\nAutobiographical numbers in [0, 3500000]: " + autoNums);
    }
}