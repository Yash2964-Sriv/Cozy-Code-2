import java.util.*;

/**
 * Basic DSA Problems - Two More Fundamental Questions
 * Simple and essential DSA problems for beginners
 */
public class SwapNums {
    
    // Problem 1: Swap Two Numbers
    // Swap two numbers using different methods
    
    /**
     * Swap two numbers using temporary variable
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int[] swapWithTemp(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
    }
    
    /**
     * Swap two numbers without temporary variable (using arithmetic)
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int[] swapWithoutTempArithmetic(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a, b};
    }
    
    /**
     * Swap two numbers without temporary variable (using XOR)
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int[] swapWithoutTempXOR(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a, b};
    }
    
    // Problem 2: Find All Factors of a Number
    // Find all factors (divisors) of a given number
    
    /**
     * Find all factors of a number (brute force)
     * Time Complexity: O(n)
     * Space Complexity: O(√n)
     */
    public static List<Integer> findFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n == 0) {
            return factors;
        }
        
        n = Math.abs(n);
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        
        return factors;
    }
    
    /**
     * Find all factors of a number (optimized - only iterate up to √n)
     * Time Complexity: O(√n)
     * Space Complexity: O(√n)
     */
    public static List<Integer> findFactorsOptimized(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n == 0) {
            return factors;
        }
        
        n = Math.abs(n);
        
        // Iterate only up to √n
        int i = 1;
        while (i * i <= n) {
            if (n % i == 0) {
                factors.add(i);
                // If i != n/i, then n/i is also a factor
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
            i++;
        }
        
        // Sort factors for better readability
        Collections.sort(factors);
        return factors;
    }
    
    /**
     * Count the number of factors of a number
     * Time Complexity: O(√n)
     * Space Complexity: O(1)
     */
    public static int countFactors(int n) {
        if (n == 0) {
            return 0;
        }
        
        n = Math.abs(n);
        int count = 0;
        
        int i = 1;
        while (i * i <= n) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
            i++;
        }
        
        return count;
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Swap Two Numbers");
        System.out.println("=".repeat(60));
        
        // Test Case 1
        int a1 = 10, b1 = 20;
        System.out.println("Before swap: a = " + a1 + ", b = " + b1);
        int[] swapped1 = swapWithTemp(a1, b1);
        System.out.println("After swap (with temp): a = " + swapped1[0] + ", b = " + swapped1[1]);
        
        // Test Case 2 - Without temp (arithmetic)
        int a2 = 15, b2 = 25;
        System.out.println("\nBefore swap: a = " + a2 + ", b = " + b2);
        int[] swapped2 = swapWithoutTempArithmetic(a2, b2);
        System.out.println("After swap (arithmetic): a = " + swapped2[0] + ", b = " + swapped2[1]);
        
        // Test Case 3 - Without temp (XOR)
        int a3 = 7, b3 = 13;
        System.out.println("\nBefore swap: a = " + a3 + ", b = " + b3);
        int[] swapped3 = swapWithoutTempXOR(a3, b3);
        System.out.println("After swap (XOR): a = " + swapped3[0] + ", b = " + swapped3[1]);
        
        // Test Case 4 - Negative numbers
        int a4 = -5, b4 = 10;
        System.out.println("\nBefore swap: a = " + a4 + ", b = " + b4);
        int[] swapped4 = swapWithoutTempXOR(a4, b4);
        System.out.println("After swap (XOR): a = " + swapped4[0] + ", b = " + swapped4[1]);
        
        // Test Case 5 - Same numbers
        int a5 = 42, b5 = 42;
        System.out.println("\nBefore swap: a = " + a5 + ", b = " + b5);
        int[] swapped5 = swapWithoutTempXOR(a5, b5);
        System.out.println("After swap (XOR): a = " + swapped5[0] + ", b = " + swapped5[1]);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Problem 2: Find All Factors of a Number");
        System.out.println("=".repeat(60));
        
        // Test Case 1
        int num1 = 12;
        List<Integer> factors1 = findFactors(num1);
        List<Integer> factorsOpt1 = findFactorsOptimized(num1);
        int count1 = countFactors(num1);
        System.out.println("Number: " + num1);
        System.out.println("Factors (Brute Force): " + factors1);
        System.out.println("Factors (Optimized): " + factorsOpt1);
        System.out.println("Number of factors: " + count1);
        
        // Test Case 2
        int num2 = 24;
        List<Integer> factors2 = findFactors(num2);
        List<Integer> factorsOpt2 = findFactorsOptimized(num2);
        int count2 = countFactors(num2);
        System.out.println("\nNumber: " + num2);
        System.out.println("Factors (Brute Force): " + factors2);
        System.out.println("Factors (Optimized): " + factorsOpt2);
        System.out.println("Number of factors: " + count2);
        
        // Test Case 3 - Prime number
        int num3 = 17;
        List<Integer> factors3 = findFactors(num3);
        List<Integer> factorsOpt3 = findFactorsOptimized(num3);
        int count3 = countFactors(num3);
        System.out.println("\nNumber: " + num3);
        System.out.println("Factors (Brute Force): " + factors3);
        System.out.println("Factors (Optimized): " + factorsOpt3);
        System.out.println("Number of factors: " + count3);
        
        // Test Case 4 - Perfect square
        int num4 = 16;
        List<Integer> factors4 = findFactors(num4);
        List<Integer> factorsOpt4 = findFactorsOptimized(num4);
        int count4 = countFactors(num4);
        System.out.println("\nNumber: " + num4);
        System.out.println("Factors (Brute Force): " + factors4);
        System.out.println("Factors (Optimized): " + factorsOpt4);
        System.out.println("Number of factors: " + count4);
        
        // Test Case 5 - Single factor (1)
        int num5 = 1;
        List<Integer> factors5 = findFactors(num5);
        List<Integer> factorsOpt5 = findFactorsOptimized(num5);
        int count5 = countFactors(num5);
        System.out.println("\nNumber: " + num5);
        System.out.println("Factors (Brute Force): " + factors5);
        System.out.println("Factors (Optimized): " + factorsOpt5);
        System.out.println("Number of factors: " + count5);
        
        // Test Case 6 - Large number
        int num6 = 100;
        List<Integer> factors6 = findFactors(num6);
        List<Integer> factorsOpt6 = findFactorsOptimized(num6);
        int count6 = countFactors(num6);
        System.out.println("\nNumber: " + num6);
        System.out.println("Factors (Brute Force): " + factors6);
        System.out.println("Factors (Optimized): " + factorsOpt6);
        System.out.println("Number of factors: " + count6);
    }
}