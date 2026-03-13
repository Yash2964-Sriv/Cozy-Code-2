/**
 * Basic DSA - Remove Element (LeetCode 27)
 * Remove all instances of val in-place, return new length.
 */
#include <iostream>
#include <vector>

int removeElement(std::vector<int>& nums, int val) {
    int w = 0;
    for (int i = 0; i < (int)nums.size(); i++) {
        if (nums[i] != val) nums[w++] = nums[i];
    }
    return w;
}

void print(std::vector<int>& v, int k) {
    std::cout << "[";
    for (int i = 0; i < k; i++) {
        std::cout << v[i];
        if (i + 1 < k) std::cout << ",";
    }
    std::cout << "]\n";
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Remove Element\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {3, 2, 2, 3};
    int k1 = removeElement(a1, 3);
    std::cout << "[3,2,2,3], val=3 -> k=" << k1 << ", nums=";
    print(a1, k1);

    std::vector<int> a2 = {0, 1, 2, 2, 3, 0, 4, 2};
    int k2 = removeElement(a2, 2);
    std::cout << "[0,1,2,2,3,0,4,2], val=2 -> k=" << k2 << "\n";
}