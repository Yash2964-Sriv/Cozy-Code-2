
import java.util.ArrayList;
import java.util.List;

/**
 * Basic DSA Problems - One Fundamental Backtracking Question
 * Simple and essential DSA problem for beginners
 */
public class Permutations {
    // Problem 1: Permutations
    // nums has distinct integers. Return all permutations in any order.

    /**
     * DFS: choose each unused element in turn; when path length is n, record a copy
     * Time Complexity: O(n * n!)
     * Space Complexity: O(n) for path, used[], and recursion
     */
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(
            int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Permutations");
        System.out.println("=".repeat(60));

        int[] a = {1, 2, 3};
        List<List<Integer>> p = permute(a);
        System.out.println("[1,2,3] count -> " + p.size());
        System.out.println("[1,2,3] -> " + p);

        int[] b = {0, 1};
        System.out.println("[0,1] -> " + permute(b));

        System.out.println("null -> " + permute(null));
    }
}