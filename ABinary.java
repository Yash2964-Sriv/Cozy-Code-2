/**
 * Basic DSA Problems - Add Binary
 * Add two binary strings
 */
public class ABinary {

    // Problem: Given two binary strings a and b, return their sum as a binary string.
    // Example: "11" + "1" -> "100", "1010" + "1011" -> "10101"

    /**
     * Add from right with carry. Build result from right to left.
     * Time O(max(n,m)), Space O(max(n,m))
     */
    public static String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) return b != null ? b : "";
        if (b == null || b.isEmpty()) return a;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Add Binary");
        System.out.println("=".repeat(60));

        System.out.println("11 + 1 -> " + addBinary("11", "1"));
        System.out.println("1010 + 1011 -> " + addBinary("1010", "1011"));
        System.out.println("0 + 0 -> " + addBinary("0", "0"));
        System.out.println("1 + 1 -> " + addBinary("1", "1"));
    }
}