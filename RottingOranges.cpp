public class RottingOranges2 {
    
}
/**
 * Basic DSA - Rotting Oranges (LeetCode 994)
 * Multi-source BFS from all rotten cells (2); each minute spreads to adjacent fresh (1). Return minutes or -1.
 */
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

int orangesRotting(std::vector<std::vector<int>> grid) {
    int m = static_cast<int>(grid.size());
    int n = static_cast<int>(grid[0].size());
    std::queue<std::pair<int, int>> q;
    int fresh = 0;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (grid[static_cast<size_t>(i)][static_cast<size_t>(j)] == 2)
                q.push({i, j});
            else if (grid[static_cast<size_t>(i)][static_cast<size_t>(j)] == 1)
                ++fresh;
        }
    }
    int time = 0;
    int dr[4] = {-1, 1, 0, 0};
    int dc[4] = {0, 0, -1, 1};
    while (!q.empty() && fresh > 0) {
        int layer = static_cast<int>(q.size());
        for (int k = 0; k < layer; ++k) {
            std::pair<int, int> cell = q.front();
            q.pop();
            for (int d = 0; d < 4; ++d) {
                int r = cell.first + dr[d];
                int c = cell.second + dc[d];
                if (r >= 0 && r < m && c >= 0 && c < n &&
                    grid[static_cast<size_t>(r)][static_cast<size_t>(c)] == 1) {
                    grid[static_cast<size_t>(r)][static_cast<size_t>(c)] = 2;
                    --fresh;
                    q.push({r, c});
                }
            }
        }
        ++time;
    }
    return fresh == 0 ? time : -1;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Rotting Oranges\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<std::vector<int>> g1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    std::cout << "grid1 -> " << orangesRotting(g1) << "\n";
    std::vector<std::vector<int>> g2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
    std::cout << "grid2 -> " << orangesRotting(g2) << "\n";
    std::vector<std::vector<int>> g3 = {{0, 2}};
    std::cout << "grid3 -> " << orangesRotting(g3) << "\n";
}