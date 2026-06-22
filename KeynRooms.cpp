/**
 * Basic DSA - Keys and Rooms (LeetCode 841)
 * Room 0 unlocked; each room holds keys to others. DFS/iterative stack marks reachable rooms; need all n visited.
 */
#include <iostream>
#include <stack>
#include <vector>

bool canVisitAllRooms(const std::vector<std::vector<int>>& rooms) {
    int n = static_cast<int>(rooms.size());
    std::vector<char> vis(static_cast<size_t>(n), 0);
    std::stack<int> st;
    st.push(0);
    vis[0] = 1;
    int seen = 0;
    while (!st.empty()) {
        int u = st.top();
        st.pop();
        ++seen;
        for (int v : rooms[static_cast<size_t>(u)]) {
            if (!vis[static_cast<size_t>(v)]) {
                vis[static_cast<size_t>(v)] = 1;
                st.push(v);
            }
        }
    }
    return seen == n;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Keys and Rooms\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "chain [[1],[2],[3],[]]     -> "
              << (canVisitAllRooms({{1}, {2}, {3}, {}}) ? "true" : "false") << "\n";
    std::cout << "[[1,3],[3,0,1],[2],[0]] (no key 2) -> "
              << (canVisitAllRooms({{1, 3}, {3, 0, 1}, {2}, {0}}) ? "true" : "false") << "\n";
    std::cout << "[[1],[0],[2]]              -> "
              << (canVisitAllRooms({{1}, {0}, {2}}) ? "true" : "false") << "\n";
}