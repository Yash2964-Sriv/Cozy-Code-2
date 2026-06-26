/**
 * Basic DSA Problems - One Fundamental Bit Manipulation Question
 * Simple and essential DSA problem for beginners
 */
public class NoOf1Bits {

    // Problem 1: Number of 1 Bits
    // Given an unsigned integer n, return how many '1' bits it has (Hamming weight).
    //
    // Example:
    // n = 11 (binary ...1011) -> 3

    /**
     * Clear lowest set bit repeatedly: n & (n - 1)
     * Time Complexity: O(number of 1 bits)
     * Space Complexity: O(1)
     */
    public static Integer hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Number of 1 Bits");
        System.out.println("=".repeat(60));

        System.out.println("n = 11 -> " + hammingWeight(11));
        System.out.println("n = 128 -> " + hammingWeight(128));
        System.out.println("n = 0 -> " + hammingWeight(0));
        System.out.println("n = -1 -> " + hammingWeight(-1));
    }
}