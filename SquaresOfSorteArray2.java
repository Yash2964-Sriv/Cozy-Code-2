/**
 * Basic DSA Problems - One Fundamental Two-Pointer Question
 * Simple and essential DSA problem for beginners
 */
public class SquaresOfSorteArray2 {

    // Problem 1: Squares of a Sorted Array
    // Given an integer array nums sorted in non-decreasing order, return an array of the squares
    // of each number sorted in non-decreasing order.
    //
    // Example:
    // nums = [-4,-1,0,3,10] -> [0,1,9,16,100]

    /**
     * Two pointers from both ends (largest absolute values are at the ends)
     * Time Complexity: O(n)
     * Space Complexity: O(n) for the output array
     */
    public static int[] sortedSquares(int[] nums) {
        if (nums == null) {
            return null;
        }

        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int k = n - 1;

        while (left <= right) {
            long leftSq = (long) nums[left] * nums[left];
            long rightSq = (long) nums[right] * nums[right];

            if (leftSq >= rightSq) {
                result[k--] = (int) leftSq;
                left++;
            } else {
                result[k--] = (int) rightSq;
                right--;
            }
        }

        return result;
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
        System.out.println("Problem 1: Squares of a Sorted Array");
        System.out.println("=".repeat(60));

        int[] a1 = {-4, -1, 0, 3, 10};
        System.out.println("Input : " + arrayToString(a1));
        System.out.println("Output: " + arrayToString(sortedSquares(a1)));

        int[] a2 = {-7, -3, 2, 3, 11};
        System.out.println("\nInput : " + arrayToString(a2));
        System.out.println("Output: " + arrayToString(sortedSquares(a2)));

        int[] a3 = {1, 2, 3};
        System.out.println("\nInput : " + arrayToString(a3));
        System.out.println("Output: " + arrayToString(sortedSquares(a3)));

        int[] a4 = {-5};
        System.out.println("\nInput : " + arrayToString(a4));
        System.out.println("Output: " + arrayToString(sortedSquares(a4)));

        int[] a5 = {};
        System.out.println("\nInput : " + arrayToString(a5));
        System.out.println("Output: " + arrayToString(sortedSquares(a5)));

        System.out.println("\nInput : null");
        System.out.println("Output: " + arrayToString(sortedSquares(null)));
    }
}