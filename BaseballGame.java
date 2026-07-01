/**
 * Basic DSA Problems - One Fundamental Stack Question
 * Simple and essential DSA problem for beginners
 */
public class BaseballGame {

    // Problem 1: Baseball Game
    // You are keeping score in a baseball game. ops[i] is one of:
    // - integer string -> record that score
    // - "+" -> sum of last two scores
    // - "D" -> double the last score
    // - "C" -> invalidate previous score
    //
    // Return sum of all scores on the record after processing ops.

    /**
     * Stack of recorded scores
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Integer calPoints(String[] ops) {
        if (ops == null) {
            return null;
        }

        int[] stack = new int[ops.length];
        int top = -1;

        for (String op : ops) {
            if (op.equals("+")) {
                if (top < 1) {
                    return null;
                }
                int v = stack[top] + stack[top - 1];
                stack[++top] = v;
            } else if (op.equals("D")) {
                if (top < 0) {
                    return null;
                }
                stack[++top] = stack[top - 1] * 2;
            } else if (op.equals("C")) {
                if (top < 0) {
                    return null;
                }
                top--;
            } else {
                try {
                    stack[++top] = Integer.parseInt(op);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= top; i++) {
            sum += stack[i];
        }
        return sum;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Baseball Game");
        System.out.println("=".repeat(60));

        String[] a = {"5", "2", "C", "D", "+"};
        System.out.println("ops sample -> " + calPoints(a));

        String[] b = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("ops longer -> " + calPoints(b));

        System.out.println("null -> " + calPoints(null));
    }
}