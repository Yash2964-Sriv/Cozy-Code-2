
/**
 * Basic DSA - Number of Recent Calls (LeetCode 933)
 * Count requests in the past 3000 ms inclusive. Queue stores ping times; drop front while time <= t - 3000.
 */
#include <iostream>
#include <queue>

struct RecentCounter {
    std::queue<int> q;

    int ping(int t) {
        q.push(t);
        while (!q.empty() && q.front() < t - 3000)
            q.pop();
        return static_cast<int>(q.size());
    }
};

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Number of Recent Calls\n";
    std::cout << std::string(60, '=') << "\n";

    RecentCounter rc;
    std::cout << "ping(1)    -> " << rc.ping(1) << "\n";
    std::cout << "ping(100)  -> " << rc.ping(100) << "\n";
    std::cout << "ping(3001) -> " << rc.ping(3001) << "\n";
    std::cout << "ping(3002) -> " << rc.ping(3002) << "\n";
}