/**
 * Basic DSA - Move Zeroes (LeetCode 283)
 * Move all zeros to the end in-place.
 */
#include <iostream>
#include <vector>

void moveZeroes(std::vector<int>& nums) {
    int w = 0;
    for (int i = 0; i < (int)nums.size(); i++) {
        if (nums[i] != 0) {
            std::swap(nums[w], nums[i]);
            w++;
        }
    }
}

void print(std::vector<int>& v) {
    std::cout << "[";
    for (size_t i = 0; i < v.size(); i++) {
        std::cout << v[i];
        if (i + 1 < v.size()) std::cout << ",";
    }
    std::cout << "]\n";
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Move Zeroes\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {0, 1, 0, 3, 12};
    moveZeroes(a1);
    std::cout << "[0,1,0,3,12] -> ";
    print(a1);

    std::vector<int> a2 = {0};
    moveZeroes(a2);
    std::cout << "[0] -> ";
    print(a2);
}