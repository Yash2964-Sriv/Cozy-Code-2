/**
 * Basic DSA - Exam Room (LeetCode 855)
 * n seats 0..n-1; seat() picks the position farthest from anyone else. Max-heap of (distance, -position) over gaps between occupied seats.
 */
#include <iostream>
#include <queue>
#include <set>
#include <utility>

struct ExamRoom {
    int n;
    std::set<int> seats;
    std::priority_queue<std::pair<int, int>> heap; // distance, -position

    explicit ExamRoom(int n_) : n(n_) {}

    void addSegment(int left, int right) {
        int dist;
        int pos;
        if (left == -1) {
            pos = 0;
            dist = right;
        } else if (right == n) {
            pos = n - 1;
            dist = n - 1 - left;
        } else {
            pos = left + (right - left) / 2;
            dist = (right - left) / 2;
        }
        heap.push({dist, -pos});
    }

    int seat() {
        if (seats.empty()) {
            seats.insert(0);
            addSegment(0, n);
            return 0;
        }
        while (!heap.empty()) {
            int pos = -heap.top().second;
            heap.pop();
            if (seats.count(pos))
                continue;
            auto it = seats.lower_bound(pos);
            int right = (it == seats.end()) ? n : *it;
            int left = (it == seats.begin()) ? -1 : *std::prev(it);
            if (left == -1) {
                if (pos != 0)
                    continue;
            } else if (right == n) {
                if (pos != n - 1)
                    continue;
            } else {
                if (pos != left + (right - left) / 2)
                    continue;
            }
            seats.insert(pos);
            addSegment(left, pos);
            addSegment(pos, right);
            return pos;
        }
        return -1;
    }

    void leave(int p) {
        if (!seats.count(p))
            return;
        auto it = seats.find(p);
        int right = (std::next(it) == seats.end()) ? n : *std::next(it);
        int left = (it == seats.begin()) ? -1 : *std::prev(it);
        seats.erase(it);
        addSegment(left, right);
    }
};

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Exam Room\n";
    std::cout << std::string(60, '=') << "\n";

    ExamRoom room(10);
    std::cout << "seat -> " << room.seat() << "\n";
    std::cout << "seat -> " << room.seat() << "\n";
    std::cout << "seat -> " << room.seat() << "\n";
    std::cout << "seat -> " << room.seat() << "\n";
    room.leave(4);
    std::cout << "seat after leave(4) -> " << room.seat() << "\n";
}