/**
 * Basic DSA - 132 Pattern (LeetCode 456)
 * Triple i < j < k with nums[i] < nums[k] < nums[j]. Scan right-to-left: stack tracks j-candidates, `mid` is best k.
 */
#include <climits>
#include <iostream>
#include <stack>
#include <vector>

bool find132pattern(const std::vector<int>& nums) {
    int mid = INT_MIN;
    std::stack<int> st;
    for (int i = static_cast<int>(nums.size()) - 1; i >= 0; --i) {
        if (nums[static_cast<size_t>(i)] < mid)
            return true;
        while (!st.empty() && nums[static_cast<size_t>(i)] > st.top()) {
            mid = st.top();
            st.pop();
        }
        st.push(nums[static_cast<size_t>(i)]);
    }
    return false;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: 132 Pattern\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[3,1,4,2]     -> " << (find132pattern({3, 1, 4, 2}) ? "true" : "false") << "\n";
    std::cout << "[1,2,3,4]     -> " << (find132pattern({1, 2, 3, 4}) ? "true" : "false") << "\n";
    std::cout << "[3,5,0,3,4]   -> " << (find132pattern({3, 5, 0, 3, 4}) ? "true" : "false") << "\n";
}