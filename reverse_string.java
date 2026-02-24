/**
 * Basic DSA Problems - Reverse a String
 * Simple and essential DSA problems for beginners
 */
public class reverse_string {

    // Problem: Reverse the given string in-place (char array) or return new reversed string.
    // Example: "hello" -> "olleh"

    /**
     * Reverse using two pointers (in-place on char array).
     * Time O(n), Space O(n) for char array
     */
    public static String reverseString(String s) {
        if (s == null) return null;
        char[] a = s.toCharArray();
        int i = 0, j = a.length - 1;
        while (i < j) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Reverse a String");
        System.out.println("=".repeat(60));

        System.out.println("\"hello\" -> \"" + reverseString("hello") + "\"");
        System.out.println("\"abc\" -> \"" + reverseString("abc") + "\"");
        System.out.println("\"a\" -> \"" + reverseString("a") + "\"");
    }
}