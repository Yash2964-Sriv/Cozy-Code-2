/**
 * Basic DSA - Arranging Coins (LeetCode 441)
 * Row i has i coins; fill complete rows until you run out. Max number of full rows.
 * k rows need 1+2+...+k = k(k+1)/2 coins; binary search largest k with sum <= n.
 */
#include <iostream>

int arrangeCoins(int n) {
    long long lo = 0;
    long long hi = n;
    while (lo < hi) {
        long long mid = lo + (hi - lo + 1) / 2;
        long long need = mid * (mid + 1) / 2;
        if (need <= n)
            lo = mid;
        else
            hi = mid - 1;
    }
    return static_cast<int>(lo);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Arranging Coins\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "n=5 -> " << arrangeCoins(5) << "\n";
    std::cout << "n=8 -> " << arrangeCoins(8) << "\n";
    std::cout << "n=10 -> " << arrangeCoins(10) << "\n";
}