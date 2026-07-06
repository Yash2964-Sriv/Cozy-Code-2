/**
 * Basic DSA Problems - One Fundamental Binary Search Question
 * Simple and essential DSA problem for beginners
 */
public class BinarySearchQues {

    // Problem 1: Sqrt(x)
    // Return the integer part of the non-negative square root of x (truncate).

    /**
     * Binary search on answer in [0, x/2] (for x >= 2); compare mid*mid with x using long
     * Time Complexity: O(log x)
     * Space Complexity: O(1)
     */
    public static int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x < 2) {
            return x;
        }

        long lo = 1;
        long hi = x / 2L;
        long ans = 1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            }
            if (sq < x) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return (int) ans;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Integer Square Root");
        System.out.println("=".repeat(60));

        System.out.println("8 -> " + mySqrt(8));
        System.out.println("4 -> " + mySqrt(4));
        System.out.println("0 -> " + mySqrt(0));
        System.out.println("2147395599 -> " + mySqrt(2147395599));
        System.out.println("-3 -> " + mySqrt(-3));
    }
}