/**
 * Basic DSA Problems - Missing Number
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class MissingNumber {

    // Problem: Array of n distinct numbers in [0, n]. Find the one number missing.
    // Example: [3,0,1] -> 2, [0,1] -> 2, [9,6,4,2,3,5,7,0,1] -> 8

    /**
     * Sum approach: expected sum 0+1+..+n = n*(n+1)/2, subtract actual sum
     * Time O(n), Space O(1)
     */
    public static int missingNumber(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = 0;
        for (int x : nums) actual += x;
        return expected - actual;
    }

    /**
     * XOR approach: x ^ x = 0, so xor all indices and values; missing appears once
     * Time O(n), Space O(1)
     */
    public static int missingNumberXor(int[] nums) {
        if (nums == null) return 0;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor ^ nums.length;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Missing Number");
        System.out.println("=".repeat(60));

        int[] a1 = { 3, 0, 1 };
        System.out.println("Array: " + Arrays.toString(a1) + " -> Missing: " + missingNumber(a1));

        int[] a2 = { 0, 1 };
        System.out.println("Array: " + Arrays.toString(a2) + " -> Missing: " + missingNumber(a2));

        int[] a3 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println("Array: " + Arrays.toString(a3) + " -> Missing: " + missingNumber(a3));
    }
}