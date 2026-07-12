/**
 * Basic DSA Problems - One Fundamental Binary Search Question
 * Simple and essential DSA problem for beginners
 */
public class PeakInexInMountain {

    // Problem 1: Peak Index in a Mountain Array
    // You are given a mountain array arr, where:
    // - arr.length >= 3
    // - There exists i with 0 < i < arr.length - 1 such that:
    //   arr[0] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
    //
    // Return the index i of the peak.
    //
    // Example:
    // arr = [0,2,1,0] -> 1

    /**
     * Binary search on slope direction
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static Integer peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return null;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static String arrayToString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        if (arr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Peak Index in a Mountain Array");
        System.out.println("=".repeat(60));

        int[] a1 = {0, 2, 1, 0};
        System.out.println("arr = " + arrayToString(a1) + " -> " + peakIndexInMountainArray(a1));

        int[] a2 = {0, 10, 5, 2};
        System.out.println("arr = " + arrayToString(a2) + " -> " + peakIndexInMountainArray(a2));

        int[] a3 = {3, 4, 5, 1};
        System.out.println("arr = " + arrayToString(a3) + " -> " + peakIndexInMountainArray(a3));

        int[] a4 = {1, 2};
        System.out.println("arr = " + arrayToString(a4) + " -> " + peakIndexInMountainArray(a4));

        System.out.println("arr = null -> " + peakIndexInMountainArray(null));
    }
}