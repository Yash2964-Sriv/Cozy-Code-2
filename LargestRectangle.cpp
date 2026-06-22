/**
 * Basic DSA - Largest Rectangle in Histogram (LeetCode 84)
 * Monotone increasing stack of bar indices; flush with a sentinel height 0 at virtual index n.
 */
#include <algorithm>
#include <iostream>
#include <stack>
#include <vector>

int largestRectangleArea(const std::vector<int>& heights) {
    std::stack<int> st;
    int best = 0;
    int n = static_cast<int>(heights.size());
    for (int i = 0; i <= n; ++i) {
        int h = (i == n) ? 0 : heights[static_cast<size_t>(i)];
        while (!st.empty() && h < heights[static_cast<size_t>(st.top())]) {
            int height = heights[static_cast<size_t>(st.top())];
            st.pop();
            int width = st.empty() ? i : i - st.top() - 1;
            best = std::max(best, height * width);
        }
        st.push(i);
    }
    return best;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Largest Rectangle in Histogram\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[2,1,5,6,2,3] -> " << largestRectangleArea({2, 1, 5, 6, 2, 3}) << "\n";
    std::cout << "[2,4]         -> " << largestRectangleArea({2, 4}) << "\n";
}