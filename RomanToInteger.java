/**
 * Basic DSA Problems - Roman to Integer
 * Convert Roman numeral string to integer
 */
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // Problem: Convert Roman numeral to integer. Roman numerals: I=1, V=5, X=10, L=50, C=100, D=500, M=1000
    // Rule: If smaller value precedes larger, subtract (e.g., IV=4, IX=9, XL=40)

    private static final Map<Character, Integer> ROMAN = new HashMap<>();
    static {
        ROMAN.put('I', 1);   ROMAN.put('V', 5);   ROMAN.put('X', 10);
        ROMAN.put('L', 50);  ROMAN.put('C', 100); ROMAN.put('D', 500);
        ROMAN.put('M', 1000);
    }

    /**
     * Scan left to right. If current < next, subtract current; else add current.
     * Time O(n), Space O(1)
     */
    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = ROMAN.getOrDefault(s.charAt(i), 0);
            int next = (i + 1 < s.length()) ? ROMAN.getOrDefault(s.charAt(i + 1), 0) : 0;
            if (cur < next) sum -= cur;
            else sum += cur;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Roman to Integer");
        System.out.println("=".repeat(60));

        System.out.println("III -> " + romanToInt("III"));
        System.out.println("LVIII -> " + romanToInt("LVIII"));
        System.out.println("MCMXCIV -> " + romanToInt("MCMXCIV"));
        System.out.println("IV -> " + romanToInt("IV"));
        System.out.println("IX -> " + romanToInt("IX"));
    }
}