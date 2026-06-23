import java.util.ArrayList;
import java.util.List;

/**
 * Basic DSA Problems - One Fundamental Backtracking Question
 * Simple and essential DSA problem for beginners
 */
public class GenerateParenthesis {

    // Problem 1: Generate Parentheses
    // Given n pairs of parentheses, return all well-formed strings of length 2n.

    /**
     * Add '(' while open < n; add ')' while close < open (prefix always valid)
     * Time Complexity: O(4^n / sqrt(n)) Catalan count (amortized over output)
     * Space Complexity: O(n) for recursion and builder
     */
    public static List<String> generateParenthesis(int n) {
        if (n < 0) {
            return null;
        }

        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
            return result;
        }

        dfs(0, 0, n, new StringBuilder(), result);
        return result;
    }

    private static void dfs(int open, int close, int n, StringBuilder sb, List<String> result) {
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            dfs(open + 1, close, n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            dfs(open, close + 1, n, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Generate Parentheses");
        System.out.println("=".repeat(60));

        System.out.println("n=1 -> " + generateParenthesis(1));
        System.out.println("n=2 -> " + generateParenthesis(2));
        System.out.println("n=3 size -> " + generateParenthesis(3).size());
        System.out.println("n=3 -> " + generateParenthesis(3));
        List<String> z = generateParenthesis(0);
        System.out.println("n=0 size -> " + z.size() + " first -> \"" + z.get(0) + "\"");
        System.out.println("n=-1 -> " + generateParenthesis(-1));
    }
}