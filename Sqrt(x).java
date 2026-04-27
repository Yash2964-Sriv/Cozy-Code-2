/**
 * Basic DSA Problems - Sqrt(x)
 * Compute integer square root (truncate decimal part)
 */
public class Sqrt(x) {

    // Problem: Given non-negative integer x, return floor(sqrt(x)).
    // Truncate decimal. Example: 4->2, 8->2 (sqrt(8)=2.82, truncate to 2)

    /**
     * Binary search: find largest mid such that mid*mid <= x
     * Time O(log x), Space O(1)
     */
    public static int mySqrt(int x) {
        if (x < 2) return x;
        int lo = 1, hi = x / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sq = (long) mid * mid;
            if (sq == x) return mid;
            if (sq < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return hi;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Sqrt(x)");
        System.out.println("=".repeat(60));

        System.out.println("4 -> " + mySqrt(4));
        System.out.println("8 -> " + mySqrt(8));
        System.out.println("0 -> " + mySqrt(0));
        System.out.println("1 -> " + mySqrt(1));
        System.out.println("2147483647 -> " + mySqrt(2147483647));
    }
}