/**
 * Basic DSA - Coin Change (LeetCode 322)
 * Min coins to make amount (or -1 if impossible).
 */
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

int coinChange(std::vector<int>& coins, int amount) {
    std::vector<int> dp(amount + 1, amount + 1);
    dp[0] = 0;
    for (int a = 1; a <= amount; a++)
        for (int c : coins)
            if (c <= a) dp[a] = std::min(dp[a], 1 + dp[a - c]);
    return dp[amount] > amount ? -1 : dp[amount];
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Coin Change\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> c1 = {1, 2, 5};
    std::cout << "coins=[1,2,5], amount=11 -> " << coinChange(c1, 11) << "\n";

    std::vector<int> c2 = {2};
    std::cout << "coins=[2], amount=3 -> " << coinChange(c2, 3) << "\n";

    std::vector<int> c3 = {1};
    std::cout << "coins=[1], amount=0 -> " << coinChange(c3, 0) << "\n";
}