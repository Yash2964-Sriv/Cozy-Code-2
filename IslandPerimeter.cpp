/**
 * Basic DSA - Island Perimeter (LeetCode 463)
 * Each land cell adds 4 sides; subtract 2 for each shared edge with land above or left.
 */
#include <iostream>
#include <vector>

int islandPerimeter(const std::vector<std::vector<int>>& grid) {
    int m = static_cast<int>(grid.size());
    int n = static_cast<int>(grid[0].size());
    int p = 0;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (!grid[static_cast<size_t>(i)][static_cast<size_t>(j)])
                continue;
            p += 4;
            if (i > 0 && grid[static_cast<size_t>(i - 1)][static_cast<size_t>(j)])
                p -= 2;
            if (j > 0 && grid[static_cast<size_t>(i)][static_cast<size_t>(j - 1)])
                p -= 2;
        }
    }
    return p;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Island Perimeter\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<std::vector<int>> g = {
        {0, 1, 0, 0},
        {1, 1, 1, 0},
        {0, 1, 0, 0},
        {1, 1, 0, 0}};
    std::cout << "4x4 example -> " << islandPerimeter(g) << "\n";
    std::cout << "single cell -> " << islandPerimeter({{1}}) << "\n";
}