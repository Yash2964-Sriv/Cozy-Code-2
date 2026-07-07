/**
 * Basic DSA Problems - One Fundamental Greedy Question
 * Simple and essential DSA problem for beginners
 */
public class GasStation2 {

    // Problem 1: Gas Station
    // gas[i] fuel at station i; cost[i] fuel to reach next station (circular).
    // If one can complete the circuit starting at some station, return that index; else -1.

    /**
     * If total gas >= total cost, a start exists; reset candidate when running tank < 0
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Integer canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return null;
        }

        int n = gas.length;
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem 1: Gas Station");
        System.out.println("=".repeat(60));

        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("LeetCode sample -> " + canCompleteCircuit(gas1, cost1));

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("impossible -> " + canCompleteCircuit(gas2, cost2));

        int[] gas3 = {5};
        int[] cost3 = {4};
        System.out.println("single station -> " + canCompleteCircuit(gas3, cost3));

        System.out.println("null -> " + canCompleteCircuit(null, cost1));
    }
}