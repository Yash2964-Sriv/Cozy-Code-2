/**
 * Basic DSA Problems - One Fundamental Hashing Question
 * Simple and essential DSA problem for beginners
 */
public class RansomNote {

    // Problem 1: Ransom Note
    // Given two strings ransomNote and magazine, return true if ransomNote
    // can be constructed by using the letters from magazine.
    //
    // Each letter in magazine can only be used once.
    //
    // Example:
    // ransomNote = "aa", magazine = "aab" -> true

    /**
     * Frequency counting for lowercase letters
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public static Boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return null;
        }

        int[] freq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (c < 'a' || c > 'z') {
                return null;
            }
            freq[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (c < 'a' || c > 'z') {
                return null;
            }
            if (freq[c - 'a'] == 0) {
                return false;
            }
            freq[c - 'a']--;
        }

        return true;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Ransom Note");
        System.out.println("=".repeat(60));

        System.out.println("ransomNote = \"a\", magazine = \"b\" -> " + canConstruct("a", "b"));
        System.out.println("ransomNote = \"aa\", magazine = \"ab\" -> " + canConstruct("aa", "ab"));
        System.out.println("ransomNote = \"aa\", magazine = \"aab\" -> " + canConstruct("aa", "aab"));
        System.out.println("ransomNote = \"\", magazine = \"abc\" -> " + canConstruct("", "abc"));
        System.out.println("ransomNote = null, magazine = \"abc\" -> " + canConstruct(null, "abc"));
    }
}