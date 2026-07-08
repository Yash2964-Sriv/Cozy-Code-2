/**
 * Basic DSA - Smallest Number in Infinite Set (LeetCode 2336)
 * Starts with all positive integers. popSmallest takes the minimum; addBack reinserts a removed value. Min-heap for returns plus a sequential cursor.
 */
#include <iostream>
#include <queue>
#include <vector>

struct SmallestInfiniteSet {
    int cursor = 1;
    std::priority_queue<int, std::vector<int>, std::greater<int>> returned;

    int popSmallest() {
        if (!returned.empty() && returned.top() < cursor) {
            int x = returned.top();
            returned.pop();
            return x;
        }
        return cursor++;
    }

    void addBack(int num) {
        if (num < cursor)
            returned.push(num);
    }
};

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Smallest Number in Infinite Set\n";
    std::cout << std::string(60, '=') << "\n";

    SmallestInfiniteSet s;
    std::cout << "popSmallest -> " << s.popSmallest() << "\n";
    std::cout << "popSmallest -> " << s.popSmallest() << "\n";
    s.addBack(1);
    std::cout << "popSmallest -> " << s.popSmallest() << "\n";
    std::cout << "popSmallest -> " << s.popSmallest() << "\n";
    std::cout << "popSmallest -> " << s.popSmallest() << "\n";
}