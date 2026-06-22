/**
 * Basic DSA Problems - One Fundamental Boyer–Moore Voting Question
 * Simple and essential DSA problem for beginners
 */
public class MajorityElement {

    // Problem 1: Majority Element
    // nums length n; some value appears more than floor(n/2) times.
    // Return that majority element.

    /**
     * Boyer–Moore majority vote
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Integer majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int candidate = nums[0];
        int count = 0;

        for (int x : nums) {
            if (count == 0) {
                candidate = x;
            }
            count += (x == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Majority Element");
        System.out.println("=".repeat(60));

        int[] a = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("mixed -> " + majorityElement(a));

        int[] b = {3, 2, 3};
        System.out.println("[3,2,3] -> " + majorityElement(b));

        int[] c = {7};
        System.out.println("[7] -> " + majorityElement(c));

        System.out.println("empty -> " + majorityElement(new int[0]));
        System.out.println("null -> " + majorityElement(null));
    }
}