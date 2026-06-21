/**
 * Basic DSA Problems - One Fundamental String Question
 * Simple and essential DSA problem for beginners
 */
public class LengthOfLastWord {

    // Problem 1: Length of Last Word
    // Given a string s consisting of words and spaces, return the length
    // of the last word in the string.
    //
    // A word is a maximal substring consisting of non-space characters.
    //
    // Example:
    // s = "Hello World" -> 5

    /**
     * Scan backward: skip trailing spaces, then count letters
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Integer lengthOfLastWord(String s) {
        if (s == null) {
            return null;
        }

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Length of Last Word");
        System.out.println("=".repeat(60));

        System.out.println("s = \"Hello World\" -> " + lengthOfLastWord("Hello World"));
        System.out.println("s = \"   fly me   to   the moon  \" -> " + lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("s = \"luffy is still joyboy\" -> " + lengthOfLastWord("luffy is still joyboy"));
        System.out.println("s = \"    \" -> " + lengthOfLastWord("    "));
        System.out.println("s = null -> " + lengthOfLastWord(null));
    }
}