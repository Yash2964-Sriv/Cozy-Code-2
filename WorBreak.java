import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Basic DSA Problems - One Fundamental Dynamic Programming Question
 * Simple and essential DSA problem for beginners
 */
public class WorBreak {

    // Problem 1: Word Break
    // Can s be split into spaced words, each appearing in wordDict (reuse allowed)?

    /**
     * dp[i] = true iff prefix s[0..i) can be segmented
     * Time Complexity: O(n^2 * n) substring = O(n^3) naive; acceptable for small n in demos
     * Space Complexity: O(n)
     */
    public static Boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            return null;
        }

        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Word Break");
        System.out.println("=".repeat(60));

        System.out.println(
                "leetcode -> "
                        + wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(
                "applepenapple -> "
                        + wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(
                "catsandog -> "
                        + wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println("null s -> " + wordBreak(null, List.of("a")));
    }
}