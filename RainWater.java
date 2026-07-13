/**
 * Basic DSA Problems - One Fundamental Two Pointer Question
 * Simple and essential DSA problem for beginners
 */
public class RainWater {

    // Problem 1: Trapping Rain Water
    // elevation map height[i] is bar width 1. Compute how much water can be trapped after raining.

    /**
     * Two pointers with running max from left and right
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Integer trap(int[] height) {
        if (height == null) {
            return null;
        }

        int n = height.length;
        if (n < 3) {
            return 0;
        }

        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Trapping Rain Water");
        System.out.println("=".repeat(60));

        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("classic -> " + trap(a));

        int[] b = {4, 2, 0, 3, 2, 5};
        System.out.println("[4,2,0,3,2,5] -> " + trap(b));

        int[] c = {3, 0, 2};
        System.out.println("[3,0,2] -> " + trap(c));

        int[] d = {5, 4, 3, 2};
        System.out.println("descending -> " + trap(d));

        System.out.println("null -> " + trap(null));
    }
}