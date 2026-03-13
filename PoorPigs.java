
/**
 * Basic DSA Problems - Poor Pigs (LeetCode 458)
 * Min pigs to find poisonous bucket. base = rounds per pig = test/die + 1.
 */
public class PoorPigs {

    // Problem: buckets, minutesToDie, minutesToTest. base^pigs >= buckets.

    /**
     * Rounds = test/die + 1. Each pig has base states. Need base^x >= buckets.
     * Time O(log buckets), Space O(1)
     */
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        for (long p = 1; p < buckets; p *= base) pigs++;
        return pigs;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Poor Pigs");
        System.out.println("=".repeat(60));

        System.out.println("4 buckets, 15 die, 15 test -> " + poorPigs(4, 15, 15));
        System.out.println("4 buckets, 15 die, 30 test -> " + poorPigs(4, 15, 30));
        System.out.println("1000 buckets, 15 die, 60 test -> " + poorPigs(1000, 15, 60));
    }
}