/**
 * Basic DSA - Seat Reservation Manager (LeetCode 1845)
 * reserve() returns the lowest-numbered free seat; unreserve() returns a seat to the pool. Min-heap of released seats plus a next-new counter.
 */
#include <iostream>
#include <queue>
#include <vector>

struct SeatManager {
    int nextSeat = 1;
    std::priority_queue<int, std::vector<int>, std::greater<int>> freed;

    explicit SeatManager(int n) { (void)n; }

    int reserve() {
        if (!freed.empty()) {
            int s = freed.top();
            freed.pop();
            return s;
        }
        return nextSeat++;
    }

    void unreserve(int seatNumber) { freed.push(seatNumber); }
};

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Seat Reservation Manager\n";
    std::cout << std::string(60, '=') << "\n";

    SeatManager mgr(5);
    std::cout << "reserve -> " << mgr.reserve() << "\n";
    std::cout << "reserve -> " << mgr.reserve() << "\n";
    mgr.unreserve(2);
    std::cout << "reserve -> " << mgr.reserve() << "\n";
    std::cout << "reserve -> " << mgr.reserve() << "\n";
    std::cout << "reserve -> " << mgr.reserve() << "\n";
}