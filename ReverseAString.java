/**
 * Basic DSA Problems - Reverse a String
 * Reverse a string in-place (char array) or return new reversed string
 */
public class ReverseAString {

    // Problem: Reverse the given string. Two variants: in-place (char array) and return new string.

    /**
     * Reverse char array in-place using two pointers (swap from both ends).
     * Time O(n), Space O(1)
     */
    public static void reverseString(char[] s) {
        if (s == null) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }

    /**
     * Return a new string that is the reverse of the input.
     * Time O(n), Space O(n)
     */
    public static String reverseStringNew(String s) {
        if (s == null) return null;
        char[] arr = s.toCharArray();
        reverseString(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Reverse a String");
        System.out.println("=".repeat(60));

        char[] a = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(a);
        System.out.println("['h','e','l','l','o'] in-place -> " + java.util.Arrays.toString(a));

        System.out.println("\"hello\" -> " + reverseStringNew("hello"));
        System.out.println("\"abc\" -> " + reverseStringNew("abc"));
        System.out.println("\"a\" -> " + reverseStringNew("a"));
    }
}