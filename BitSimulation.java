
/**
 * Basic DSA Problems - One Fundamental String / Bit Simulation Question
 * Simple and essential DSA problem for beginners
 */
public class BitSimulation {

    // Problem 1: Add Binary
    // Non-negative integers given as binary strings without leading zeros (except "0").

    /**
     * Add from least significant bit with carry
     * Time Complexity: O(max(a.length, b.length))
     * Space Complexity: O(1) besides output
     */
    public static String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Add Binary");
        System.out.println("=".repeat(60));

        System.out.println("11 + 1 -> " + addBinary("11", "1"));
        System.out.println("0 + 0 -> " + addBinary("0", "0"));
        System.out.println("1010 + 1011 -> " + addBinary("1010", "1011"));
        System.out.println("null -> " + addBinary(null, "1"));
    }
}