/**
 * Basic DSA Problems - One Fundamental Stack Question
 * Simple and essential DSA problem for beginners
 */
public class FundamentalStackQues {
    
    // Problem 1: Valid Parentheses
    // Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    //
    // A string is valid if:
    // 1) Open brackets must be closed by the same type of brackets.
    // 2) Open brackets must be closed in the correct order.
    //
    // Example:
    // Input: "()[]{}" -> true
    // Input: "([)]"   -> false
    
    /**
     * Check if a bracket string is valid using a stack
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean isValidParentheses(String s) {
        if (s == null) {
            return false;
        }
        
        int n = s.length();
        if (n == 0) {
            return true;
        }
        
        // Using a char[] as an explicit stack to avoid extra object overhead
        char[] stack = new char[n];
        int top = -1;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else if (c == ')' || c == '}' || c == ']') {
                if (top < 0) {
                    return false;
                }
                
                char open = stack[top--];
                if ((c == ')' && open != '(') ||
                    (c == '}' && open != '{') ||
                    (c == ']' && open != '[')) {
                    return false;
                }
            } else {
                // If you want to allow other characters, remove this branch.
                // For this problem, treat any non-bracket character as invalid input.
                return false;
            }
        }
        
        return top == -1;
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Valid Parentheses");
        System.out.println("=".repeat(60));
        
        // Test Case 1 - Valid mixed brackets
        String s1 = "()[]{}";
        System.out.println("Input: " + s1);
        System.out.println("Is Valid: " + isValidParentheses(s1));
        
        // Test Case 2 - Invalid order
        String s2 = "([)]";
        System.out.println("\nInput: " + s2);
        System.out.println("Is Valid: " + isValidParentheses(s2));
        
        // Test Case 3 - Valid nested
        String s3 = "{[()()]}";
        System.out.println("\nInput: " + s3);
        System.out.println("Is Valid: " + isValidParentheses(s3));
        
        // Test Case 4 - Missing closing bracket
        String s4 = "(()";
        System.out.println("\nInput: " + s4);
        System.out.println("Is Valid: " + isValidParentheses(s4));
        
        // Test Case 5 - Empty string
        String s5 = "";
        System.out.println("\nInput: " + (s5.isEmpty() ? "\"\"" : s5));
        System.out.println("Is Valid: " + isValidParentheses(s5));
        
        // Test Case 6 - Only closing bracket
        String s6 = "]";
        System.out.println("\nInput: " + s6);
        System.out.println("Is Valid: " + isValidParentheses(s6));
        
        // Test Case 7 - Null
        String s7 = null;
        System.out.println("\nInput: null");
        System.out.println("Is Valid: " + isValidParentheses(s7));
        
        // Test Case 8 - Invalid character
        String s8 = "(a)";
        System.out.println("\nInput: " + s8);
        System.out.println("Is Valid: " + isValidParentheses(s8));
    }
}