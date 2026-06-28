import java.util.Arrays;

/**
 * Basic DSA Problems - One Fundamental Prefix Sum Question
 * Simple and essential DSA problem for beginners
 */
public class RunningSum {

    // Problem 1: Running Sum of 1d Array
    // runningSum[i] = nums[0] + ... + nums[i].

    /**
     * Single pass cumulative sum into new array
     * Time Complexity: O(n)
     * Space Complexity: O(n) for output (O(1) extra besides that)
     */
    public static int[] runningSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }

        int[] out = new int[nums.length];
        out[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            out[i] = out[i - 1] + nums[i];
        }
        return out;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Running Sum of 1d Array");
        System.out.println("=".repeat(60));

        int[] a = {1, 2, 3, 4};
        System.out.println("[1,2,3,4] -> " + Arrays.toString(runningSum(a)));

        int[] b = {1, 1, 1, 1, 1};
        System.out.println("[1,1,1,1,1] -> " + Arrays.toString(runningSum(b)));

        int[] z = runningSum(null);
        System.out.println("null -> " + (z == null ? "null" : Arrays.toString(z)));
    }
}