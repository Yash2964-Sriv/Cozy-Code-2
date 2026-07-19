/**
 * Basic DSA Problems - One Fundamental Constraint / Hashing Question
 * Simple and essential DSA problem for beginners
 */
public class ValiSuoku2 {

    // Problem 1: Valid Sudoku
    // 9x9 board: digits '1'..'9' or '.'; check no repeats in any row, column, or 3x3 box.

    /**
     * Three 9x9 bit-sets as boolean tables for value present in row/col/box index
     * Time Complexity: O(81) = O(1)
     * Space Complexity: O(1) — fixed tables
     */
    public static Boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return null;
        }
        if (board.length != 9) {
            return false;
        }

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            if (board[i] == null || board[i].length != 9) {
                return false;
            }
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (c < '1' || c > '9') {
                    return false;
                }
                int d = c - '1';
                int b = (i / 3) * 3 + (j / 3);
                if (row[i][d] || col[j][d] || box[b][d]) {
                    return false;
                }
                row[i][d] = true;
                col[j][d] = true;
                box[b][d] = true;
            }
        }

        return true;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Valid Sudoku");
        System.out.println("=".repeat(60));

        char[][] ok = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("LeetCode board -> " + isValidSudoku(ok));

        char[][] bad = new char[9][9];
        for (int i = 0; i < 9; i++) {
            java.util.Arrays.fill(bad[i], '.');
        }
        bad[0][0] = '1';
        bad[0][5] = '1';
        System.out.println("dup row -> " + isValidSudoku(bad));

        System.out.println("null -> " + isValidSudoku(null));
    }
}