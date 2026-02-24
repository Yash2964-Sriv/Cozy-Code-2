/**
 * Basic DSA Problems - Reshape the Matrix
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class reshape_matrix {

    // Problem: Reshape matrix to r x c (row-major order). If impossible, return original.
    // Example: mat = [[1,2],[3,4]], r=1, c=4 -> [[1,2,3,4]]

    /**
     * Flatten to 1D index: mat[i][j] -> idx = i*cols+j; then row = idx/c, col = idx%c
     * Time O(m*n), Space O(r*c) for result
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null || mat.length == 0) return mat;
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;

        int[][] out = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                out[idx / c][idx % c] = mat[i][j];
            }
        }
        return out;
    }

    static String matStr(int[][] a) {
        return Arrays.deepToString(a);
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Reshape the Matrix");
        System.out.println("=".repeat(60));

        int[][] m1 = { { 1, 2 }, { 3, 4 } };
        System.out.println("Original: " + matStr(m1) + " -> reshape(1,4): " + matStr(matrixReshape(m1, 1, 4)));

        int[][] m2 = { { 1, 2 }, { 3, 4 } };
        System.out.println("Original: " + matStr(m2) + " -> reshape(2,4): " + matStr(matrixReshape(m2, 2, 4)));
    }
}