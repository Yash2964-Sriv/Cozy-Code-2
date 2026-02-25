/**
 * Basic DSA Problems - Rotate Array
 * Simple and essential DSA problems for beginners
 */
public class rotate_array {

    // Problem: Rotate array to the right by k steps (in-place, O(1) extra space).
    // Example: nums = [1,2,3,4,5,6,7], k = 3 -> [5,6,7,1,2,3,4]

    /**
     * Reverse whole array, then reverse first k and last n-k parts.
     * Time O(n), Space O(1)
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Rotate Array");
        System.out.println("=".repeat(60));

        int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(a, 3);
        System.out.print("[1,2,3,4,5,6,7], k=3 -> [");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(a[i]);
        }
        System.out.println("]");
    }
}