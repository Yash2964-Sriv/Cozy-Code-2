/**
 * Basic DSA Problems - Count Set Bits (Hamming Weight)
 * Simple and essential DSA problems for beginners
 */
public class basic_dsa_fifty_five {
    
    // Problem: Count the number of set bits (1s) in binary representation
    // Also known as Hamming Weight or population count
    // Example: 5 = 101 -> 2 set bits; 7 = 111 -> 3 set bits
    
    /**
     * Count set bits using loop (check each bit)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int countSetBitsLoop(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;  // unsigned right shift for negative numbers
        }
        return count;
    }
    
    /**
     * Count set bits using Brian Kernighan's algorithm
     * n & (n-1) clears the rightmost set bit. Count until n becomes 0.
     * Time Complexity: O(k) where k = number of set bits
     * Space Complexity: O(1)
     */
    public static int countSetBitsKernighan(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    
    /**
     * Using Integer.bitCount (built-in)
     */
    public static int countSetBitsBuiltin(int n) {
        return Integer.bitCount(n);
    }
    
    /**
     * Check if number has exactly k set bits
     */
    public static boolean hasExactlyKSetBits(int n, int k) {
        return countSetBitsKernighan(n) == k;
    }
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Count Set Bits (Hamming Weight)");
        System.out.println("=".repeat(60));
        
        // Test 1: 5 = 101
        int n1 = 5;
        int c1 = countSetBitsKernighan(n1);
        System.out.println("Number: " + n1 + " (" + Integer.toBinaryString(n1) + ") -> " + c1 + " set bits");
        
        // Test 2: 7 = 111
        int n2 = 7;
        int c2 = countSetBitsKernighan(n2);
        System.out.println("\nNumber: " + n2 + " (" + Integer.toBinaryString(n2) + ") -> " + c2 + " set bits");
        
        // Test 3: 0
        int n3 = 0;
        int c3 = countSetBitsKernighan(n3);
        System.out.println("\nNumber: " + n3 + " -> " + c3 + " set bits");
        
        // Test 4: 15 = 1111
        int n4 = 15;
        int c4 = countSetBitsKernighan(n4);
        System.out.println("\nNumber: " + n4 + " (" + Integer.toBinaryString(n4) + ") -> " + c4 + " set bits");
        
        // Test 5: Compare all methods
        int n5 = 255;
        System.out.println("\nNumber: " + n5 + " -> Loop: " + countSetBitsLoop(n5) + 
            ", Kernighan: " + countSetBitsKernighan(n5) + ", Builtin: " + countSetBitsBuiltin(n5));
        
        // Test 6: Has exactly 3 set bits
        int n6 = 11;  // 1011
        boolean has3 = hasExactlyKSetBits(n6, 3);
        System.out.println("\nNumber: " + n6 + " has exactly 3 set bits: " + has3);
    }
}