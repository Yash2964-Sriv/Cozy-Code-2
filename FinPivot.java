/**
 * Basic DSA Problems - One Fundamental Prefix Sum Question
 * Simple and essential DSA problem for beginners
 */
public class FinPivot {

    // Problem 1: Find Pivot Index
    // Index i where sum(nums[0..i-1]) == sum(nums[i+1..n-1]). If none, return -1.

    /**
     * Total sum minus left and nums[i] gives right sum
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Integer pivotIndex(int[] nums) {
        if (nums == null) {
            return null;
        }

        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Find Pivot Index");
        System.out.println("=".repeat(60));

        int[] a = {1, 7, 3, 6, 5, 6};
        System.out.println("sample -> " + pivotIndex(a));

        int[] b = {1, 2, 3};
        System.out.println("no pivot -> " + pivotIndex(b));

        int[] c = {2, 1, -1};
        System.out.println("2,1,-1 -> " + pivotIndex(c));

        System.out.println("null -> " + pivotIndex(null));
    }
}