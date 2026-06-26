/**
 * Basic DSA - Next Greater Element II (LeetCode 503)
 * Circular array: for each index, next strictly greater value (may wrap). Monotone decreasing stack, two passes.
 */
#include <iostream>
#include <stack>
#include <vector>

std::vector<int> nextGreaterElements(const std::vector<int>& nums) {
    int n = static_cast<int>(nums.size());
    std::vector<int> res(static_cast<size_t>(n), -1);
    std::stack<int> st;
    for (int i = 0; i < 2 * n; ++i) {
        int idx = i % n;
        while (!st.empty() && nums[static_cast<size_t>(st.top())] < nums[static_cast<size_t>(idx)]) {
            res[static_cast<size_t>(st.top())] = nums[static_cast<size_t>(idx)];
            st.pop();
        }
        if (i < n)
            st.push(idx);
    }
    return res;
}

void printVec(const std::vector<int>& v) {
    std::cout << "[";
    for (size_t i = 0; i < v.size(); ++i) {
        if (i) std::cout << ",";
        std::cout << v[i];
    }
    std::cout << "]\n";
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Next Greater Element II\n";
    std::cout << std::string(60, '=') << "\n";

    printVec(nextGreaterElements({1, 2, 1}));
    printVec(nextGreaterElements({1, 2, 3, 4, 3}));
}