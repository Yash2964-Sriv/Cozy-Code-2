/**
 * Basic DSA Problems - Pascal's Triangle
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class Pascals_Triangle {

    // Problem: Generate first numRows of Pascal's triangle.
    // Example: numRows=5 -> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    /**
     * Each row: first and last are 1; middle = prev row [i-1] + prev row [i]
     * Time O(numRows^2), Space O(1) excluding output
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        if (numRows <= 0) return tri;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        tri.add(first);

        for (int r = 1; r < numRows; r++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = tri.get(r - 1);
            row.add(1);
            for (int i = 1; i < r; i++) {
                row.add(prev.get(i - 1) + prev.get(i));
            }
            row.add(1);
            tri.add(row);
        }
        return tri;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Pascal's Triangle");
        System.out.println("=".repeat(60));

        List<List<Integer>> t = generate(5);
        System.out.println("numRows=5:");
        for (List<Integer> row : t) System.out.println(row);

        System.out.println("\nnumRows=1: " + generate(1));
    }
}