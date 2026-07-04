/**
 * Basic DSA Problems - One Fundamental Monotonic Stack Question
 * Simple and essential DSA problem for beginners
 */
public class DailyTemperatures {

    // Problem 1: Daily Temperatures
    // Given an array temperatures where temperatures[i] is the temperature on day i,
    // return an array answer where answer[i] is how many days you wait after day i
    // for a warmer day; if there is none, answer[i] is 0.

    /**
     * Monotonic decreasing stack of indices (Awaiting a warmer day)
     * Time Complexity: O(n) — each index pushed and popped at most once
     * Space Complexity: O(n)
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }

        int n = temperatures.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int j = stack[top--];
                answer[j] = i - j;
            }
            stack[++top] = i;
        }

        return answer;
    }

    private static String arrToString(int[] a) {
        if (a == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a[i]);
        }
        return sb.append("]").toString();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Daily Temperatures");
        System.out.println("=".repeat(60));

        int[] t1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("sample -> " + arrToString(dailyTemperatures(t1)));

        int[] t2 = {30, 40, 50, 60};
        System.out.println("strictly rising -> " + arrToString(dailyTemperatures(t2)));

        int[] t3 = {30, 60, 90};
        System.out.println("all warm -> " + arrToString(dailyTemperatures(t3)));

        System.out.println("null -> " + arrToString(dailyTemperatures(null)));
    }
}