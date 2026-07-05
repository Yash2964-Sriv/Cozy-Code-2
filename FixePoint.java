/**
 * Basic DSA Problems - One Fundamental Binary Search Question
 * Simple and essential DSA problem for beginners
 */
public class FixePoint {

    // Problem 1: Fixed Point in a Sorted Array (distinct values, sorted ascending)
    // Index i is a fixed point if arr[i] == i.

    /**
     * If arr[mid] < mid, arr[j] < j for all j <= mid (values jump by at least 1), search right.
     * If arr[mid] > mid, search left.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static Integer fixedPoint(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int v = arr[mid];
            if (v == mid) {
                return mid;
            }
            if (v < mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return null;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Fixed Point in a Sorted Array");
        System.out.println("=".repeat(60));

        int[] a = {-10, -5, 0, 3, 7};
        System.out.println("[-10,-5,0,3,7] -> " + fixedPoint(a));

        int[] b = {0, 2, 5, 8, 17};
        System.out.println("[0,2,5,8,17] -> " + fixedPoint(b));

        int[] c = {-10, -5, 3, 4, 7, 9};
        System.out.println("[-10,-5,3,4,7,9] -> " + fixedPoint(c));

        int[] d = {1, 2, 4, 5};
        System.out.println("[1,2,4,5] (none) -> " + fixedPoint(d));

        System.out.println("null -> " + fixedPoint(null));
        System.out.println("empty -> " + fixedPoint(new int[0]));
    }
}