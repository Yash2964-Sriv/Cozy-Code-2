/**
 * Basic DSA Problems - Two More Fundamental Questions
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class basic_dsa_eighteen {
    
    // Problem 1: Check if a Number is Strong Number
    // A strong number is a number whose sum of factorial of digits equals the number itself
    // Example: 145 = 1! + 4! + 5! = 1 + 24 + 120 = 145
    
    /**
     * Calculate factorial of a number
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Check if a number is strong number
     * Time Complexity: O(d * k) where d is number of digits, k is average digit value
     * Space Complexity: O(1)
     */
    public static boolean isStrongNumber(int n) {
        if (n <= 0) {
            return false;
        }
        
        int original = n;
        long sumFactorial = 0;
        
        while (n > 0) {
            int digit = n % 10;
            sumFactorial += factorial(digit);
            n /= 10;
        }
        
        return sumFactorial == original;
    }
    
    /**
     * Get list of factorials of each digit
     * Time Complexity: O(d * k) where d is number of digits
     * Space Complexity: O(d)
     */
    public static ArrayList<Long> getDigitFactorials(int n) {
        ArrayList<Long> factorials = new ArrayList<>();
        if (n <= 0) {
            return factorials;
        }
        
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            factorials.add(0, factorial(digit));
            temp /= 10;
        }
        
        return factorials;
    }
    
    // Problem 2: Convert Binary to Decimal
    // Convert a binary number to its decimal representation
    
    /**
     * Convert binary string to decimal using iteration
     * Time Complexity: O(n) where n is length of binary string
     * Space Complexity: O(1)
     */
    public static int binaryToDecimalIterative(String binaryStr) {
        if (binaryStr == null || binaryStr.isEmpty() || binaryStr.equals("0")) {
            return 0;
        }
        
        boolean isNegative = binaryStr.charAt(0) == '-';
        int start = isNegative ? 1 : 0;
        
        int decimal = 0;
        int power = 0;
        
        // Process from right to left (least significant bit to most)
        for (int i = binaryStr.length() - 1; i >= start; i--) {
            char ch = binaryStr.charAt(i);
            if (ch == '1') {
                decimal += Math.pow(2, power);
            } else if (ch != '0') {
                throw new IllegalArgumentException("Invalid binary digit: " + ch);
            }
            power++;
        }
        
        return isNegative ? -decimal : decimal;
    }
    
    /**
     * Convert binary string to decimal using recursion
     * Time Complexity: O(n) where n is length of binary string
     * Space Complexity: O(n) due to recursion stack
     */
    public static int binaryToDecimalRecursive(String binaryStr) {
        if (binaryStr == null || binaryStr.isEmpty() || binaryStr.equals("0")) {
            return 0;
        }
        
        boolean isNegative = binaryStr.charAt(0) == '-';
        String binary = isNegative ? binaryStr.substring(1) : binaryStr;
        
        int result = helper(binary, binary.length() - 1, 0);
        return isNegative ? -result : result;
    }
    
    private static int helper(String binary, int index, int power) {
        if (index < 0) {
            return 0;
        }
        if (binary.charAt(index) == '1') {
            return (int) Math.pow(2, power) + helper(binary, index - 1, power + 1);
        } else if (binary.charAt(index) == '0') {
            return helper(binary, index - 1, power + 1);
        } else {
            throw new IllegalArgumentException("Invalid binary digit: " + binary.charAt(index));
        }
    }
    
    /**
     * Convert binary string to decimal using built-in function
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int binaryToDecimalBuiltin(String binaryStr) {
        if (binaryStr == null || binaryStr.isEmpty()) {
            return 0;
        }
        
        boolean isNegative = binaryStr.charAt(0) == '-';
        String binary = isNegative ? binaryStr.substring(1) : binaryStr;
        
        int decimal = Integer.parseInt(binary, 2);
        return isNegative ? -decimal : decimal;
    }
    
    /**
     * Convert binary array to decimal
     * Time Complexity: O(n) where n is length of array
     * Space Complexity: O(1)
     */
    public static int binaryArrayToDecimal(int[] binaryArray) {
        if (binaryArray == null || binaryArray.length == 0) {
            return 0;
        }
        
        int decimal = 0;
        int power = binaryArray.length - 1;
        
        for (int digit : binaryArray) {
            if (digit != 0 && digit != 1) {
                throw new IllegalArgumentException("Invalid binary digit: " + digit);
            }
            decimal += digit * Math.pow(2, power);
            power--;
        }
        
        return decimal;
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Check if a Number is Strong Number");
        System.out.println("=".repeat(60));
        
        // Test Case 1 - Strong number 145
        int num1 = 145;
        boolean result1 = isStrongNumber(num1);
        ArrayList<Long> factorials1 = getDigitFactorials(num1);
        long sum1 = factorials1.stream().mapToLong(Long::longValue).sum();
        System.out.println("Number: " + num1);
        System.out.println("Digit factorials: " + factorials1);
        System.out.println("Sum of factorials: " + sum1);
        System.out.println("Is strong number: " + result1);
        
        // Test Case 2 - Not strong number
        int num2 = 123;
        boolean result2 = isStrongNumber(num2);
        ArrayList<Long> factorials2 = getDigitFactorials(num2);
        long sum2 = factorials2.stream().mapToLong(Long::longValue).sum();
        System.out.println("\nNumber: " + num2);
        System.out.println("Digit factorials: " + factorials2);
        System.out.println("Sum of factorials: " + sum2);
        System.out.println("Is strong number: " + result2);
        
        // Test Case 3 - Strong number 1
        int num3 = 1;
        boolean result3 = isStrongNumber(num3);
        System.out.println("\nNumber: " + num3);
        System.out.println("Is strong number: " + result3);
        
        // Test Case 4 - Strong number 2
        int num4 = 2;
        boolean result4 = isStrongNumber(num4);
        System.out.println("\nNumber: " + num4);
        System.out.println("Is strong number: " + result4);
        
        // Test Case 5 - Not strong number
        int num5 = 10;
        boolean result5 = isStrongNumber(num5);
        ArrayList<Long> factorials5 = getDigitFactorials(num5);
        long sum5 = factorials5.stream().mapToLong(Long::longValue).sum();
        System.out.println("\nNumber: " + num5);
        System.out.println("Digit factorials: " + factorials5);
        System.out.println("Sum of factorials: " + sum5);
        System.out.println("Is strong number: " + result5);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Problem 2: Convert Binary to Decimal");
        System.out.println("=".repeat(60));
        
        // Test Case 1 - Basic binary
        String binary1 = "1010";
        int result1_dec = binaryToDecimalIterative(binary1);
        int result1_rec = binaryToDecimalRecursive(binary1);
        int result1_builtin = binaryToDecimalBuiltin(binary1);
        System.out.println("Binary: " + binary1);
        System.out.println("Decimal (iterative): " + result1_dec);
        System.out.println("Decimal (recursive): " + result1_rec);
        System.out.println("Decimal (built-in): " + result1_builtin);
        
        // Test Case 2 - Zero
        String binary2 = "0";
        int result2_dec = binaryToDecimalIterative(binary2);
        System.out.println("\nBinary: " + binary2);
        System.out.println("Decimal: " + result2_dec);
        
        // Test Case 3 - Large binary
        String binary3 = "11111111";
        int result3_dec = binaryToDecimalIterative(binary3);
        System.out.println("\nBinary: " + binary3);
        System.out.println("Decimal: " + result3_dec);
        
        // Test Case 4 - Binary array
        int[] binary4 = {1, 0, 1, 1, 0, 1};
        int result4_dec = binaryArrayToDecimal(binary4);
        System.out.println("\nBinary (array): " + Arrays.toString(binary4));
        System.out.println("Decimal: " + result4_dec);
        
        // Test Case 5 - Single bit
        String binary5 = "1";
        int result5_dec = binaryToDecimalIterative(binary5);
        System.out.println("\nBinary: " + binary5);
        System.out.println("Decimal: " + result5_dec);
    }
}