/**
 * Basic DSA Problems - Two More Fundamental Questions
 * Simple and essential DSA problems for beginners
 */
public class basic_dsa_eight {
    
    // Problem 1: Sum of Digits of a Number
    // Calculate the sum of all digits in a number
    
    /**
     * Calculate sum of digits using iterative approach
     * Time Complexity: O(log n) where log is base 10
     * Space Complexity: O(1)
     */
    public static int sumOfDigits(int n) {
        n = Math.abs(n); // Handle negative numbers
        int total = 0;
        
        while (n > 0) {
            total += n % 10;
            n /= 10;
        }
        
        return total;
    }
    
    /**
     * Calculate sum of digits using recursive approach
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursion stack
     */
    public static int sumOfDigitsRecursive(int n) {
        n = Math.abs(n); // Handle negative numbers
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigitsRecursive(n / 10);
    }
    
    // Problem 2: Reverse a Number
    // Reverse the digits of a number
    
    /**
     * Reverse a number using iterative approach
     * Time Complexity: O(log n) where log is base 10
     * Space Complexity: O(1)
     */
    public static int reverseNumber(int n) {
        boolean isNegative = n < 0;
        n = Math.abs(n);
        int reversedNum = 0;
        
        while (n > 0) {
            // Check for overflow
            if (reversedNum > Integer.MAX_VALUE / 10) {
                return 0; // Overflow
            }
            reversedNum = reversedNum * 10 + n % 10;
            n /= 10;
        }
        
        return isNegative ? -reversedNum : reversedNum;
    }
    
    /**
     * Reverse a number using recursive approach
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursion stack
     */
    public static int reverseNumberRecursive(int n) {
        return reverseNumberHelper(Math.abs(n), 0) * (n < 0 ? -1 : 1);
    }
    
    private static int reverseNumberHelper(int n, int reversedSoFar) {
        if (n == 0) {
            return reversedSoFar;
        }
        return reverseNumberHelper(n / 10, reversedSoFar * 10 + n % 10);
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Sum of Digits of a Number");
        System.out.println("=".repeat(60));
        
        // Test Case 1
        int num1 = 12345;
        int sumIter1 = sumOfDigits(num1);
        int sumRec1 = sumOfDigitsRecursive(num1);
        System.out.println("Number: " + num1);
        System.out.println("Sum of digits (Iterative): " + sumIter1);
        System.out.println("Sum of digits (Recursive): " + sumRec1);
        
        // Test Case 2
        int num2 = 9876;
        int sumIter2 = sumOfDigits(num2);
        int sumRec2 = sumOfDigitsRecursive(num2);
        System.out.println("\nNumber: " + num2);
        System.out.println("Sum of digits (Iterative): " + sumIter2);
        System.out.println("Sum of digits (Recursive): " + sumRec2);
        
        // Test Case 3 - Single digit
        int num3 = 5;
        int sumIter3 = sumOfDigits(num3);
        int sumRec3 = sumOfDigitsRecursive(num3);
        System.out.println("\nNumber: " + num3);
        System.out.println("Sum of digits (Iterative): " + sumIter3);
        System.out.println("Sum of digits (Recursive): " + sumRec3);
        
        // Test Case 4 - Negative number
        int num4 = -123;
        int sumIter4 = sumOfDigits(num4);
        int sumRec4 = sumOfDigitsRecursive(num4);
        System.out.println("\nNumber: " + num4);
        System.out.println("Sum of digits (Iterative): " + sumIter4);
        System.out.println("Sum of digits (Recursive): " + sumRec4);
        
        // Test Case 5 - Zero
        int num5 = 0;
        int sumIter5 = sumOfDigits(num5);
        int sumRec5 = sumOfDigitsRecursive(num5);
        System.out.println("\nNumber: " + num5);
        System.out.println("Sum of digits (Iterative): " + sumIter5);
        System.out.println("Sum of digits (Recursive): " + sumRec5);
        
        // Test Case 6 - Number with zeros
        int num6 = 1005;
        int sumIter6 = sumOfDigits(num6);
        int sumRec6 = sumOfDigitsRecursive(num6);
        System.out.println("\nNumber: " + num6);
        System.out.println("Sum of digits (Iterative): " + sumIter6);
        System.out.println("Sum of digits (Recursive): " + sumRec6);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Problem 2: Reverse a Number");
        System.out.println("=".repeat(60));
        
        // Test Case 1
        int num7 = 12345;
        int revIter1 = reverseNumber(num7);
        int revRec1 = reverseNumberRecursive(num7);
        System.out.println("Number: " + num7);
        System.out.println("Reversed (Iterative): " + revIter1);
        System.out.println("Reversed (Recursive): " + revRec1);
        
        // Test Case 2
        int num8 = 9876;
        int revIter2 = reverseNumber(num8);
        int revRec2 = reverseNumberRecursive(num8);
        System.out.println("\nNumber: " + num8);
        System.out.println("Reversed (Iterative): " + revIter2);
        System.out.println("Reversed (Recursive): " + revRec2);
        
        // Test Case 3 - Single digit
        int num9 = 5;
        int revIter3 = reverseNumber(num9);
        int revRec3 = reverseNumberRecursive(num9);
        System.out.println("\nNumber: " + num9);
        System.out.println("Reversed (Iterative): " + revIter3);
        System.out.println("Reversed (Recursive): " + revRec3);
        
        // Test Case 4 - Negative number
        int num10 = -123;
        int revIter4 = reverseNumber(num10);
        int revRec4 = reverseNumberRecursive(num10);
        System.out.println("\nNumber: " + num10);
        System.out.println("Reversed (Iterative): " + revIter4);
        System.out.println("Reversed (Recursive): " + revRec4);
        
        // Test Case 5 - Number ending with zero
        int num11 = 1200;
        int revIter5 = reverseNumber(num11);
        int revRec5 = reverseNumberRecursive(num11);
        System.out.println("\nNumber: " + num11);
        System.out.println("Reversed (Iterative): " + revIter5);
        System.out.println("Reversed (Recursive): " + revRec5);
        
        // Test Case 6 - Palindrome number
        int num12 = 1221;
        int revIter6 = reverseNumber(num12);
        int revRec6 = reverseNumberRecursive(num12);
        System.out.println("\nNumber: " + num12);
        System.out.println("Reversed (Iterative): " + revIter6);
        System.out.println("Reversed (Recursive): " + revRec6);
    }
}