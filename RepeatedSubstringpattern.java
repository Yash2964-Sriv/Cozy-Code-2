/**
 * Basic DSA Problems - Repeated Substring Pattern
 * Check if string can be formed by repeating a substring
 */
public class RepeatedSubstringpattern {

    // Problem: Given string s, return true if s can be constructed by taking a substring of it
    // and appending multiple copies of the substring together. Example: "abab" -> true (ab repeated)

    /**
     * If s = sub + sub + ... + sub, then s + s without first and last char contains s
     * Trick: (s + s).substring(1, 2*n-1).contains(s)
     * Time O(n), Space O(n)
     */
    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.isEmpty()) return false;
        String doubled = s + s;
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Repeated Substring Pattern");
        System.out.println("=".repeat(60));

        System.out.println("\"abab\" -> " + repeatedSubstringPattern("abab"));
        System.out.println("\"aba\" -> " + repeatedSubstringPattern("aba"));
        System.out.println("\"abcabcabcabc\" -> " + repeatedSubstringPattern("abcabcabcabc"));
        System.out.println("\"a\" -> " + repeatedSubstringPattern("a"));
    }
}