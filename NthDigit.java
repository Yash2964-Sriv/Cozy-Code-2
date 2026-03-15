/**
 * Basic DSA Problems - Nth Digit (LeetCode 400)
 * nth digit in sequence 1,2,3,4,5,6,7,8,9,10,11,...
 */
public class NthDigit {

    // Problem: Return nth digit (1-indexed) in infinite sequence 1,2,3,...

    /**
     * 1-9: 9 digits. 10-99: 90*2. 100-999: 900*3. Find which range, then digit.
     * Time O(log n), Space O(1)
     */
    public static int findNthDigit(int n) {
        long len = 1, count = 9, start = 1;
        while (n > len * count) {
            n -= (int) (len * count);
            len++;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = String.valueOf(start);
        return s.charAt((int) ((n - 1) % len)) - '0';
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Nth Digit");
        System.out.println("=".repeat(60));

        System.out.println("3 -> " + findNthDigit(3));
        System.out.println("11 -> " + findNthDigit(11));
    }
}