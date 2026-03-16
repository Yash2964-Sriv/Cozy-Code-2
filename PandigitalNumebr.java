/**
 * Basic DSA Problems - Pandigital Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class PandigitalNumebr {
    
    // Problem: Check if a Number is Pandigital Number
    // A pandigital number contains each digit from 0 to 9 (or 1 to n) exactly once.
    // 0-9 pandigital: e.g., 1023456789, 9876543210
    // 1-9 pandigital: e.g., 123456789, 987654321 (no zero)
    
    /**
     * Check if number is 0-9 pandigital (contains each digit 0-9 exactly once)
     * Must have exactly 10 digits. Uses long to support numbers like 9876543210.
     */
    public static boolean isPandigital09(long n) {
        if (n < 0) return false;
        String s = String.valueOf(n);
        if (s.length() != 10) return false;
        
        boolean[] seen = new boolean[10];
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (seen[d]) return false;
            seen[d] = true;
        }
        return true;
    }
    
    /**
     * Check if number is 1-9 pandigital (contains each digit 1-9 exactly once, no zero)
     * Must have exactly 9 digits
     */
    public static boolean isPandigital19(int n) {
        if (n <= 0) return false;
        String s = String.valueOf(n);
        if (s.length() != 9) return false;
        if (s.contains("0")) return false;
        
        boolean[] seen = new boolean[10];
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d == 0 || seen[d]) return false;
            seen[d] = true;
        }
        return true;
    }
    
    /**
     * Check if number is n-digit pandigital (contains 1 to n exactly once)
     * e.g., for n=4: 1234, 4321, 1324 etc.
     */
    public static boolean isPandigital1ToN(int n, int numDigits) {
        if (n <= 0 || numDigits < 1 || numDigits > 9) return false;
        String s = String.valueOf(n);
        if (s.length() != numDigits) return false;
        
        boolean[] seen = new boolean[10];
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d < 1 || d > numDigits || seen[d]) return false;
            seen[d] = true;
        }
        return true;
    }
    
    /**
     * Find 1-9 pandigital numbers in range (123456789 to 987654321)
     */
    public static ArrayList<Integer> getPandigital19InRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = Math.max(start, 123456789); num <= Math.min(end, 987654321); num++) {
            if (isPandigital19(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Pandigital");
        System.out.println("=".repeat(60));
        
        // Test 1: 123456789 (1-9 pandigital)
        int n1 = 123456789;
        boolean r1 = isPandigital19(n1);
        System.out.println("Number: " + n1 + " (1-9). Is Pandigital: " + r1);
        
        // Test 2: 1023456789 (0-9 pandigital)
        long n2 = 1023456789L;
        boolean r2 = isPandigital09(n2);
        System.out.println("\nNumber: " + n2 + " (0-9). Is Pandigital: " + r2);
        
        // Test 3: 1234 (4-digit 1-4 pandigital)
        int n3 = 1234;
        boolean r3 = isPandigital1ToN(n3, 4);
        System.out.println("\nNumber: " + n3 + " (1-4 pandigital). Is Pandigital: " + r3);
        
        // Test 4: 123 (not 1-9, wrong length)
        int n4 = 123;
        boolean r4 = isPandigital19(n4);
        System.out.println("\nNumber: " + n4 + ". Is 1-9 Pandigital: " + r4);
        
        // Test 5: 1123456789 (has duplicate 1)
        long n5 = 1123456789L;
        boolean r5 = isPandigital09(n5);
        System.out.println("\nNumber: " + n5 + " (duplicate). Is 0-9 Pandigital: " + r5);
        
        // Test 6: 4321 (1-4 pandigital)
        int n6 = 4321;
        boolean r6 = isPandigital1ToN(n6, 4);
        System.out.println("\nNumber: " + n6 + " (1-4). Is Pandigital: " + r6);
    }
}