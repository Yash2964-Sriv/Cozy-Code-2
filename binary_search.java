/**
 * Basic DSA Problems - Binary Search
 * Simple and essential DSA problems for beginners
 */
public class binary_search {

    // Problem: Find index of target in sorted array, or -1 if not present.
    // Example: nums = [1,3,5,7], target = 5 -> 2

    /**
     * Classic binary search on sorted array.
     * Time O(log n), Space O(1)
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Binary Search");
        System.out.println("=".repeat(60));

        int[] a = { 1, 3, 5, 7, 9 };
        System.out.println("[1,3,5,7,9], target=5 -> " + binarySearch(a, 5));
        System.out.println("[1,3,5,7,9], target=2 -> " + binarySearch(a, 2));
        System.out.println("[1,3,5,7,9], target=9 -> " + binarySearch(a, 9));
    }
}