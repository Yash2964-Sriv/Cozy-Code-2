
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Basic DSA Problems - One Fundamental Graph BFS Question
 * Simple and essential DSA problem for beginners
 */
public class KeysandRooms{

    // Problem 1: Keys and Rooms
    // Room i holds keys rooms.get(i); start in room 0 with unlock 0. Visit all rooms?

    /**
     * BFS from room 0; invalid key index -> null.
     * Time Complexity: O(n + total keys)
     * Space Complexity: O(n)
     */
    public static Boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null) {
            return null;
        }
        int n = rooms.size();
        if (n == 0) {
            return null;
        }

        boolean[] seen = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        seen[0] = true;
        q.offer(0);
        int visited = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;
            List<Integer> keys = rooms.get(u);
            if (keys == null) {
                return null;
            }
            for (int v : keys) {
                if (v < 0 || v >= n) {
                    return null;
                }
                if (!seen[v]) {
                    seen[v] = true;
                    q.offer(v);
                }
            }
        }

        return visited == n;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Keys and Rooms");
        System.out.println("=".repeat(60));

        List<List<Integer>> a = new ArrayList<>();
        a.add(Arrays.asList(1));
        a.add(Arrays.asList(2));
        a.add(Arrays.asList(3));
        a.add(new ArrayList<>());
        System.out.println("chain 0->1->2->3 -> " + canVisitAllRooms(a));

        List<List<Integer>> b = new ArrayList<>();
        b.add(Arrays.asList(1, 3));
        b.add(Arrays.asList(3, 0, 1));
        b.add(Arrays.asList(2));
        b.add(Arrays.asList(0));
        System.out.println("with cycle -> " + canVisitAllRooms(b));

        List<List<Integer>> c = new ArrayList<>();
        c.add(Arrays.asList(1));
        c.add(Arrays.asList(2));
        c.add(Arrays.asList(3));
        c.add(Arrays.asList());
        c.add(Arrays.asList(5));
        c.add(Arrays.asList(4));
        System.out.println("cannot reach 5 -> " + canVisitAllRooms(c));

        List<List<Integer>> d = new ArrayList<>();
        d.add(new ArrayList<>());
        System.out.println("single empty room -> " + canVisitAllRooms(d));

        System.out.println("null -> " + canVisitAllRooms(null));
    }
}