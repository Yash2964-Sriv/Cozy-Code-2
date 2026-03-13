/**
 * Basic DSA - Counting Bits (LeetCode 338)
 * Return array where ans[i] = number of 1s in binary of i.
 */
#include <iostream>
#include <vector>

std::vector<int> countBits(int n) {
    std::vector<int> ans(n + 1, 0);
    for (int i = 1; i <= n; i++)
        ans[i] = ans[i >> 1] + (i & 1);
    return ans;
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
    std::cout << "Problem: Counting Bits\n";
    std::cout << std::string(60, '=') << "\n";

    auto r1 = countBits(2);
    std::cout << "n=2 -> ";
    print(r1);

    auto r2 = countBits(5);
    std::cout << "n=5 -> ";
    print(r2);
}