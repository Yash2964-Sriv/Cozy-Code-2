/**
 * Basic DSA Problems - Valid Parentheses
 * Check if string has matching brackets: (), [], {}
 */
import java.util.*;

public class ValiParenthesis {

    // Problem: Given string s containing only '()', '[]', '{}', determine if input is valid.
    // Valid = open brackets closed by same type in correct order.

    /**
     * Stack: push opening; on closing, pop and check match. Final stack must be empty.
     * Time O(n), Space O(n)
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') || (c == ']' && open != '[') || (c == '}' && open != '{'))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Valid Parentheses");
        System.out.println("=".repeat(60));

        System.out.println("\"()\" -> " + isValid("()"));
        System.out.println("\"()[]{}\" -> " + isValid("()[]{}"));
        System.out.println("\"(]\" -> " + isValid("(]"));
    }
}