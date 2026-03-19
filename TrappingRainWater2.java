/**
 * Basic DSA Problems - Trapping Rain Water II (LeetCode 407)
 * Water trapped in 2D height map (4-direction flow)
 */
public class basic_dsa_four_hundred_seven {

    // Problem: m x n height map. Water flows 4 directions. Return trapped volume.

    /**
     * Min-heap from boundary. Process lowest; water level = max(heap_min, height).
     * Time O(m*n*log(m*n)), Space O(m*n)
     */
    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) return 0;
        boolean[][] vis = new boolean[m][n];
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
            vis[i][0] = vis[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
            vis[0][j] = vis[m - 1][j] = true;
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int water = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0], r = cur[1], c = cur[2];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc]) continue;
                vis[nr][nc] = true;
                water += Math.max(0, h - heightMap[nr][nc]);
                pq.offer(new int[]{Math.max(h, heightMap[nr][nc]), nr, nc});
            }
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Trapping Rain Water II");
        System.out.println("=".repeat(60));

        int[][] h = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println("3x6 map -> " + trapRainWater(h));
    }
}