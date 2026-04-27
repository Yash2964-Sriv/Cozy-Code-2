/**
 * Basic DSA - Pacific Atlantic Water Flow (LeetCode 417)
 * Find cells from which water can flow to both oceans.
 */
#include <iostream>
#include <vector>

std::vector<std::vector<int>> pacificAtlantic(std::vector<std::vector<int>>& heights) {
    int R = heights.size(), C = heights[0].size();
    std::vector<std::vector<int>> ans;
    std::vector<std::vector<int>> pac(R, std::vector<int>(C, 0)), atl(R, std::vector<int>(C, 0));

    auto dfs = [&](auto&& self, int r, int c, std::vector<std::vector<int>>& vis) {
        if (vis[r][c]) return;
        vis[r][c] = 1;
        int dr[] = {-1,1,0,0}, dc[] = {0,0,-1,1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && heights[nr][nc] >= heights[r][c])
                self(self, nr, nc, vis);
        }
    };

    for (int c = 0; c < C; c++) { dfs(dfs, 0, c, pac); dfs(dfs, R-1, c, atl); }
    for (int r = 0; r < R; r++) { dfs(dfs, r, 0, pac); dfs(dfs, r, C-1, atl); }

    for (int r = 0; r < R; r++)
        for (int c = 0; c < C; c++)
            if (pac[r][c] && atl[r][c]) ans.push_back({r, c});
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Pacific Atlantic Water Flow\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<std::vector<int>> h = {
        {1,2,2,3,5},
        {3,2,3,4,4},
        {2,4,5,3,1},
        {6,7,1,4,5},
        {5,1,1,2,4}
    };
    auto r = pacificAtlantic(h);
    std::cout << "5x5 grid -> " << r.size() << " cells: ";
    for (auto& p : r) std::cout << "[" << p[0] << "," << p[1] << "] ";
    std::cout << "\n";
}