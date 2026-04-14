/**
 * Basic DSA Problems - Self Dividing Numbers
 * A number is self-dividing if divisible by each of its digits (no zero digits)
 */
import java.util.ArrayList;
import java.util.List;

public class SelfivingNumber {

    // Problem: A self-dividing number is divisible by every digit it contains. No zero digits.
    // Example: 128 is self-dividing (128 % 1 == 0, 128 % 2 == 0, 128 % 8 == 0). 11 is not (11 % 1 ok, but 11 % 1 ok - actually 11 IS self-dividing).

    /**
     * Check if n is self-dividing
     */
    private static boolean isSelfDividing(int n) {
        int x = n;
        while (x > 0) {
            int d = x % 10;
            if (d == 0 || n % d != 0) return false;
            x /= 10;
        }
        return true;
    }

    /**
     * Return all self-dividing numbers in [left, right]
     * Time O((right-left) * log n), Space O(k)
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Self Dividing Numbers");
        System.out.println("=".repeat(60));

        System.out.println("left=1, right=22 -> " + selfDividingNumbers(1, 22));
        System.out.println("left=47, right=85 -> " + selfDividingNumbers(47, 85));
    }
}