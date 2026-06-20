/**
 * Basic DSA Problems - One Fundamental String Question
 * Simple and essential DSA problem for beginners
 */
public class GoatLatin {

    // Problem 1: Goat Latin
    // Rules: If word begins with vowel (a,e,i,o,u), append "ma".
    //        Else, move first letter to end, then append "ma".
    //        Append "a" repeated by 1-index of word to each word.
    // Words are split by single space.
    //
    // Example:
    // "I speak Goat Latin" -> "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

    private static boolean isVowel(char c) {
        char ch = Character.toLowerCase(c);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    /**
     * Token scan and rebuild
     * Time Complexity: O(n + total output length)
     * Space Complexity: O(n) for result
     */
    public static String toGoatLatin(String sentence) {
        if (sentence == null) {
            return null;
        }
        if (sentence.isEmpty()) {
            return "";
        }

        String[] parts = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            String w = parts[i];
            if (w.isEmpty()) {
                continue;
            }
            if (isVowel(w.charAt(0))) {
                sb.append(w);
            } else {
                sb.append(w.substring(1)).append(w.charAt(0));
            }
            sb.append("ma");
            for (int k = 0; k < i + 1; k++) {
                sb.append('a');
            }
        }

        return sb.toString();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Goat Latin");
        System.out.println("=".repeat(60));

        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
        System.out.println("empty -> \"" + toGoatLatin("") + "\"");
        System.out.println("null -> " + toGoatLatin(null));
    }
}