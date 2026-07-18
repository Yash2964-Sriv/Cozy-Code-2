/**
 * Basic DSA - Surrounded Regions (LeetCode 130)
 * Flip every O not connected to the border to X. BFS from border O marks safe cells as '#', then sweep.
 */
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

void markFrom(std::vector<std::vector<char>>& board, int sr, int sc) {
    int m = static_cast<int>(board.size());
    int n = static_cast<int>(board[0].size());
    if (sr < 0 || sr >= m || sc < 0 || sc >= n)
        return;
    if (board[static_cast<size_t>(sr)][static_cast<size_t>(sc)] != 'O')
        return;
    std::queue<std::pair<int, int>> q;
    q.push({sr, sc});
    int dr[4] = {-1, 1, 0, 0};
    int dc[4] = {0, 0, -1, 1};
    while (!q.empty()) {
        std::pair<int, int> cell = q.front();
        q.pop();
        int r = cell.first;
        int c = cell.second;
        if (r < 0 || r >= m || c < 0 || c >= n)
            continue;
        if (board[static_cast<size_t>(r)][static_cast<size_t>(c)] != 'O')
            continue;
        board[static_cast<size_t>(r)][static_cast<size_t>(c)] = '#';
        for (int d = 0; d < 4; ++d)
            q.push({r + dr[d], c + dc[d]});
    }
}

void solve(std::vector<std::vector<char>>& board) {
    int m = static_cast<int>(board.size());
    int n = static_cast<int>(board[0].size());
    for (int j = 0; j < n; ++j) {
        markFrom(board, 0, j);
        markFrom(board, m - 1, j);
    }
    for (int i = 0; i < m; ++i) {
        markFrom(board, i, 0);
        markFrom(board, i, n - 1);
    }
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (board[static_cast<size_t>(i)][static_cast<size_t>(j)] == 'O')
                board[static_cast<size_t>(i)][static_cast<size_t>(j)] = 'X';
            else if (board[static_cast<size_t>(i)][static_cast<size_t>(j)] == '#')
                board[static_cast<size_t>(i)][static_cast<size_t>(j)] = 'O';
        }
    }
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Surrounded Regions\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<std::vector<char>> g = {
        {'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    solve(g);
    for (const auto& row : g) {
        for (char c : row)
            std::cout << c;
        std::cout << "\n";
    }
}