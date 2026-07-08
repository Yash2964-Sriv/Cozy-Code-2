/**
 * Basic DSA - Sliding Window Maximum (LeetCode 239)
 * For each window of size k, max element. Deque stores decreasing candidate indices; drop out-of-window from front.
 */
#include <deque>
#include <iostream>
#include <vector>

std::vector<int> maxSlidingWindow(const std::vector<int>& nums, int k) {
    std::deque<int> dq;
    std::vector<int> out;
    int n = static_cast<int>(nums.size());
    for (int i = 0; i < n; ++i) {
        while (!dq.empty() && dq.front() <= i - k)
            dq.pop_front();
        while (!dq.empty() && nums[static_cast<size_t>(dq.back())] <= nums[static_cast<size_t>(i)])
            dq.pop_back();
        dq.push_back(i);
        if (i >= k - 1)
            out.push_back(nums[static_cast<size_t>(dq.front())]);
    }
    return out;
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
    std::cout << "Problem: Sliding Window Maximum\n";
    std::cout << std::string(60, '=') << "\n";

    printVec(maxSlidingWindow({1, 3, -1, -3, 5, 3, 6, 7}, 3));
    printVec(maxSlidingWindow({1}, 1));
}