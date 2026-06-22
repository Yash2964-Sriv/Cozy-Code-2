
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Basic DSA Problems - One Fundamental Grid BFS Question
 * Simple and essential DSA problem for beginners
 */
public class Matrix01 {

    // Problem 1: 01 Matrix
    // mat[i][j] is 0 or 1; for each cell return Manhattan distance to nearest 0.

    private static boolean rectangular(int[][] g) {
        int n = g[0].length;
        for (int i = 1; i < g.length; i++) {
            if (g[i] == null || g[i].length != n) {
                return false;
            }
        }
        return true;
    }

    /**
     * Multi-source BFS from all zeros. Does not modify mat.
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public static int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) {
            return null;
        }
        if (!rectangular(mat)) {
            return null;
        }

        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE / 4);
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int v = mat[r][c];
                if (v != 0 && v != 1) {
                    return null;
                }
                if (v == 0) {
                    dist[r][c] = 0;
                    q.offer(new int[] {r, c});
                }
            }
        }

        if (q.isEmpty()) {
            return null;
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int d0 = dist[cur[0]][cur[1]];
            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && dist[nr][nc] > d0 + 1) {
                    dist[nr][nc] = d0 + 1;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

        return dist;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: 01 Matrix");
        System.out.println("=".repeat(60));

        int[][] a = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(a)));

        int[][] b = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(updateMatrix(b)));

        int[][] c = {{1, 1}, {1, 0}};
        System.out.println(Arrays.deepToString(updateMatrix(c)));

        System.out.println("all ones -> " + (updateMatrix(new int[][] {{1, 1}, {1, 1}}) == null ? "null" : "err"));

        System.out.println("null -> " + (updateMatrix(null) == null ? "null" : "err"));
    }
}