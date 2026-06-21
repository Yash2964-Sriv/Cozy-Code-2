import java.util.ArrayList;
import java.util.List;

/**
 * Basic DSA Problems - One Fundamental Backtracking Question
 * Simple and essential DSA problem for beginners
 */
public class LetterCombinationPfPhoneNum {

    // Problem 1: Letter Combinations of a Phone Number
    // digits contains 2-9 only. Return all strings from pressing those keys on old phone pad.

    private static final String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    /**
     * DFS: for each digit, branch on each possible letter
     * Time Complexity: O(4^n * n) worst output size
     * Space Complexity: O(n) for builder and stack
     */
    public static List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }

        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        for (int k = 0; k < digits.length(); k++) {
            char d = digits.charAt(k);
            if (d < '2' || d > '9') {
                return new ArrayList<>();
            }
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits, int i, StringBuilder sb, List<String> result) {
        if (i == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int idx = digits.charAt(i) - '0';
        for (char c : KEYS[idx].toCharArray()) {
            sb.append(c);
            backtrack(digits, i + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Letter Combinations of a Phone Number");
        System.out.println("=".repeat(60));

        System.out.println("\"23\" -> " + letterCombinations("23"));
        System.out.println("\"2\" -> " + letterCombinations("2"));
        System.out.println("\"\" -> " + letterCombinations(""));
        System.out.println("null -> " + letterCombinations(null));
    }
}