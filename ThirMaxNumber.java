
/**
 * Basic DSA Problems - Third Maximum Number (LeetCode 414)
 * Return third distinct max, or max if fewer than 3 distinct
 */
public class ThirMaxNumber {

    // Problem: Return 3rd distinct maximum. If < 3 distinct, return max.

    /**
     * Track top 3 distinct. Use Long.MIN_VALUE for empty.
     * Time O(n), Space O(1)
     */
    public static int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int x : nums) {
            if (x == a || x == b || x == c) continue;
            if (x > a) { c = b; b = a; a = x; }
            else if (x > b) { c = b; b = x; }
            else if (x > c) c = x;
        }
        return (int) (c == Long.MIN_VALUE ? a : c);
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Third Maximum Number");
        System.out.println("=".repeat(60));

        System.out.println("[3,2,1] -> " + thirdMax(new int[]{3,2,1}));
        System.out.println("[1,2] -> " + thirdMax(new int[]{1,2}));
        System.out.println("[2,2,3,1] -> " + thirdMax(new int[]{2,2,3,1}));
    }
}