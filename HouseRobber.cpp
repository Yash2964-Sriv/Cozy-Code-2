/**
 * Basic DSA - House Robber (LeetCode 198)
 * Max sum of non-adjacent elements.
 */
#include <iostream>
#include <vector>
#include <algorithm>

int rob(std::vector<int>& nums) {
    int prev = 0, cur = 0;
    for (int x : nums) {
        int next = std::max(cur, prev + x);
        prev = cur;
        cur = next;
    }
    return cur;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: House Robber\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {1, 2, 3, 1};
    std::cout << "[1,2,3,1] -> " << rob(a1) << "\n";

    std::vector<int> a2 = {2, 7, 9, 3, 1};
    std::cout << "[2,7,9,3,1] -> " << rob(a2) << "\n";

    std::vector<int> a3 = {2, 1, 1, 2};
    std::cout << "[2,1,1,2] -> " << rob(a3) << "\n";
}