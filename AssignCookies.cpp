/**
 * Basic DSA - Assign Cookies (LeetCode 455)
 * Assign cookies to children; each child has greed, each cookie has size.
 */
#include <iostream>
#include <vector>
#include <algorithm>

int findContentChildren(std::vector<int>& g, std::vector<int>& s) {
    std::sort(g.begin(), g.end());
    std::sort(s.begin(), s.end());
    int i = 0, j = 0;
    while (i < (int)g.size() && j < (int)s.size()) {
        if (s[j] >= g[i]) { i++; j++; }
        else j++;
    }
    return i;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Assign Cookies\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> g1 = {1, 2, 3};
    std::vector<int> s1 = {1, 1};
    std::cout << "g=[1,2,3], s=[1,1] -> " << findContentChildren(g1, s1) << "\n";

    std::vector<int> g2 = {1, 2};
    std::vector<int> s2 = {1, 2, 3};
    std::cout << "g=[1,2], s=[1,2,3] -> " << findContentChildren(g2, s2) << "\n";

    std::vector<int> g3 = {10, 9, 8, 7};
    std::vector<int> s3 = {5, 6, 7, 8};
    std::cout << "g=[10,9,8,7], s=[5,6,7,8] -> " << findContentChildren(g3, s3) << "\n";
}