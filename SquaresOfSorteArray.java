/**
 * Basic DSA Problems - Squares of a Sorted Array
 * Simple and essential DSA problems for beginners
 */
public class SquaresOfSorteArray {

    // Problem: Given sorted array (possibly negative), return sorted array of squares.
    // Example: [-4,-1,0,3,10] -> [0,1,9,16,100]

    /**
     * Two pointers from both ends, fill result from the end (largest squares first).
     * Time O(n), Space O(n) for result
     */
    public static int[] sortedSquares(int[] nums) {
        if (nums == null) return null;
        int n = nums.length;
        int[] out = new int[n];
        int i = 0, j = n - 1, k = n - 1;
        while (i <= j) {
            int a = nums[i] * nums[i], b = nums[j] * nums[j];
            if (a >= b) {
                out[k--] = a;
                i++;
            } else {
                out[k--] = b;
                j--;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Squares of a Sorted Array");
        System.out.println("=".repeat(60));

        int[] a = { -4, -1, 0, 3, 10 };
        int[] r = sortedSquares(a);
        System.out.print("[-4,-1,0,3,10] -> [");
        for (int i = 0; i < r.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(r[i]);
        }
        System.out.println("]");
    }
}