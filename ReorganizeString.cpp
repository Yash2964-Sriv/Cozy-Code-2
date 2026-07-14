/**
 * Basic DSA - Reorganize String (LeetCode 767)
 * Rearrange so no two adjacent chars match. Greedy: max-heap by remaining count; cooldown previous char one step.
 */
#include <iostream>
#include <queue>
#include <string>
#include <utility>
#include <vector>

std::string reorganizeString(const std::string& s) {
    std::vector<int> cnt(26, 0);
    for (char c : s)
        ++cnt[static_cast<size_t>(c - 'a')];
    std::priority_queue<std::pair<int, char>> pq;
    for (int i = 0; i < 26; ++i) {
        if (cnt[static_cast<size_t>(i)])
            pq.push({cnt[static_cast<size_t>(i)], static_cast<char>('a' + i)});
    }
    std::string res;
    std::pair<int, char> prev = {0, '#'};
    while (!pq.empty()) {
        std::pair<int, char> cur = pq.top();
        pq.pop();
        res.push_back(cur.second);
        if (prev.first > 0)
            pq.push(prev);
        prev = {cur.first - 1, cur.second};
    }
    return res.size() == s.size() ? res : "";
}

bool noAdjacentEqual(const std::string& t) {
    for (size_t i = 1; i < t.size(); ++i) {
        if (t[i] == t[i - 1])
            return false;
    }
    return true;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Reorganize String\n";
    std::cout << std::string(60, '=') << "\n";

    std::string a = reorganizeString("aab");
    std::cout << "aab -> \"" << a << "\" valid=" << (noAdjacentEqual(a) && a.size() == 3 ? "yes" : "no") << "\n";

    std::string b = reorganizeString("aaab");
    std::cout << "aaab -> \"" << b << "\" (empty if impossible)\n";
}