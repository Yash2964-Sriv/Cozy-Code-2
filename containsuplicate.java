/**
 * Basic DSA Problems - Contains Duplicate
 * Simple and essential DSA problems for beginners
 */
import java.util.*;

public class containsuplicate {

    // Problem: Return true if array contains any duplicate, else false.
    // Example: [1,2,3,1] -> true, [1,2,3,4] -> false

    /**
     * Use a set; if we see an element again, return true.
     * Time O(n), Space O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Contains Duplicate");
        System.out.println("=".repeat(60));

        System.out.println("[1,2,3,1] -> " + containsDuplicate(new int[] { 1, 2, 3, 1 }));
        System.out.println("[1,2,3,4] -> " + containsDuplicate(new int[] { 1, 2, 3, 4 }));
    }
}