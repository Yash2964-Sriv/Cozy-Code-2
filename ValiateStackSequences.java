/**
 * Basic DSA Problems - One Fundamental Stack Simulation Question
 * Simple and essential DSA problem for beginners
 */
public class ValiateStackSequences {

    // Problem 1: Validate Stack Sequences
    // Two integer arrays pushed and popped each have distinct values and the same length.
    // They represent an empty stack: pushed[i] is the value pushed in order,
    // popped[j] shows the order values must be popped.
    // Return true iff popped is a valid pop sequence for that push order.

    /**
     * Simulate pushes; pop from the simulated stack while it matches popped[k]
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static Boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return null;
        }
        if (pushed.length != popped.length) {
            return false;
        }

        int n = pushed.length;
        int[] stack = new int[n];
        int top = -1;
        int k = 0;

        for (int x : pushed) {
            stack[++top] = x;
            while (top >= 0 && stack[top] == popped[k]) {
                top--;
                k++;
            }
        }

        return k == n;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Validate Stack Sequences");
        System.out.println("=".repeat(60));

        int[] p1 = {1, 2, 3, 4, 5};
        int[] o1 = {4, 5, 3, 2, 1};
        System.out.println("valid classic -> " + validateStackSequences(p1, o1));

        int[] o2 = {4, 3, 5, 1, 2};
        System.out.println("invalid order -> " + validateStackSequences(p1, o2));

        int[] p2 = {1, 2, 3};
        int[] o3 = {3, 1, 2};
        System.out.println("cannot interleave -> " + validateStackSequences(p2, o3));

        int[] p3 = {2, 1, 0};
        int[] o4 = {1, 2, 0};
        System.out.println("another valid -> " + validateStackSequences(p3, o4));

        System.out.println("null -> " + validateStackSequences(null, o1));
    }
}