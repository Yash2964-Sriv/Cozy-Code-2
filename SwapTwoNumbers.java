/**
 * Basic DSA Problems - Swap Two Numbers Without Temporary Variable
 * Simple and essential DSA problems for beginners
 */
public class SwapTwoNumbers {

    // Problem: Swap two numbers without using a third variable
    // Methods: 1) XOR swap  2) Arithmetic (a+b, a-b)

    /**
     * Swap using XOR: a ^= b; b ^= a; a ^= b;
     * Works for any integer type. No overflow.
     */
    public static int[] swapUsingXOR(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
        return new int[] { a, b };
    }

    /**
     * Swap using arithmetic (addition/subtraction)
     * May overflow for very large numbers
     */
    public static int[] swapUsingArithmetic(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[] { a, b };
    }

    /**
     * Swap using multiplication/division (avoid: division by zero, overflow)
     * Only for non-zero b
     */
    public static int[] swapUsingMultiply(int a, int b) {
        if (b == 0) return new int[] { b, a };
        a = a * b;
        b = a / b;
        a = a / b;
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Swap Two Numbers Without Temp Variable");
        System.out.println("=".repeat(60));

        // Test 1: XOR swap
        int a1 = 5, b1 = 10;
        int[] r1 = swapUsingXOR(a1, b1);
        System.out.println("XOR Swap: (" + a1 + ", " + b1 + ") -> (" + r1[0] + ", " + r1[1] + ")");

        // Test 2: Arithmetic swap
        int a2 = 3, b2 = 7;
        int[] r2 = swapUsingArithmetic(a2, b2);
        System.out.println("\nArithmetic Swap: (" + a2 + ", " + b2 + ") -> (" + r2[0] + ", " + r2[1] + ")");

        // Test 3: Same numbers
        int a3 = 4, b3 = 4;
        int[] r3 = swapUsingXOR(a3, b3);
        System.out.println("\nSame numbers (4, 4) -> (" + r3[0] + ", " + r3[1] + ")");

        // Test 4: Negative numbers
        int a4 = -5, b4 = 3;
        int[] r4 = swapUsingXOR(a4, b4);
        System.out.println("\nNegative: (" + a4 + ", " + b4 + ") -> (" + r4[0] + ", " + r4[1] + ")");

        // Test 5: Multiply swap (6, 2)
        int a5 = 6, b5 = 2;
        int[] r5 = swapUsingMultiply(a5, b5);
        System.out.println("\nMultiply Swap: (6, 2) -> (" + r5[0] + ", " + r5[1] + ")");

        // Test 6: Zero
        int a6 = 0, b6 = 100;
        int[] r6 = swapUsingXOR(a6, b6);
        System.out.println("\nWith zero: (0, 100) -> (" + r6[0] + ", " + r6[1] + ")");
    }
}