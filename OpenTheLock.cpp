/**
 * Basic DSA - Open the Lock (LeetCode 752)
 * BFS from "0000" on 4 dials; each step +-1 mod 10 on one position; skip deadends.
 */
#include <iostream>
#include <queue>
#include <string>
#include <unordered_set>
#include <utility>
#include <vector>

int openLock(const std::vector<std::string>& deadends, const std::string& target) {
    std::unordered_set<std::string> dead(deadends.begin(), deadends.end());
    if (dead.count("0000"))
        return -1;
    std::queue<std::pair<std::string, int>> q;
    std::unordered_set<std::string> vis{"0000"};
    q.push({"0000", 0});
    while (!q.empty()) {
        std::pair<std::string, int> cur = q.front();
        q.pop();
        const std::string& s = cur.first;
        int dist = cur.second;
        if (s == target)
            return dist;
        for (int i = 0; i < 4; ++i) {
            for (int delta : {-1, 1}) {
                std::string t = s;
                int x = (t[static_cast<size_t>(i)] - '0' + delta + 10) % 10;
                t[static_cast<size_t>(i)] = static_cast<char>('0' + x);
                if (!vis.count(t) && !dead.count(t)) {
                    vis.insert(t);
                    q.push({t, dist + 1});
                }
            }
        }
    }
    return -1;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Open the Lock\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "example 1 -> " << openLock({"0201", "0101", "0102", "1212", "2002"}, "0202") << "\n";
    std::cout << "example 2 -> " << openLock({"8888"}, "0009") << "\n";
    std::cout << "start=target -> " << openLock({}, "0000") << "\n";
}