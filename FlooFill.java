import java.util.Arrays;

/**
 * Basic DSA Problems - One Fundamental Grid DFS Question
 * Simple and essential DSA problem for beginners
 */
public class FlooFill {

    // Problem 1: Flood Fill
    // Start at (sr, sc); replace 4-connected pixels equal to the start color with color.

    private static boolean rectangular(int[][] g) {
        int n = g[0].length;
        for (int i = 1; i < g.length; i++) {
            if (g[i] == null || g[i].length != n) {
                return false;
            }
        }
        return true;
    }

    private static int[][] copyOf(int[][] image) {
        int[][] out = new int[image.length][];
        for (int i = 0; i < image.length; i++) {
            out[i] = Arrays.copyOf(image[i], image[i].length);
        }
        return out;
    }

    private static void dfs(int[][] g, int r, int c, int src, int dst, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n || g[r][c] != src) {
            return;
        }
        g[r][c] = dst;
        dfs(g, r + 1, c, src, dst, m, n);
        dfs(g, r - 1, c, src, dst, m, n);
        dfs(g, r, c + 1, src, dst, m, n);
        dfs(g, r, c - 1, src, dst, m, n);
    }

    /**
     * Does not mutate the input image.
     * Time Complexity: O(m * n) worst case
     * Space Complexity: O(m * n) recursion stack worst case
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return null;
        }
        if (!rectangular(image)) {
            return null;
        }

        int m = image.length;
        int n = image[0].length;
        if (sr < 0 || sr >= m || sc < 0 || sc >= n) {
            return null;
        }

        int[][] g = copyOf(image);
        int start = g[sr][sc];
        if (start == color) {
            return g;
        }

        dfs(g, sr, sc, start, color, m, n);
        return g;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Flood Fill");
        System.out.println("=".repeat(60));

        int[][] a =
                new int[][] {
                    {1, 1, 1},
                    {1, 1, 0},
                    {1, 0, 1}
                };
        System.out.println("start (1,1) color 2 ->");
        System.out.println(Arrays.deepToString(floodFill(a, 1, 1, 2)));

        int[][] b = {{0, 0, 0}, {0, 0, 0}};
        System.out.println("all zeros to 0 -> (unchanged)");
        System.out.println(Arrays.deepToString(floodFill(b, 0, 0, 0)));

        int[][] c = {{9}};
        System.out.println("1x1 ->");
        System.out.println(Arrays.deepToString(floodFill(c, 0, 0, 5)));

        System.out.println("null -> " + (floodFill(null, 0, 0, 1) == null ? "null" : "error"));
    }
}