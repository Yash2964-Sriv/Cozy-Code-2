/**
 * Basic DSA Problems - One Fundamental Binary Search Question
 * Simple and essential DSA problem for beginners
 */
public class ValidPerfectSquare {

    // Problem 1: Valid Perfect Square
    // Given a positive integer num, return true if num is a perfect square or false otherwise.
    //
    // You must not use built-in sqrt functions.
    //
    // Example:
    // num = 16 -> true
    // num = 14 -> false

    /**
     * Binary search on range [1, num]
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static Boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return null;
        }
        if (num == 1) {
            return true;
        }

        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;
            if (sq == num) {
                return true;
            }
            if (sq < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Valid Perfect Square");
        System.out.println("=".repeat(60));

        System.out.println("num = 1 -> " + isPerfectSquare(1));
        System.out.println("num = 16 -> " + isPerfectSquare(16));
        System.out.println("num = 14 -> " + isPerfectSquare(14));
        System.out.println("num = 808201 -> " + isPerfectSquare(808201));
        System.out.println("num = -4 -> " + isPerfectSquare(-4));
        System.out.println("num = 0 -> " + isPerfectSquare(0));
    }
}