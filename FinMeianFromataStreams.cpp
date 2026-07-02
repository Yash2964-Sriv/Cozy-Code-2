/**
 * Basic DSA - Find Median from Data Stream (LeetCode 295)
 * Two heaps: max-heap `lo` holds the smaller half, min-heap `hi` the larger; rebalance so `lo` has equal or one more element.
 */
#include <iostream>
#include <queue>
#include <vector>

struct MedianFinder {
    std::priority_queue<int> lo;
    std::priority_queue<int, std::vector<int>, std::greater<int>> hi;

    void addNum(int num) {
        lo.push(num);
        hi.push(lo.top());
        lo.pop();
        if (lo.size() < hi.size()) {
            lo.push(hi.top());
            hi.pop();
        }
    }

    double findMedian() const {
        if (lo.size() > hi.size())
            return static_cast<double>(lo.top());
        return (static_cast<double>(lo.top()) + static_cast<double>(hi.top())) / 2.0;
    }
};

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Find Median from Data Stream\n";
    std::cout << std::string(60, '=') << "\n";

    MedianFinder mf;
    mf.addNum(1);
    mf.addNum(2);
    std::cout << "after 1,2   median=" << mf.findMedian() << "\n";
    mf.addNum(3);
    std::cout << "after 1,2,3 median=" << mf.findMedian() << "\n";
}