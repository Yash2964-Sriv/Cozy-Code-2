/**
 * Basic DSA - Jump Game III (LeetCode 1306)
 * From index start, repeatedly jump to i ± arr[i]. BFS marks visited positions; success if any arr[i] == 0 is reached.
 */
#include <iostream>
#include <queue>
#include <vector>

bool canReach(const std::vector<int>& arr, int start) {
    int n = static_cast<int>(arr.size());
    std::vector<char> vis(static_cast<size_t>(n), 0);
    std::queue<int> q;
    vis[static_cast<size_t>(start)] = 1;
    q.push(start);
    while (!q.empty()) {
        int i = q.front();
        q.pop();
        if (arr[static_cast<size_t>(i)] == 0)
            return true;
        int step = arr[static_cast<size_t>(i)];
        for (int j : {i - step, i + step}) {
            if (j >= 0 && j < n && !vis[static_cast<size_t>(j)]) {
                vis[static_cast<size_t>(j)] = 1;
                q.push(j);
            }
        }
    }
    return false;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Jump Game III\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[4,2,3,0,3,1,2], start=5 -> " << (canReach({4, 2, 3, 0, 3, 1, 2}, 5) ? "true" : "false")
              << "\n";
    std::cout << "[4,2,3,0,3,1,2], start=0 -> " << (canReach({4, 2, 3, 0, 3, 1, 2}, 0) ? "true" : "false")
              << "\n";
    std::cout << "[3,0,2,1,2], start=2    -> " << (canReach({3, 0, 2, 1, 2}, 2) ? "true" : "false") << "\n";
}