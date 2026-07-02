/**
 * Basic DSA - All Paths from Source to Target (LeetCode 797)
 * DAG as adjacency list (0 .. n-1). DFS from 0 appends paths that reach n-1.
 */
#include <iostream>
#include <vector>

void dfs(const std::vector<std::vector<int>>& g, int u, std::vector<int>& path, std::vector<std::vector<int>>& out) {
    path.push_back(u);
    if (u == static_cast<int>(g.size()) - 1)
        out.push_back(path);
    else {
        for (int v : g[static_cast<size_t>(u)])
            dfs(g, v, path, out);
    }
    path.pop_back();
}

std::vector<std::vector<int>> allPathsSourceTarget(const std::vector<std::vector<int>>& graph) {
    std::vector<std::vector<int>> res;
    std::vector<int> path;
    dfs(graph, 0, path, res);
    return res;
}

void printPaths(const std::vector<std::vector<int>>& p) {
    for (const auto& row : p) {
        std::cout << "  ";
        for (size_t i = 0; i < row.size(); ++i) {
            if (i) std::cout << "->";
            std::cout << row[i];
        }
        std::cout << "\n";
    }
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: All Paths from Source to Target\n";
    std::cout << std::string(60, '=') << "\n";

    auto p = allPathsSourceTarget({{1, 2}, {3}, {3}, {}});
    printPaths(p);
}