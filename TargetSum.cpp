/**
 * Basic DSA - Target Sum (LeetCode 494)
 * Count ways to assign +/- to get target sum.
 */
#include <iostream>
#include <vector>
#include <unordered_map>

int findTargetSumWays(std::vector<int>& nums, int target) {
    std::unordered_map<int, int> dp;
    dp[0] = 1;
    for (int x : nums) {
        std::unordered_map<int, int> next;
        for (auto& p : dp) {
            next[p.first + x] += p.second;
            next[p.first - x] += p.second;
        }
        dp = std::move(next);
    }
    return dp[target];
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Target Sum\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {1, 1, 1, 1, 1};
    std::cout << "[1,1,1,1,1], target=3 -> " << findTargetSumWays(a1, 3) << "\n";

    std::vector<int> a2 = {1};
    std::cout << "[1], target=1 -> " << findTargetSumWays(a2, 1) << "\n";

    std::vector<int> a3 = {1, 0};
    std::cout << "[1,0], target=1 -> " << findTargetSumWays(a3, 1) << "\n";
}