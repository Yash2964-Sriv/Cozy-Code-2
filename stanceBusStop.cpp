/**
 * Basic DSA - Distance Between Bus Stops (LeetCode 1184)
 * Bus stops on a circle; distance[i] is length from i to (i+1) mod n.
 */
#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

int distanceBetweenBusStops(const std::vector<int>& distance, int start, int destination) {
    if (start > destination)
        std::swap(start, destination);
    int clockwise = 0;
    int total = 0;
    int n = static_cast<int>(distance.size());
    for (int i = 0; i < n; ++i) {
        total += distance[i];
        if (i >= start && i < destination)
            clockwise += distance[i];
    }
    return std::min(clockwise, total - clockwise);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Distance Between Bus Stops\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> d = {1, 2, 3, 4};
    std::cout << "dist=[1,2,3,4], 0->1 -> " << distanceBetweenBusStops(d, 0, 1) << "\n";
    std::cout << "dist=[1,2,3,4], 0->3 -> " << distanceBetweenBusStops(d, 0, 3) << "\n";
}