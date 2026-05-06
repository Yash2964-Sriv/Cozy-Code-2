#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/**
 * Basic DSA Problems - Two More Fundamental Questions
 * Simple and essential DSA problems for beginners
 */

// Problem 1: Fibonacci Sequence
// Generate Fibonacci sequence using both iterative and recursive approaches

/**
 * Generate first n Fibonacci numbers using iterative approach
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
void fibonacciIterative(int n, int* fib) {
    if (n <= 0) {
        return;
    }
    if (n == 1) {
        fib[0] = 0;
        return;
    }
    if (n == 2) {
        fib[0] = 0;
        fib[1] = 1;
        return;
    }
    
    fib[0] = 0;
    fib[1] = 1;
    for (int i = 2; i < n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }
}

/**
 * Get nth Fibonacci number using recursive approach
 * Time Complexity: O(2^n) - exponential
 * Space Complexity: O(n) due to recursion stack
 */
int fibonacciRecursive(int n) {
    if (n <= 0) {
        return -1;
    }
    if (n == 1) {
        return 0;
    }
    if (n == 2) {
        return 1;
    }
    
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

/**
 * Get nth Fibonacci number using iterative approach (optimized)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
int fibonacciNthIterative(int n) {
    if (n <= 0) {
        return -1;
    }
    if (n == 1) {
        return 0;
    }
    if (n == 2) {
        return 1;
    }
    
    int a = 0, b = 1;
    for (int i = 2; i < n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }
    
    return b;
}

// Problem 2: Check if a Number is Palindrome
// Determine whether a number reads the same forwards and backwards

/**
 * Check if a number is palindrome
 * Time Complexity: O(log n) where log is base 10
 * Space Complexity: O(1)
 */
bool isPalindromeNumber(int n) {
    if (n < 0) {
        return false; // Negative numbers are not palindromes
    }
    if (n < 10) {
        return true; // Single digit numbers are palindromes
    }
    
    int original = n;
    long long reversedNum = 0; // Use long long to prevent overflow
    
    while (n > 0) {
        reversedNum = reversedNum * 10 + n % 10;
        n /= 10;
    }
    
    return original == reversedNum;
}

// Helper function to print array
void printArray(int arr[], int size) {
    printf("[");
    for (int i = 0; i < size; i++) {
        printf("%d", arr[i]);
        if (i < size - 1) {
            printf(", ");
        }
    }
    printf("]");
}

// Test cases
int main() {
    printf("============================================================\n");
    printf("Problem 1: Fibonacci Sequence\n");
    printf("============================================================\n");
    
    // Test Case 1 - First 10 Fibonacci numbers
    int n1 = 10;
    int* fib1 = (int*)malloc(n1 * sizeof(int));
    fibonacciIterative(n1, fib1);
    printf("First %d Fibonacci numbers (Iterative): ", n1);
    printArray(fib1, n1);
    printf("\n");
    free(fib1);
    
    // Test Case 2 - First 5 Fibonacci numbers
    int n2 = 5;
    int* fib2 = (int*)malloc(n2 * sizeof(int));
    fibonacciIterative(n2, fib2);
    printf("\nFirst %d Fibonacci numbers (Iterative): ", n2);
    printArray(fib2, n2);
    printf("\n");
    free(fib2);
    
    // Test Case 3 - 7th Fibonacci number (iterative optimized)
    int n3 = 7;
    int fibNth1 = fibonacciNthIterative(n3);
    printf("\n%dth Fibonacci number (Iterative): %d\n", n3, fibNth1);
    
    // Test Case 4 - 7th Fibonacci number (recursive)
    int fibNth2 = fibonacciRecursive(n3);
    printf("%dth Fibonacci number (Recursive): %d\n", n3, fibNth2);
    
    // Test Case 5 - Edge cases
    printf("\n1st Fibonacci number: %d\n", fibonacciNthIterative(1));
    printf("2nd Fibonacci number: %d\n", fibonacciNthIterative(2));
    printf("3rd Fibonacci number: %d\n", fibonacciNthIterative(3));
    
    printf("\n============================================================\n");
    printf("Problem 2: Check if a Number is Palindrome\n");
    printf("============================================================\n");
    
    // Test Case 1 - Palindrome number
    int num1 = 121;
    bool result1 = isPalindromeNumber(num1);
    printf("Number: %d\n", num1);
    printf("Is Palindrome: %s\n\n", result1 ? "true" : "false");
    
    // Test Case 2 - Non-palindrome number
    int num2 = 123;
    bool result2 = isPalindromeNumber(num2);
    printf("Number: %d\n", num2);
    printf("Is Palindrome: %s\n\n", result2 ? "true" : "false");
    
    // Test Case 3 - Single digit
    int num3 = 5;
    bool result3 = isPalindromeNumber(num3);
    printf("Number: %d\n", num3);
    printf("Is Palindrome: %s\n\n", result3 ? "true" : "false");
    
    // Test Case 4 - Palindrome with even digits
    int num4 = 1221;
    bool result4 = isPalindromeNumber(num4);
    printf("Number: %d\n", num4);
    printf("Is Palindrome: %s\n\n", result4 ? "true" : "false");
    
    // Test Case 5 - Large palindrome
    int num5 = 12321;
    bool result5 = isPalindromeNumber(num5);
    printf("Number: %d\n", num5);
    printf("Is Palindrome: %s\n\n", result5 ? "true" : "false");
    
    // Test Case 6 - Negative number
    int num6 = -121;
    bool result6 = isPalindromeNumber(num6);
    printf("Number: %d\n", num6);
    printf("Is Palindrome: %s\n\n", result6 ? "true" : "false");
    
    // Test Case 7 - Number with zeros
    int num7 = 1001;
    bool result7 = isPalindromeNumber(num7);
    printf("Number: %d\n", num7);
    printf("Is Palindrome: %s\n\n", result7 ? "true" : "false");
    
    // Test Case 8 - Non-palindrome
    int num8 = 12345;
    bool result8 = isPalindromeNumber(num8);
    printf("Number: %d\n", num8);
    printf("Is Palindrome: %s\n\n", result8 ? "true" : "false");
    
    return 0;
}