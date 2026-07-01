/**
 * Basic DSA Problems - One Fundamental Stack Question
 * Simple and essential DSA problem for beginners
 */
public class AsteroidCollision {

    // Problem 1: Asteroid Collision
    // Each asteroid moves at equal speed; positive = right, negative = left.
    // When two collide, smaller explodes; equal size both explode; larger survives.
    // Return state after all collisions (left-to-right processing).

    /**
     * Stack of surviving asteroids
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return null;
        }

        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int a : asteroids) {
            boolean alive = true;
            while (alive && a < 0 && top >= 0 && stack[top] > 0) {
                if (stack[top] < -a) {
                    top--;
                } else if (stack[top] == -a) {
                    top--;
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if (alive) {
                stack[++top] = a;
            }
        }

        int[] out = new int[top + 1];
        System.arraycopy(stack, 0, out, 0, top + 1);
        return out;
    }

    private static String arrToString(int[] a) {
        if (a == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a[i]);
        }
        return sb.append("]").toString();
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Asteroid Collision");
        System.out.println("=".repeat(60));

        int[] a1 = {5, 10, -5};
        System.out.println("[5,10,-5] -> " + arrToString(asteroidCollision(a1)));

        int[] a2 = {8, -8};
        System.out.println("[8,-8] -> " + arrToString(asteroidCollision(a2)));

        int[] a3 = {10, 2, -5};
        System.out.println("[10,2,-5] -> " + arrToString(asteroidCollision(a3)));

        int[] a4 = {-2, -1, 1, 2};
        System.out.println("[-2,-1,1,2] -> " + arrToString(asteroidCollision(a4)));

        System.out.println("null -> " + arrToString(asteroidCollision(null)));
    }
}