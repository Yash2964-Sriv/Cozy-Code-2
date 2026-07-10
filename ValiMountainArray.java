 /**
 * Basic DSA Problems - One Fundamental Array Question
 * Simple and essential DSA problem for beginners
 */
public class ValiMountainArray {

    // Problem 1: Valid Mountain Array
    // Given an array of integers arr, return true if and only if it is a valid mountain array.
    //
    // A mountain array:
    // 1) Has length >= 3
    // 2) Strictly increases to one peak
    // 3) Strictly decreases after that peak
    //
    // Example:
    // arr = [0,3,2,1] -> true

    /**
     * Two-phase scan: strictly up then strictly down
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Boolean validMountainArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length < 3) {
            return false;
        }

        int i = 0;

        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == arr.length - 1;
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
        System.out.println("Problem 1: Valid Mountain Array");
        System.out.println("=".repeat(60));

        int[] a1 = {0, 3, 2, 1};
        System.out.println("arr = " + arrayToString(a1) + " -> " + validMountainArray(a1));

        int[] a2 = {3, 5, 5};
        System.out.println("arr = " + arrayToString(a2) + " -> " + validMountainArray(a2));

        int[] a3 = {2, 1};
        System.out.println("arr = " + arrayToString(a3) + " -> " + validMountainArray(a3));

        int[] a4 = {0, 1, 2, 3, 4, 5, 6};
        System.out.println("arr = " + arrayToString(a4) + " -> " + validMountainArray(a4));

        System.out.println("arr = null -> " + validMountainArray(null));
    }
}