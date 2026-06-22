/**
 * Basic DSA Problems - One Fundamental Greedy Question
 * Simple and essential DSA problem for beginners
 */
public class JumpGame {

    // Problem 1: Jump Game
    // nums[i] is max jump length forward from i. Start at index 0.
    // Return true if the last index can be reached.

    /**
     * Track farthest index reachable; fail if current index passes that
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Boolean canJump(int[] nums) {
        if (nums == null) {
            return null;
        }

        int reach = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
            if (reach >= n - 1) {
                return true;
            }
        }

        return true;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Jump Game");
        System.out.println("=".repeat(60));

        int[] a = {2, 3, 1, 1, 4};
        System.out.println("[2,3,1,1,4] -> " + canJump(a));

        int[] b = {3, 2, 1, 0, 4};
        System.out.println("[3,2,1,0,4] -> " + canJump(b));

        int[] c = {0};
        System.out.println("[0] -> " + canJump(c));

        int[] d = {2, 0};
        System.out.println("[2,0] -> " + canJump(d));

        System.out.println("null -> " + canJump(null));
    }
}