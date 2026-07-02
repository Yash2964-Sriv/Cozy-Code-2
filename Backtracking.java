
import java.util.ArrayList;
import java.util.List;

/**
 * Basic DSA Problems - One Fundamental Backtracking Question
 * Simple and essential DSA problem for beginners
 */
public class Backtracking {

    // Problem 1: Subsets
    // nums has distinct integers. Return all subsets (the power set), in any order.

    /**
     * DFS: at each index, either skip or take nums[i]; snapshot path into result when deepening
     * Time Complexity: O(n * 2^n)
     * Space Complexity: O(n) recursion stack plus output
     */
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(
            int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Subsets");
        System.out.println("=".repeat(60));

        int[] a = {1, 2, 3};
        System.out.println("[1,2,3] count -> " + subsets(a).size());
        System.out.println("[1,2,3] -> " + subsets(a));

        int[] b = {0};
        System.out.println("[0] -> " + subsets(b));

        System.out.println("null -> " + subsets(null));
    }
}