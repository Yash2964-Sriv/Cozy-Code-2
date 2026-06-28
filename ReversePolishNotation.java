/**
 * Basic DSA Problems - One Fundamental Stack Question
 * Simple and essential DSA problem for beginners
 */
public class ReversePolishNotation {

    // Problem 1: Evaluate Reverse Polish Notation (RPN)
    // tokens[i] is an integer or one of "+", "-", "*", "/".
    // Integer division truncates toward zero.
    // The expression is always valid in RPN.

    /**
     * Operand stack
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Integer evalRPN(String[] tokens) {
        if (tokens == null) {
            return null;
        }

        int[] stack = new int[tokens.length];
        int top = -1;

        for (String t : tokens) {
            if (t == null) {
                return null;
            }
            if (isOperator(t)) {
                if (top < 1) {
                    return null;
                }
                int b = stack[top--];
                int a = stack[top--];
                stack[++top] = apply(a, b, t);
            } else {
                try {
                    stack[++top] = Integer.parseInt(t);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }

        if (top != 0) {
            return null;
        }
        return stack[0];
    }

    private static boolean isOperator(String t) {
        return t.length() == 1 && "+-*/".indexOf(t.charAt(0)) >= 0;
    }

    private static int apply(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Evaluate Reverse Polish Notation");
        System.out.println("=".repeat(60));

        String[] a = {"2", "1", "+", "3", "*"};
        System.out.println("2 1 + 3 * -> " + evalRPN(a));

        String[] b = {"4", "13", "5", "/", "+"};
        System.out.println("4 13 5 / + -> " + evalRPN(b));

        String[] c = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("long expr -> " + evalRPN(c));

        System.out.println("null -> " + evalRPN(null));
    }
}