/**
 * Basic DSA Problems - Best Time to Buy and Sell Stock
 * Max profit from one buy and one sell
 */
public class BestTimeToBuyAnSellStocks {

    // Problem: Array = daily stock prices. Buy one day, sell later. Return max profit. 0 if none.

    /**
     * Track min price so far; at each day, profit = price - min, update max profit.
     * Time O(n), Space O(1)
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else if (prices[i] - min > profit) profit = prices[i] - min;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Problem: Best Time to Buy and Sell Stock");
        System.out.println("=".repeat(60));

        System.out.println("[7,1,5,3,6,4] -> " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("[7,6,4,3,1] -> " + maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}