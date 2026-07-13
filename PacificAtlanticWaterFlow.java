/**
 * Basic DSA Problems - Pacific Atlantic Water Flow (LeetCode 417)
 * Cells from which water can reach both Pacific (top/left) and Atlantic (bottom/right)
 */
public class PacificAtlanticWaterFlow {

    // Problem: heights. Water flows to lower/equal. Find cells reaching both oceans.

    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    /**
     * DFS from Pacific (top, left) and Atlantic (bottom, right). Intersection.
     * Time O(m*n), Space O(m*n)
     */
    public static java.util.List<java.util.List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0, m, n);
            dfs(heights, atl, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j, m, n);
            dfs(heights, atl, m - 1, j, m, n);
        }
        java.util.List<java.util.List<Integer>> out = new java.util.ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pac[i][j] && atl[i][j]) out.add(java.util.Arrays.asList(i, j));
        return out;
    }

    private static void dfs(int[][] h, boolean[][] vis, int r, int c, int m, int n) {
        vis[r][c] = true;
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && h[nr][nc] >= h[r][c])
                dfs(h, vis, nr, nc, m, n);
        }
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Pacific Atlantic Water Flow");
        System.out.println("=".repeat(60));

        int[][] h = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println("5x5 -> " + pacificAtlantic(h));
    }
}