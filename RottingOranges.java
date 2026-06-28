import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Basic DSA Problems - One Fundamental Grid BFS Question
 * Simple and essential DSA problem for beginners
 */
public class RottingOranges {

    // Problem 1: Rotting Oranges
    // 0 empty, 1 fresh, 2 rotten; each minute rotten spreads to 4-neighbor fresh oranges.

    private static boolean rectangular(int[][] g) {
        int n = g[0].length;
        for (int i = 1; i < g.length; i++) {
            if (g[i] == null || g[i].length != n) {
                return false;
            }
        }
        return true;
    }

    private static int[][] copyOf(int[][] grid) {
        int[][] out = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            out[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        return out;
    }

    /**
     * Multi-source BFS; input grid is not modified.
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public static Integer orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return null;
        }
        if (!rectangular(grid)) {
            return null;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] g = copyOf(grid);

        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int v = g[r][c];
                if (v != 0 && v != 1 && v != 2) {
                    return null;
                }
                if (v == 2) {
                    q.offer(new int[] {r, c});
                } else if (v == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int sz = q.size();
            boolean spread = false;
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int[] d : dir) {
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && g[nr][nc] == 1) {
                        g[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[] {nr, nc});
                        spread = true;
                    }
                }
            }
            if (spread) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Rotting Oranges");
        System.out.println("=".repeat(60));

        int[][] a = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("classic 3x3 -> " + orangesRotting(a));

        int[][] b = {{2, 1, 1}, {0, 1, 1}, {1, 0, 0}};
        System.out.println("impossible -> " + orangesRotting(b));

        int[][] c = {{0, 2}};
        System.out.println("no fresh -> " + orangesRotting(c));

        int[][] d = {{1}};
        System.out.println("only fresh -> " + orangesRotting(d));

        System.out.println("null -> " + orangesRotting(null));
    }
}