import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Basic DSA Problems - One Fundamental Backtracking Question
 * Simple and essential DSA problem for beginners
 */
public class CombinationSum {

    // Problem 1: Combination Sum
    // Distinct positive candidates; reuse unlimited times; combinations that sum to target.

    /**
     * Sort candidates; DFS with start index so order is non-decreasing in combination
     * Time Complexity: roughly O(2^(target/min)) in worst case
     * Space Complexity: O(target/min) recursion depth
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(
            int[] candidates,
            int remain,
            int start,
            List<Integer> path,
            List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= remain; i++) {
            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Combination Sum");
        System.out.println("=".repeat(60));

        int[] a = {2, 3, 6, 7};
        System.out.println("target 7 -> " + combinationSum(a, 7));

        int[] b = {2, 3, 5};
        System.out.println("target 8 -> " + combinationSum(b, 8));

        System.out.println("null -> " + combinationSum(null, 10));
    }
}