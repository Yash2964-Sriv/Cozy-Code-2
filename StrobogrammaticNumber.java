/**
 * Basic DSA Problems - Strobogrammatic Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class StrobogrammaticNumber {
    
    // Problem: Check if a Number is Strobogrammatic Number
    // A strobogrammatic number looks the same when rotated 180 degrees.
    // Valid digits when rotated: 0->0, 1->1, 6->9, 8->8, 9->6
    // Invalid: 2, 3, 4, 5, 7 (don't form valid digit when rotated)
    // Examples: 69, 96, 88, 101, 111, 818, 609
    
    private static final Map<Character, Character> ROTATION = new HashMap<>();
    static {
        ROTATION.put('0', '0');
        ROTATION.put('1', '1');
        ROTATION.put('6', '9');
        ROTATION.put('8', '8');
        ROTATION.put('9', '6');
    }
    
    /**
     * Check if a number is Strobogrammatic
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static boolean isStrobogrammatic(int n) {
        if (n < 0) return false;
        
        String s = String.valueOf(n);
        int left = 0, right = s.length() - 1;
        
        while (left <= right) {
            char c = s.charAt(left);
            char cRight = s.charAt(right);
            
            if (!ROTATION.containsKey(c) || !ROTATION.containsKey(cRight))
                return false;
            if (ROTATION.get(c) != cRight)
                return false;
            
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * Get the rotated form of a strobogrammatic number (as string)
     */
    public static String getRotatedForm(int n) {
        if (!isStrobogrammatic(n) || n < 0) return null;
        
        StringBuilder sb = new StringBuilder();
        for (char c : String.valueOf(n).toCharArray()) {
            sb.insert(0, ROTATION.get(c));
        }
        return sb.toString();
    }
    
    /**
     * Find strobogrammatic numbers in a range
     */
    public static ArrayList<Integer> getStrobogrammaticInRange(int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isStrobogrammatic(num)) result.add(num);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Check if a Number is Strobogrammatic");
        System.out.println("=".repeat(60));
        
        // Test 1: 69 (rotates to 69)
        int n1 = 69;
        boolean r1 = isStrobogrammatic(n1);
        System.out.println("Number: " + n1 + " (6<->9). Is Strobogrammatic: " + r1);
        
        // Test 2: 88
        int n2 = 88;
        boolean r2 = isStrobogrammatic(n2);
        System.out.println("\nNumber: " + n2 + ". Is Strobogrammatic: " + r2);
        
        // Test 3: 101
        int n3 = 101;
        boolean r3 = isStrobogrammatic(n3);
        System.out.println("\nNumber: " + n3 + ". Is Strobogrammatic: " + r3);
        
        // Test 4: 123 (contains 2,3 - invalid)
        int n4 = 123;
        boolean r4 = isStrobogrammatic(n4);
        System.out.println("\nNumber: " + n4 + ". Is Strobogrammatic: " + r4);
        
        // Test 5: 96
        int n5 = 96;
        boolean r5 = isStrobogrammatic(n5);
        String rotated5 = getRotatedForm(n5);
        System.out.println("\nNumber: " + n5 + " -> rotated: " + rotated5 + ". Is Strobogrammatic: " + r5);
        
        // Test 6: 818
        int n6 = 818;
        boolean r6 = isStrobogrammatic(n6);
        System.out.println("\nNumber: " + n6 + ". Is Strobogrammatic: " + r6);
        
        // Test 7: In range
        ArrayList<Integer> strobo = getStrobogrammaticInRange(1, 200);
        System.out.println("\nStrobogrammatic numbers in [1, 200]: " + strobo);
    }
}