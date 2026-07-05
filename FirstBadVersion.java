/**
 * Basic DSA Problems - One Fundamental Binary Search Question
 * Simple and essential DSA problem for beginners
 */
public class FirstBadVersion {

    // Problem 1: First Bad Version
    // Suppose you have n versions [1, 2, ..., n] and you want to find the first bad one.
    // All versions after a bad version are also bad.
    //
    // Use binary search to minimize calls and return the first bad version index.
    //
    // Example:
    // n = 10, firstBad = 4 -> 4

    // Demo stub for local testing.
    private static int demoFirstBad = 4;
    private static boolean isBadVersion(int version) {
        return version >= demoFirstBad;
    }

    /**
     * Binary search on version range
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static Integer firstBadVersion(int n) {
        if (n <= 0) {
            return null;
        }

        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: First Bad Version");
        System.out.println("=".repeat(60));

        demoFirstBad = 4;
        System.out.println("n = 10, firstBad = 4 -> " + firstBadVersion(10));

        demoFirstBad = 1;
        System.out.println("n = 1, firstBad = 1 -> " + firstBadVersion(1));

        demoFirstBad = 7;
        System.out.println("n = 10, firstBad = 7 -> " + firstBadVersion(10));

        System.out.println("n = 0 -> " + firstBadVersion(0));
        System.out.println("n = -5 -> " + firstBadVersion(-5));
    }
}