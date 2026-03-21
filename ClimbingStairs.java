public class Solution {
    public int climbStairs(int n) {
        // Base cases: if there is 1 step, 1 way; 2 steps, 2 ways
        if (n <= 2) {
            return n;
        }

        // waysToReachNMinus2 (step 1) and waysToReachNMinus1 (step 2)
        int twoBack = 1; 
        int oneBack = 2;
        int current = 0;

        // Start from step 3 up to n
        for (int i = 3; i <= n; i++) {
            current = oneBack + twoBack;
            // Shift the "window" forward
            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
