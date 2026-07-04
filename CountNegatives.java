/**
 * Basic DSA Problems - One Fundamental Matrix Walk Question
 * Simple and essential DSA problem for beginners
 */
public class CountNegatives {

    // Problem 1: Count Negatives in a Sorted Matrix
    // Each row sorted non-increasing; each column sorted non-increasing.

    private static boolean rectangular(int[][] grid) {
        if (grid[0] == null) {
            return false;
        }
        int m = grid[0].length;
        for (int i = 1; i < grid.length; i++) {
            if (grid[i] == null || grid[i].length != m) {
                return false;
            }
        }
        return true;
    }

    /**
     * Start at bottom-left; move up if negative, else right.
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public static Integer countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        if (!rectangular(grid)) {
            return null;
        }

        int n = grid.length;
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        int count = 0;
        int r = n - 1;
        int c = 0;

        while (r >= 0 && c < m) {
            if (grid[r][c] < 0) {
                count += m - c;
                r--;
            } else {
                c++;
            }
        }

        return count;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Count Negatives in a Sorted Matrix");
        System.out.println("=".repeat(60));

        int[][] a = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };
        System.out.println("4x4 sample -> " + countNegatives(a));

        int[][] b = {{3, 2}, {1, 0}};
        System.out.println("no negatives -> " + countNegatives(b));

        int[][] c = {{5, 1, 0}, {-5, -5, -5}};
        System.out.println("2x3 -> " + countNegatives(c));

        System.out.println("null -> " + countNegatives(null));
        System.out.println("empty col -> " + countNegatives(new int[][] {{}, {}, {}}));
    }
}