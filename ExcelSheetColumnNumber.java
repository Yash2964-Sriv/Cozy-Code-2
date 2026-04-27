
/**
 * Basic DSA Problems - Excel Sheet Column Number
 * Convert column title to number (A=1, B=2, ..., Z=26, AA=27)
 */
public class ExcelSheetColumnNumber {

    // Problem: Given column title as in Excel (A, B, ..., Z, AA, AB...), return column number.
    // Example: "A" -> 1, "AB" -> 28, "ZY" -> 701

    /**
     * Process left to right: result = result * 26 + (char - 'A' + 1)
     * Time O(n), Space O(1)
     */
    public static int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.isEmpty()) return 0;
        int num = 0;
        for (char c : columnTitle.toCharArray()) {
            num = num * 26 + (c - 'A' + 1);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Excel Sheet Column Number");
        System.out.println("=".repeat(60));

        System.out.println("A -> " + titleToNumber("A"));
        System.out.println("AB -> " + titleToNumber("AB"));
        System.out.println("ZY -> " + titleToNumber("ZY"));
        System.out.println("FXSHRXW -> " + titleToNumber("FXSHRXW"));
    }
}