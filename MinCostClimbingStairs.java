/**
 * Basic DSA Problems - Min Cost Climbing Stairs
 * Minimum cost to reach top (start from index 0 or 1, step 1 or 2, cost[i] to leave step i)
 */
public class MinCostClimbingStairs {

    // Problem: cost[i] = cost to leave step i. You can start at index 0 or 1, climb 1 or 2 steps.
    // Return minimum cost to reach the top (past the last index).

    /**
     * dp[i] = min cost to reach step i (and leave it). dp[i] = cost[i] + min(dp[i-1], dp[i-2]).
     * Answer is min(dp[n-1], dp[n-2]). Use two variables for O(1) space.
     * Time O(n), Space O(1)
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int a = cost[0], b = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int next = cost[i] + Math.min(a, b);
            a = b;
            b = next;
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Min Cost Climbing Stairs");
        System.out.println("=".repeat(60));

        System.out.println("[10,15,20] -> " + minCostClimbingStairs(new int[] { 10, 15, 20 }));
        System.out.println("[1,100,1,1,1,100,1,1,100,1] -> " + minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
    }
}