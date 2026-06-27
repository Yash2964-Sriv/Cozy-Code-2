/**
 * Basic DSA - Maximum Product of Two Elements in an Array (LeetCode 1464)
 * Choose two distinct indices i, j to maximize (nums[i] - 1) * (nums[j] - 1).
 */
#include <iostream>
#include <vector>

int maxProduct(const std::vector<int>& nums) {
    int first = 0;
    int second = 0;
    for (int x : nums) {
        if (x >= first) {
            second = first;
            first = x;
        } else if (x > second) {
            second = x;
        }
    }
    return (first - 1) * (second - 1);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Maximum Product of Two Elements in an Array\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[3,4,5,2] -> " << maxProduct({3, 4, 5, 2}) << "\n";
    std::cout << "[1,5,4,5] -> " << maxProduct({1, 5, 4, 5}) << "\n";
    std::cout << "[3,7] -> " << maxProduct({3, 7}) << "\n";
}