  

/**
 * Basic DSA - Sum of Even Numbers After Queries (LeetCode 985)
 * After each query adds val to nums[index], return sum of even values in nums.
 */
#include <iostream>
#include <string>
#include <vector>

std::vector<int> sumEvenAfterQueries(std::vector<int>& nums, const std::vector<std::vector<int>>& queries) {
    int sum = 0;
    for (int x : nums) {
        if (x % 2 == 0)
            sum += x;
    }
    std::vector<int> ans;
    ans.reserve(queries.size());
    for (const auto& q : queries) {
        int idx = q[0];
        int add = q[1];
        if (nums[idx] % 2 == 0)
            sum -= nums[idx];
        nums[idx] += add;
        if (nums[idx] % 2 == 0)
            sum += nums[idx];
        ans.push_back(sum);
    }
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Sum of Even Numbers After Queries\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> n1 = {1};
    std::vector<std::vector<int>> q1 = {{0, 1}};
    auto a1 = sumEvenAfterQueries(n1, q1);
    std::cout << "nums=[1], queries=[[0,1]] -> ";
    for (size_t i = 0; i < a1.size(); ++i)
        std::cout << (i ? "," : "") << a1[i];
    std::cout << "\n";

    std::vector<int> n2 = {1, 2};
    std::vector<std::vector<int>> q2 = {{0, 1}, {1, 1}};
    auto a2 = sumEvenAfterQueries(n2, q2);
    std::cout << "nums=[1,2], queries=[[0,1],[1,1]] -> ";
    for (size_t i = 0; i < a2.size(); ++i)
        std::cout << (i ? "," : "") << a2[i];
    std::cout << "\n";
}