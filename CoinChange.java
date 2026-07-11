import java.util.Arrays;

/**
 * Basic DSA Problems - One Fundamental Dynamic Programming Question
 * Simple and essential DSA problem for beginners
 */
public class CoinChange {

    // Problem 1: Coin Change
    // coins[i] > 0; each coin unlimited. Fewest coins to sum to amount; if impossible return -1.

    /**
     * Unbounded knapsack: dp[x] = min coins for sum x
     * Time Complexity: O(amount * coins.length)
     * Space Complexity: O(amount)
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int x = 1; x <= amount; x++) {
            for (int c : coins) {
                if (c > 0 && c <= x) {
                    dp[x] = Math.min(dp[x], dp[x - c] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Coin Change");
        System.out.println("=".repeat(60));

        int[] a = {1, 2, 5};
        System.out.println("[1,2,5] amount 11 -> " + coinChange(a, 11));

        int[] b = {2};
        System.out.println("[2] amount 3 -> " + coinChange(b, 3));

        int[] c = {1};
        System.out.println("[1] amount 0 -> " + coinChange(c, 0));

        System.out.println("null coins -> " + coinChange(null, 5));
    }
}