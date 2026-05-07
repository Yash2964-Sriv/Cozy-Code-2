/**
 * Basic DSA - Power of Two (LeetCode 231)
 * Check if n is a power of 2.
 */
#include <iostream>
#include <cstdint>

bool isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Power of Two\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "1 -> " << (isPowerOfTwo(1) ? "true" : "false") << "\n";
    std::cout << "16 -> " << (isPowerOfTwo(16) ? "true" : "false") << "\n";
    std::cout << "3 -> " << (isPowerOfTwo(3) ? "true" : "false") << "\n";
    std::cout << "0 -> " << (isPowerOfTwo(0) ? "true" : "false") << "\n";
}