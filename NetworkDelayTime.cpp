/**
 * Basic DSA - Network Delay Time (LeetCode 743)
 * Directed weighted graph, signal from node k. Dijkstra; answer is max distance to 1..n, or -1 if disconnected.
 */
#include <algorithm>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

int networkDelayTime(const std::vector<std::vector<int>>& times, int n, int k) {
    std::vector<std::vector<std::pair<int, int>>> g(static_cast<size_t>(n + 1));
    for (const auto& t : times)
        g[static_cast<size_t>(t[0])].push_back({t[1], t[2]});

    const int INF = 1000000000;
    std::vector<int> dist(static_cast<size_t>(n + 1), INF);
    dist[static_cast<size_t>(k)] = 0;

    std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>,
                        std::greater<std::pair<int, int>>>
        pq;
    pq.push({0, k});

    while (!pq.empty()) {
        std::pair<int, int> top = pq.top();
        pq.pop();
        int d = top.first;
        int u = top.second;
        if (d != dist[static_cast<size_t>(u)])
            continue;
        for (const auto& e : g[static_cast<size_t>(u)]) {
            int v = e.first;
            int w = e.second;
            int nd = d + w;
            if (nd < dist[static_cast<size_t>(v)]) {
                dist[static_cast<size_t>(v)] = nd;
                pq.push({nd, v});
            }
        }
    }

    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        if (dist[static_cast<size_t>(i)] == INF)
            return -1;
        ans = std::max(ans, dist[static_cast<size_t>(i)]);
    }
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Network Delay Time\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<std::vector<int>> times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    std::cout << "n=4, k=2 (sample) -> " << networkDelayTime(times, 4, 2) << "\n";
    std::cout << "unreachable       -> " << networkDelayTime({{1, 2, 1}}, 2, 2) << "\n";
}