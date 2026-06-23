/**
 * Basic DSA Problems - One Fundamental Hashing Question
 * Simple and essential DSA problem for beginners
 */
public class IsomorphicStrings {

    // Problem 1: Isomorphic Strings
    // Given two strings s and t, determine if they are isomorphic.
    //
    // Two strings are isomorphic if the characters in s can be replaced to get t,
    // with a one-to-one mapping between characters.
    //
    // Example:
    // s = "egg", t = "add" -> true
    // s = "foo", t = "bar" -> false

    /**
     * Track character mappings both directions
     * Time Complexity: O(n)
     * Space Complexity: O(1) for fixed charset
     */
    public static Boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapST[a] != mapTS[b]) {
                return false;
            }

            // Store i + 1 so default 0 still means "unseen"
            mapST[a] = i + 1;
            mapTS[b] = i + 1;
        }

        return true;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Isomorphic Strings");
        System.out.println("=".repeat(60));

        System.out.println("s = \"egg\", t = \"add\" -> " + isIsomorphic("egg", "add"));
        System.out.println("s = \"foo\", t = \"bar\" -> " + isIsomorphic("foo", "bar"));
        System.out.println("s = \"paper\", t = \"title\" -> " + isIsomorphic("paper", "title"));
        System.out.println("s = \"ab\", t = \"aa\" -> " + isIsomorphic("ab", "aa"));
        System.out.println("s = null, t = \"abc\" -> " + isIsomorphic(null, "abc"));
    }
}