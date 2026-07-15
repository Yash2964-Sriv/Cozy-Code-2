v/**
 * Basic DSA Problems - One Fundamental Dynamic Programming Question
 * Simple and essential DSA problem for beginners
 */
public class P {

    // Problem 1: Climbing Stairs
    // You can climb 1 or 2 steps each time. How many distinct ways to reach the top n (n >= 1)?

    /**
     * Fibonacci: ways(n) = ways(n-1) + ways(n-2); rolling two variables
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Climbing Stairs");
        System.out.println("=".repeat(60));

        System.out.println("n=1 -> " + climbStairs(1));
        System.out.println("n=2 -> " + climbStairs(2));
        System.out.println("n=3 -> " + climbStairs(3));
        System.out.println("n=5 -> " + climbStairs(5));
        System.out.println("n=45 -> " + climbStairs(45));
        System.out.println("n=0 -> " + climbStairs(0));
    }
}