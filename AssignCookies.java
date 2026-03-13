/**
 * Basic DSA Problems - Assign Cookies (LeetCode 455)
 * Maximize content children: assign cookie j to child i if s[j] >= g[i]
 */
public class AssignCookies {

    // Problem: g=greed, s=cookie sizes. At most 1 cookie per child.

    /**
     * Sort both. Two pointers: smallest cookie that satisfies each child.
     * Time O(n log n), Space O(1)
     */
    public static int findContentChildren(int[] g, int[] s) {
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) i++;
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Assign Cookies");
        System.out.println("=".repeat(60));

        System.out.println("g=[1,2,3], s=[1,1] -> " + findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println("g=[1,2], s=[1,2,3] -> " + findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}