/**
 * Basic DSA - Number of Provinces (LeetCode 547)
 * Undirected graph as adjacency matrix; count connected components via DFS from each unvisited city.
 */
#include <iostream>
#include <vector>

void dfs(int i, const std::vector<std::vector<int>>& ic, std::vector<char>& vis) {
    vis[static_cast<size_t>(i)] = 1;
    int n = static_cast<int>(ic.size());
    for (int j = 0; j < n; ++j) {
        if (ic[static_cast<size_t>(i)][static_cast<size_t>(j)] && !vis[static_cast<size_t>(j)])
            dfs(j, ic, vis);
    }
}

int findCircleNum(const std::vector<std::vector<int>>& isConnected) {
    int n = static_cast<int>(isConnected.size());
    std::vector<char> vis(static_cast<size_t>(n), 0);
    int provinces = 0;
    for (int i = 0; i < n; ++i) {
        if (!vis[static_cast<size_t>(i)]) {
            dfs(i, isConnected, vis);
            ++provinces;
        }
    }
    return provinces;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Number of Provinces\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<std::vector<int>> m1 = {
        {1, 1, 0},
        {1, 1, 0},
        {0, 0, 1}};
    std::cout << "3 cities (two components) -> " << findCircleNum(m1) << "\n";

    std::vector<std::vector<int>> m2 = {
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}};
    std::cout << "3 isolated               -> " << findCircleNum(m2) << "\n";
}