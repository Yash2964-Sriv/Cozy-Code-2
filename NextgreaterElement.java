import java.util.HashMap;
import java.util.Map;

/**
 * Basic DSA Problems - One Fundamental Monotonic Stack Question
 * Simple and essential DSA problem for beginners
 */
public class NextgreaterElement {

    // Problem 1: Next Greater Element I
    // nums1's elements are distinct and each appears in nums2 (also distinct).
    // For each x in nums1, find the next greater element y to the right of x in nums2;
    // if none exists, use -1.

    /**
     * Monotonic decreasing stack over nums2 + map from value to next greater
     * Time Complexity: O(n + m) where n = nums2.length, m = nums1.length
     * Space Complexity: O(n)
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Map<Integer, Integer> next = new HashMap<>();
        int[] stack = new int[nums2.length];
        int top = -1;

        for (int x : nums2) {
            while (top >= 0 && x > stack[top]) {
                next.put(stack[top--], x);
            }
            stack[++top] = x;
        }
        while (top >= 0) {
            next.put(stack[top--], -1);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer v = next.get(nums1[i]);
            ans[i] = v != null ? v : -1;
        }
        return ans;
    }

    private static String arrToString(int[] a) {
        if (a == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a[i]);
        }
        return sb.append("]").toString();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Next Greater Element I");
        System.out.println("=".repeat(60));

        int[] n1a = {4, 1, 2};
        int[] n2a = {1, 3, 4, 2};
        System.out.println("sample -> " + arrToString(nextGreaterElement(n1a, n2a)));

        int[] n1b = {2, 4};
        int[] n2b = {1, 2, 3, 4};
        System.out.println("increasing nums2 -> " + arrToString(nextGreaterElement(n1b, n2b)));

        System.out.println("null nums1 -> " + arrToString(nextGreaterElement(null, n2a)));
    }
}