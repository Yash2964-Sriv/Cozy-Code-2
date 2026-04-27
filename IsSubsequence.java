/**
 * Basic DSA Problems - Is Subsequence
 * Check if s is subsequence of t (order preserved, not necessarily contiguous)
 */
public class IsSubsequence {

    // Problem: Given strings s and t, return true if s is a subsequence of t (s's chars
    // appear in t in same order, not necessarily contiguous).

    /**
     * Two pointers: match s[i] with t[j], advance both on match else only j.
     * Time O(|t|), Space O(1)
     */
    public static boolean isSubsequence(String s, String t) {
        if (s == null) return true;
        if (t == null || s.length() > t.length()) return false;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Is Subsequence");
        System.out.println("=".repeat(60));

        System.out.println("s=\"abc\", t=\"ahbgdc\" -> " + isSubsequence("abc", "ahbgdc"));
        System.out.println("s=\"axc\", t=\"ahbgdc\" -> " + isSubsequence("axc", "ahbgdc"));
    }
}