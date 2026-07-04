/**
 * Basic DSA - Dinner Plate Stacks (LeetCode 1172)
 * Fixed-capacity stacks; push uses leftmost non-full stack (min-heap of indices); pop takes from rightmost non-empty stack.
 */
#include <iostream>
#include <queue>
#include <vector>

struct DinnerPlates {
    int cap;
    std::vector<std::vector<int>> stacks;
    std::priority_queue<int, std::vector<int>, std::greater<int>> avail;

    explicit DinnerPlates(int capacity) : cap(capacity) {}

    void push(int val) {
        if (!avail.empty() && avail.top() == static_cast<int>(stacks.size()))
            avail.pop();
        if (avail.empty()) {
            avail.push(static_cast<int>(stacks.size()));
            stacks.push_back({});
        }
        int i = avail.top();
        avail.pop();
        stacks[static_cast<size_t>(i)].push_back(val);
        if (static_cast<int>(stacks[static_cast<size_t>(i)].size()) < cap)
            avail.push(i);
    }

    int pop() {
        while (!stacks.empty() && stacks.back().empty())
            stacks.pop_back();
        if (stacks.empty())
            return -1;
        int v = stacks.back().back();
        stacks.back().pop_back();
        if (static_cast<int>(stacks.back().size()) < cap)
            avail.push(static_cast<int>(stacks.size()) - 1);
        return v;
    }

    int popAtStack(int index) {
        if (index < 0 || index >= static_cast<int>(stacks.size()) || stacks[static_cast<size_t>(index)].empty())
            return -1;
        int v = stacks[static_cast<size_t>(index)].back();
        stacks[static_cast<size_t>(index)].pop_back();
        if (static_cast<int>(stacks[static_cast<size_t>(index)].size()) < cap)
            avail.push(index);
        return v;
    }
};

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Dinner Plate Stacks\n";
    std::cout << std::string(60, '=') << "\n";

    DinnerPlates dp(2);
    dp.push(1);
    dp.push(2);
    dp.push(3);
    dp.push(4);
    std::cout << "pop     -> " << dp.pop() << "\n";
    std::cout << "pop     -> " << dp.pop() << "\n";
    dp.push(5);
    std::cout << "popAt 0 -> " << dp.popAtStack(0) << "\n";
    std::cout << "pop     -> " << dp.pop() << "\n";
}