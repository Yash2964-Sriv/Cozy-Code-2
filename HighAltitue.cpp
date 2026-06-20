/**
 * Basic DSA - Find the Highest Altitude (LeetCode 1732)
 * Start at altitude 0; add gain[i] after each segment. Return the maximum altitude.
 */
#include <iostream>
#include <vector>

int largestAltitude(const std::vector<int>& gain) {
    int cur = 0;
    int best = 0;
    for (int g : gain) {
        cur += g;
        if (cur > best)
            best = cur;
    }
    return best;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Find the Highest Altitude\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "[-5,1,5,0,-7] -> " << largestAltitude({-5, 1, 5, 0, -7}) << "\n";
    std::cout << "[-4,-3,-2,-1,4,3,2] -> " << largestAltitude({-4, -3, -2, -1, 4, 3, 2}) << "\n";
}