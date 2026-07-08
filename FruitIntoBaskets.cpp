/**
 * Basic DSA - Fruit Into Baskets (LeetCode 904)
 * Longest contiguous subarray using at most two distinct fruit types. Sliding window with frequency map.
 */
#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

int totalFruit(const std::vector<int>& fruits) {
    std::unordered_map<int, int> cnt;
    int left = 0;
    int best = 0;
    int n = static_cast<int>(fruits.size());
    for (int right = 0; right < n; ++right) {
        ++cnt[fruits[static_cast<size_t>(right)]];
        while (static_cast<int>(cnt.size()) > 2) {
            int x = fruits[static_cast<size_t>(left)];
            if (--cnt[x] == 0)
                cnt.erase(x);
            ++left;
        }
        best = std::max(best, right - left + 1);
    }
    return best;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Fruit Into Baskets\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[1,2,1]           -> " << totalFruit({1, 2, 1}) << "\n";
    std::cout << "[0,1,2,2]         -> " << totalFruit({0, 1, 2, 2}) << "\n";
    std::cout << "[1,2,3,2,2]       -> " << totalFruit({1, 2, 3, 2, 2}) << "\n";
}