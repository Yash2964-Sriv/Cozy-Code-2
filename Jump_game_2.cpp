/**
 * Basic DSA - Jump Game II (LeetCode 45)
 * Minimum number of jumps to reach the last index.
 */
#include <iostream>
#include <vector>
#include <algorithm>

int jump(std::vector<int>& nums) {
    int jumps = 0, curEnd = 0, farthest = 0;
    for (int i = 0; i < (int)nums.size() - 1; i++) {
        farthest = std::max(farthest, i + nums[i]);
        if (i == curEnd) {
            jumps++;
            curEnd = farthest;
        }
    }
    return jumps;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Jump Game II\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {2, 3, 1, 1, 4};
    std::cout << "[2,3,1,1,4] -> " << jump(a1) << "\n";

    std::vector<int> a2 = {2, 3, 0, 1, 4};
    std::cout << "[2,3,0,1,4] -> " << jump(a2) << "\n";

    std::vector<int> a3 = {1, 2, 1, 1, 1};
    std::cout << "[1,2,1,1,1] -> " << jump(a3) << "\n";
}
