/**
 * Basic DSA - Task Scheduler II (LeetCode 2365)
 * Complete tasks in order; same type needs `space` days between runs. Track last finish day per type; fast-forward the calendar when needed.
 */
#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

long long taskSchedulerII(const std::vector<int>& tasks, int space) {
    std::unordered_map<int, long long> lastFinish;
    long long day = 0;
    for (int t : tasks) {
        if (lastFinish.count(t))
            day = std::max(day, lastFinish[t] + space + 1);
        lastFinish[t] = day;
        ++day;
    }
    return day;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Task Scheduler II\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[1,2,1,2,3,1], space=3 -> " << taskSchedulerII({1, 2, 1, 2, 3, 1}, 3) << "\n";
    std::cout << "[5,8,8,5], space=2       -> " << taskSchedulerII({5, 8, 8, 5}, 2) << "\n";
}