/**
 * Basic DSA Problems - One Fundamental Bit Manipulation Question
 * Simple and essential DSA problem for beginners
 */
public class HammingWeights1 {

    // Problem 1: Number of 1 Bits (Hamming Weight)
    // Given a 32-bit signed integer n, return how many bits in its binary representation are set to 1.
    // Java uses two's complement; we treat the value as 32 bits using unsigned right shift (>>>).
    //
    // Example:
    // n = 11 (binary ...1011) -> 3
    // n = 128 (binary ...10000000) -> 1

    /**
     * Check each of the 32 bit positions
     * Time Complexity: O(1) — fixed 32 iterations
     * Space Complexity: O(1)
     */
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Number of 1 Bits");
        System.out.println("=".repeat(60));

        System.out.println("n = 11    -> " + hammingWeight(11));
        System.out.println("n = 128   -> " + hammingWeight(128));
        System.out.println("n = 0     -> " + hammingWeight(0));
        System.out.println("n = -1    -> " + hammingWeight(-1));
        System.out.println("n = Integer.MIN_VALUE -> " + hammingWeight(Integer.MIN_VALUE));
    }
}