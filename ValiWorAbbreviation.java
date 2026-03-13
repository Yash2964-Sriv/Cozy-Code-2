/**
 * Basic DSA Problems - Valid Word Abbreviation (LeetCode 408)
 * Check if abbr (e.g. "s10n") validly abbreviates word
 */
public class ValiWorAbbreviation {

    // Problem: word, abbr. abbr can have digits = skip that many chars. No leading zeros.

    /**
     * Two pointers: parse digits from abbr, advance word by that many.
     * Time O(n), Space O(1)
     */
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') return false;
                int n = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j)))
                    n = n * 10 + (abbr.charAt(j++) - '0');
                i += n;
                if (i > word.length()) return false;
            } else {
                if (word.charAt(i++) != abbr.charAt(j++)) return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Valid Word Abbreviation");
        System.out.println("=".repeat(60));

        System.out.println("internationalization, i12iz4n -> " + validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println("apple, a2e -> " + validWordAbbreviation("apple", "a2e"));
    }
}