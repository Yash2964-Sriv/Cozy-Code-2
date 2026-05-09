/**
 * Basic DSA - Power of Four (LeetCode 342)
 * Check if n is a power of 4.
 */
#include <iostream>
#include <cstdint>

bool isPowerOfFour(int n) {
    return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Power of Four\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "16 -> " << (isPowerOfFour(16) ? "true" : "false") << "\n";
    std::cout << "5 -> " << (isPowerOfFour(5) ? "true" : "false") << "\n";
    std::cout << "1 -> " << (isPowerOfFour(1) ? "true" : "false") << "\n";
    std::cout << "8 -> " << (isPowerOfFour(8) ? "true" : "false") << "\n";
}