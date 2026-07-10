/**
 * Basic DSA - Valid Triangle Number (LeetCode 611)
 * Triplets with positive area: sort, fix largest side c at index k, two-pointer on smaller sides.
 */
#include <algorithm>
#include <iostream>
#include <vector>

int triangleNumber(std::vector<int> nums) {
    std::sort(nums.begin(), nums.end());
    int n = static_cast<int>(nums.size());
    int ans = 0;
    for (int k = n - 1; k >= 2; --k) {
        int i = 0;
        int j = k - 1;
        while (i < j) {
            if (nums[static_cast<size_t>(i)] + nums[static_cast<size_t>(j)] > nums[static_cast<size_t>(k)]) {
                ans += j - i;
                --j;
            } else
                ++i;
        }
    }
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Valid Triangle Number\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[2,2,3,4]     -> " << triangleNumber({2, 2, 3, 4}) << "\n";
    std::cout << "[4,2,3,4]     -> " << triangleNumber({4, 2, 3, 4}) << "\n";
}