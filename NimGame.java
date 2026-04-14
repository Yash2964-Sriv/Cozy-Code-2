/**
 * Basic DSA Problems - Nim Game
 * Determine if you can win the Nim game
 */
public class NimGame {

    // Problem: You and friend play Nim. Heap of n stones. Each turn remove 1, 2, or 3 stones.
    // Last to remove wins. You go first. Return true if you can win.
    // Key: You lose when n is divisible by 4 (opponent can always mirror).

    /**
     * Win iff n % 4 != 0. When n % 4 == 0, whatever you take (1,2,3), opponent takes (3,2,1) to leave multiple of 4.
     * Time O(1), Space O(1)
     */
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Nim Game");
        System.out.println("=".repeat(60));

        System.out.println("n=4 -> canWin: " + canWinNim(4));
        System.out.println("n=1 -> canWin: " + canWinNim(1));
        System.out.println("n=5 -> canWin: " + canWinNim(5));
        System.out.println("n=8 -> canWin: " + canWinNim(8));
    }
}


