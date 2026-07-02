/**
 * Basic DSA Problems - One Fundamental Grid Simulation Question
 * Simple and essential DSA problem for beginners
 */
public class BallFall {

    // Problem 1: Where Will the Ball Fall
    // grid[r][c] is 1 (/\) or -1 (\/); a ball drops from each top column.

    private static boolean validGrid(int[][] grid) {
        if (grid[0] == null) {
            return false;
        }
        int n = grid[0].length;
        for (int[] row : grid) {
            if (row == null || row.length != n) {
                return false;
            }
            for (int x : row) {
                if (x != 1 && x != -1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Simulate each drop; ball rolls with adjacent cell or gets stuck (-1).
     * Time Complexity: O(m * n)
     * Space Complexity: O(1) extra besides output
     */
    public static int[] findBall(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }
        if (!validGrid(grid)) {
            return null;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] out = new int[n];

        for (int start = 0; start < n; start++) {
            int col = start;
            for (int r = 0; r < m; r++) {
                int d = grid[r][col];
                if (d == 1) {
                    if (col == n - 1 || grid[r][col + 1] == -1) {
                        col = -1;
                        break;
                    }
                    col++;
                } else {
                    if (col == 0 || grid[r][col - 1] == 1) {
                        col = -1;
                        break;
                    }
                    col--;
                }
            }
            out[start] = col;
        }

        return out;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Where Will the Ball Fall");
        System.out.println("=".repeat(60));

        int[][] a = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        printArr("sample 5x5", findBall(a));

        int[][] b = {{-1}};
        printArr("1x1 [-1]", findBall(b));

        int[][] c = {{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};
        printArr("staggered 6x6", findBall(c));

        System.out.println("null -> " + (findBall(null) == null ? "null" : "error"));
    }

    private static void printArr(String label, int[] arr) {
        if (arr == null) {
            System.out.println(label + " -> null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(label).append(" -> [");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        sb.append(']');
        System.out.println(sb);
    }
}