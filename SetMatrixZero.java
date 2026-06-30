/**
 * Basic DSA Problems - One Fundamental Matrix Question
 * Simple and essential DSA problem for beginners
 */
public class SetMatrixZero {

    // Problem 1: Set Matrix Zeroes
    // If an element is 0, set its whole row and column to 0. Return a new matrix.

    /**
     * First pass: mark rows/columns that must be zeroed; second pass: fill result
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n) for markers
     */
    public static int[][] setZeroes(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int m = matrix.length;
        if (m == 0) {
            return new int[0][];
        }
        int n = matrix[0].length;

        boolean[] zeroRow = new boolean[m];
        boolean[] zeroCol = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        int[][] out = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                out[i][j] = (zeroRow[i] || zeroCol[j]) ? 0 : matrix[i][j];
            }
        }
        return out;
    }

    private static String matrixToString(int[][] m) {
        if (m == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < m.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("[");
            for (int j = 0; j < m[i].length; j++) {
                if (j > 0) {
                    sb.append(", ");
                }
                sb.append(m[i][j]);
            }
            sb.append("]");
        }
        return sb.append("]").toString();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Set Matrix Zeroes");
        System.out.println("=".repeat(60));

        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("sample -> " + matrixToString(setZeroes(a)));

        int[][] b = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("two zeros -> " + matrixToString(setZeroes(b)));

        System.out.println("original a[0][0] still 1 -> " + (a[0][0] == 1));
        System.out.println("null -> " + matrixToString(setZeroes(null)));
    }
}