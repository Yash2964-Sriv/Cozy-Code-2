
import java.util.Arrays;

/**
 * Basic DSA Problems - One Fundamental Sorting and Greedy Question
 * Simple and essential DSA problem for beginners
 */
public class Sorting {

    // Problem 1: Merge Intervals
    // Given intervals [start, end], merge all overlapping intervals.

    /**
     * Sort by start, sweep once extending or starting a new merged interval
     * Time Complexity: O(n log n)
     * Space Complexity: O(n) for the result (or O(log n) sort stack)
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        if (intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;
        int[][] merged = new int[n][2];
        int k = 0;
        merged[k][0] = intervals[0][0];
        merged[k][1] = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= merged[k][1]) {
                merged[k][1] = Math.max(merged[k][1], intervals[i][1]);
            } else {
                k++;
                merged[k][0] = intervals[i][0];
                merged[k][1] = intervals[i][1];
            }
        }

        return Arrays.copyOf(merged, k + 1);
    }

    private static String intervalsToString(int[][] a) {
        if (a == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("[").append(a[i][0]).append(",").append(a[i][1]).append("]");
        }
        return sb.append("]").toString();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Merge Intervals");
        System.out.println("=".repeat(60));

        int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("sample -> " + intervalsToString(merge(a)));

        int[][] b = {{1, 4}, {4, 5}};
        System.out.println("touching -> " + intervalsToString(merge(b)));

        int[][] c = {{4, 7}, {1, 4}};
        System.out.println("unsorted input -> " + intervalsToString(merge(c)));

        System.out.println("empty -> " + intervalsToString(merge(new int[0][])));
        System.out.println("null -> " + intervalsToString(merge(null)));
    }
}