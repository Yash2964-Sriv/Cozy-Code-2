/**
 * Basic DSA Problems - Lemonade Change
 * Can you give change when customers pay $5, $10, or $20? (bills only)
 */
public class LemonaeChange {

    // Problem: Customers pay $5, $10, or $20. Lemonade costs $5. Start with no bills.
    // Return true if you can give change to every customer (using only $5 and $10 bills).

    /**
     * Track count of $5 and $10. For $10 give one $5; for $20 prefer one $10+one $5, else three $5.
     * Time O(n), Space O(1)
     */
    public static boolean lemonadeChange(int[] bills) {
        if (bills == null) return true;
        int fives = 0, tens = 0;
        for (int b : bills) {
            if (b == 5) fives++;
            else if (b == 10) {
                if (fives == 0) return false;
                fives--;
                tens++;
            } else {
                if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                } else if (fives >= 3) fives -= 3;
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Lemonade Change");
        System.out.println("=".repeat(60));

        System.out.println("[5,5,5,10,20] -> " + lemonadeChange(new int[] { 5, 5, 5, 10, 20 }));
        System.out.println("[5,5,10,10,20] -> " + lemonadeChange(new int[] { 5, 5, 10, 10, 20 }));
    }
}