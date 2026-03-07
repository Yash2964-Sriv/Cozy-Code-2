/**
 * Basic DSA - Kth Largest Element in Array (LeetCode 215)
 * Find kth largest element (1-indexed) using quickselect.
 */
#include <iostream>
#include <vector>
#include <algorithm>

int findKthLargest(std::vector<int>& nums, int k) {
    int n = (int)nums.size();
    std::nth_element(nums.begin(), nums.begin() + (n - k), nums.end());
    return nums[n - k];
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Kth Largest Element in an Array\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {3, 2, 1, 5, 6, 4};
    std::cout << "[3,2,1,5,6,4], k=2 -> " << findKthLargest(a1, 2) << "\n";

    std::vector<int> a2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    std::cout << "[3,2,3,1,2,4,5,5,6], k=4 -> " << findKthLargest(a2, 4) << "\n";

    std::vector<int> a3 = {1};
    std::cout << "[1], k=1 -> " << findKthLargest(a3, 1) << "\n";
}