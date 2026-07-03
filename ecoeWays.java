/**
 * Basic DSA Problems - One Fundamental Dynamic Programming Question
 * Simple and essential DSA problem for beginners
 */
public class ecoeWays {

    // Problem 1: Decode Ways
    // Map 'A'..'Z' <-> "1".."26". Count how many ways to decode s (digits only, no leading zeros in parts).

    /**
     * dp[i] = ways for prefix length i+1; rolling two values
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Integer numDecodings(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 1; i < n; i++) {
            int cur = 0;
            int one = s.charAt(i) - '0';
            if (one >= 1) {
                cur += prev1;
            }
            int two = (s.charAt(i - 1) - '0') * 10 + one;
            if (two >= 10 && two <= 26) {
                cur += prev2;
            }
            prev2 = prev1;
            prev1 = cur;
            if (prev1 == 0) {
                return 0;
            }
        }

        return prev1;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Decode Ways");
        System.out.println("=".repeat(60));

        System.out.println("12 -> " + numDecodings("12"));
        System.out.println("226 -> " + numDecodings("226"));
        System.out.println("06 -> " + numDecodings("06"));
        System.out.println("10 -> " + numDecodings("10"));
        System.out.println("null -> " + numDecodings(null));
    }
}