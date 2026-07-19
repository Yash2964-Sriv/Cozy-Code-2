/**
 * Basic DSA - DI String Match (LeetCode 942)
 * Build a permutation of 0..n from pattern S of 'I' (increase) and 'D' (decrease).
 */
#include <iostream>
#include <string>
#include <vector>

std::vector<int> diStringMatch(const std::string& s) {
    int lo = 0;
    int hi = static_cast<int>(s.size());
    std::vector<int> ans;
    ans.reserve(hi + 1);
    for (char c : s) {
        if (c == 'I')
            ans.push_back(lo++);
        else
            ans.push_back(hi--);
    }
    ans.push_back(lo);
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: DI String Match\n";
    std::cout << std::string(60, '=') << "\n";

    auto a1 = diStringMatch("IDID");
    std::cout << "IDID -> ";
    for (size_t i = 0; i < a1.size(); ++i)
        std::cout << (i ? "," : "") << a1[i];
    std::cout << "\n";

    auto a2 = diStringMatch("I");
    std::cout << "I -> ";
    for (size_t i = 0; i < a2.size(); ++i)
        std::cout << (i ? "," : "") << a2[i];
    std::cout << "\n";
}