import java.util.Arrays;

/**
 * Basic DSA Problems - One Fundamental Binary Search Question
 * Simple and essential DSA problem for beginners
 */
public class SubsequenceWithLimite{

    // Problem 1: Longest Subsequence With Limited Sum
    // Per query, max size of a subsequence of nums with sum <= query (greedy: smallest values first).

    private static int maxCountWithSumAtMost(long[] prefix, int limit) {
        int lo = 0;
        int hi = prefix.length - 1;
        int best = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefix[mid] <= limit) {
                best = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return best;
    }

    /**
     * Sort nums, prefix sums, then for each query binary search largest k with pref[k] <= query.
     * Time Complexity: O(n log n + q log n)
     * Space Complexity: O(n)
     */
    public static int[] answerQueries(int[] nums, int[] queries) {
        if (nums == null || queries == null) {
            return null;
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        long[] pref = new long[sorted.length + 1];
        for (int i = 0; i < sorted.length; i++) {
            pref[i + 1] = pref[i] + sorted[i];
        }

        int[] ans = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            ans[j] = maxCountWithSumAtMost(pref, queries[j]);
        }

        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Longest Subsequence With Limited Sum");
        System.out.println("=".repeat(60));

        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        System.out.println("nums [4,5,2,1], queries [3,10,21] -> "
                + Arrays.toString(answerQueries(nums, queries)));

        int[] a2 = {2, 3, 4, 5};
        int[] q2 = {1};
        System.out.println("[2,3,4,5], queries [1] -> " + Arrays.toString(answerQueries(a2, q2)));

        System.out.println("empty nums -> " + Arrays.toString(answerQueries(new int[0], new int[] {5, 5})));

        int[] q0 = {};
        System.out.println("empty queries -> " + Arrays.toString(answerQueries(nums, q0)));

        int[] z = answerQueries(null, queries);
        System.out.println("null nums -> " + (z == null ? "null" : Arrays.toString(z)));
    }
}