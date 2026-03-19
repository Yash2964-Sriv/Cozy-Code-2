/**
 * Basic DSA Problems - Binary Watch (LeetCode 401)
 * turnedOn LEDs: return all valid times "H:MM" (H 0-11, M 0-59)
 */
public class basic_dsa_four_hundred_one {

    // Problem: turnedOn = total lit LEDs. Return list of valid "h:mm" times.

    /**
     * Enumerate h (0-11) and m (0-59). Valid if popcount(h)+popcount(m)==turnedOn.
     * Time O(12*60), Space O(1)
     */
    public static java.util.List<String> readBinaryWatch(int turnedOn) {
        java.util.List<String> out = new java.util.ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
                    out.add(h + ":" + (m < 10 ? "0" : "") + m);
        return out;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Binary Watch");
        System.out.println("=".repeat(60));

        System.out.println("turnedOn=1 -> " + readBinaryWatch(1));
        System.out.println("turnedOn=9 -> " + readBinaryWatch(9));
    }
}