/**
 * Basic DSA Problems - Maximum Subarray Sum (Kadane's Algorithm)
 * Simple and essential DSA problems for beginners
 */
public class Kadanes_Algo {

    // Problem: Find the contiguous subarray with the largest sum.
    // Example: [-2,1,-3,4,-1,2,1,-5,4] -> 6 (subarray [4,-1,2,1])

    /**
     * Kadane's algorithm: track current sum and max sum.
     * Time O(n), Space O(1)
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Maximum Subarray Sum");
        System.out.println("=".repeat(60));

        int[] a1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("[-2,1,-3,4,-1,2,1,-5,4] -> " + maxSubArray(a1));

        int[] a2 = { 1 };
        System.out.println("[1] -> " + maxSubArray(a2));

        int[] a3 = { 5, 4, -1, 7, 8 };
        System.out.println("[5,4,-1,7,8] -> " + maxSubArray(a3));
    }
}