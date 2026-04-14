
/**
 * Basic DSA - Combination Sum (LeetCode 39)
 * Find all unique combinations that sum to target (reuse allowed).
 */
#include <iostream>
#include <vector>

void backtrack(std::vector<std::vector<int>>& ans, std::vector<int>& cur,
               std::vector<int>& cand, int target, int start) {
    if (target == 0) { ans.push_back(cur); return; }
    if (target < 0) return;
    for (int i = start; i < (int)cand.size(); i++) {
        cur.push_back(cand[i]);
        backtrack(ans, cur, cand, target - cand[i], i);
        cur.pop_back();
    }
}

std::vector<std::vector<int>> combinationSum(std::vector<int>& candidates, int target) {
    std::vector<std::vector<int>> ans;
    std::vector<int> cur;
    backtrack(ans, cur, candidates, target, 0);
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Combination Sum\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> c1 = {2, 3, 6, 7};
    auto r1 = combinationSum(c1, 7);
    std::cout << "[2,3,6,7], target=7 -> ";
    for (auto& v : r1) {
        std::cout << "[";
        for (size_t i = 0; i < v.size(); i++) std::cout << (i ? "," : "") << v[i];
        std::cout << "] ";
    }
    std::cout << "\n";

    std::vector<int> c2 = {2, 3, 5};
    auto r2 = combinationSum(c2, 8);
    std::cout << "[2,3,5], target=8 -> ";
    for (auto& v : r2) {
        std::cout << "[";
        for (size_t i = 0; i < v.size(); i++) std::cout << (i ? "," : "") << v[i];
        std::cout << "] ";
    }
    std::cout << "\n";
}