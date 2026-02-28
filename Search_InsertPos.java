/**
 * Basic DSA Problems - Search Insert Position
 * Simple and essential DSA problems for beginners
 */
public class Search_InsertPos {

    // Problem: Given sorted distinct array and target, return index if found; otherwise index where it would be inserted.
    // Example: [1,3,5,6], target=5 -> 2; target=2 -> 1

    /**
     * Binary search; if not found, left is the insert position.
     * Time O(log n), Space O(1)
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Search Insert Position");
        System.out.println("=".repeat(60));

        int[] a = { 1, 3, 5, 6 };
        System.out.println("[1,3,5,6], target=5 -> " + searchInsert(a, 5));
        System.out.println("[1,3,5,6], target=2 -> " + searchInsert(a, 2));
        System.out.println("[1,3,5,6], target=7 -> " + searchInsert(a, 7));
    }
}