/**
 * Basic DSA Problems - One Fundamental Binary Search Question
 * Simple and essential DSA problem for beginners
 */
public class RoateSorteArray {

    // Problem 1: Search in Rotated Sorted Array
    // nums was sorted ascending then rotated at some pivot; all values are distinct.
    // Return index of target, or -1 if not present.

    /**
     * Binary search; each half is either fully sorted or the other half is
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static Integer search(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Search in Rotated Sorted Array");
        System.out.println("=".repeat(60));

        int[] a = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("target 0 -> " + search(a, 0));
        System.out.println("target 3 -> " + search(a, 3));

        int[] b = {1};
        System.out.println("[1] find 1 -> " + search(b, 1));
        System.out.println("[1] find 0 -> " + search(b, 0));

        int[] c = {5, 1, 3};
        System.out.println("{5,1,3} find 5 -> " + search(c, 5));

        System.out.println("null -> " + search(null, 1));
    }
}