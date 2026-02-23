
/**
 * Basic DSA Problems - Complement of Base 10 Integer
 * Simple and essential DSA problems for beginners
 */
public class countsetbits {

    // Problem: Find the complement of a base 10 integer
    // The complement flips each bit (0->1, 1->0) in the binary representation.
    // Only flip bits up to the highest set bit (no leading zeros).
    // Example: 5 = 101 -> 010 = 2; 7 = 111 -> 000 = 0

    /**
     * Get complement by XOR with mask of all 1s (same bit length as n)
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int bitwiseComplement(int n) {
        if (n == 0) return 1;  // 0 -> 1
        int mask = 1;
        while (mask < n) mask = (mask << 1) | 1;
        return n ^ mask;
    }

    /**
     * Alternative: build mask using highestOneBit
     */
    public static int bitwiseComplementAlt(int n) {
        if (n == 0) return 1;
        int mask = (Integer.highestOneBit(n) << 1) - 1;
        return n ^ mask;
    }

    /**
     * Get binary string of n and its complement for display
     */
    public static String toBinaryWithPadding(int n, int width) {
        String s = Integer.toBinaryString(n);
        while (s.length() < width) s = "0" + s;
        return s;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Complement of Base 10 Integer");
        System.out.println("=".repeat(60));

        // Test 1: 5 -> 2
        int n1 = 5;
        int c1 = bitwiseComplement(n1);
        System.out.println("Number: " + n1 + " (" + Integer.toBinaryString(n1) + ") -> complement: " + c1 + " (" + Integer.toBinaryString(c1) + ")");

        // Test 2: 7 -> 0
        int n2 = 7;
        int c2 = bitwiseComplement(n2);
        System.out.println("\nNumber: " + n2 + " (111) -> complement: " + c2);

        // Test 3: 10 -> 5
        int n3 = 10;
        int c3 = bitwiseComplement(n3);
        System.out.println("\nNumber: " + n3 + " (1010) -> complement: " + c3 + " (0101)");

        // Test 4: 0 -> 1
        int n4 = 0;
        int c4 = bitwiseComplement(n4);
        System.out.println("\nNumber: " + n4 + " -> complement: " + c4);

        // Test 5: 1 -> 0
        int n5 = 1;
        int c5 = bitwiseComplement(n5);
        System.out.println("\nNumber: " + n5 + " -> complement: " + c5);

        // Test 6: Verify both methods
        int n6 = 21;  // 10101 -> 01010 = 10
        System.out.println("\nNumber: " + n6 + " -> complement (method1): " + bitwiseComplement(n6) + ", (method2): " + bitwiseComplementAlt(n6));
    }
}
