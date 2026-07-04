/**
 * Basic DSA - Contains Duplicate (LeetCode 217)
 * Return true if any integer appears more than once in the array.
 * Time: O(n) average, Space: O(n).
 */
#include <iostream>
#include <unordered_set>
#include <vector>

bool containsDuplicate(const std::vector<int>& nums) {
    std::unordered_set<int> seen;
    for (int x : nums) {
        if (!seen.insert(x).second)
            return true;
    }
    return false;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Contains Duplicate\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[1,2,3,1] -> " << (containsDuplicate({1, 2, 3, 1}) ? "true" : "false") << "\n";
    std::cout << "[1,2,3,4] -> " << (containsDuplicate({1, 2, 3, 4}) ? "true" : "false") << "\n";
    std::cout << "[1,1,1,3,3,4,3,2,4,2] -> "
              << (containsDuplicate({1, 1, 1, 3, 3, 4, 3, 2, 4, 2}) ? "true" : "false") << "\n";
}