/**
 * Basic DSA - Top K Frequent Elements (LeetCode 347)
 * Return k most frequent elements.
 */
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

std::vector<int> topKFrequent(std::vector<int>& nums, int k) {
    std::unordered_map<int, int> freq;
    for (int x : nums) freq[x]++;
    std::vector<std::pair<int, int>> v(freq.begin(), freq.end());
    std::partial_sort(v.begin(), v.begin() + k, v.end(),
        [](const auto& a, const auto& b) { return a.second > b.second; });
    std::vector<int> out;
    for (int i = 0; i < k; i++) out.push_back(v[i].first);
    return out;
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
    std::cout << "Problem: Top K Frequent Elements\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {1, 1, 1, 2, 2, 3};
    auto r1 = topKFrequent(a1, 2);
    std::cout << "[1,1,1,2,2,3], k=2 -> ";
    print(r1);

    std::vector<int> a2 = {1};
    auto r2 = topKFrequent(a2, 1);
    std::cout << "[1], k=1 -> ";
    print(r2);
}