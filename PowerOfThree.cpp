/**
 * Basic DSA - Power of Three (LeetCode 326)
 * Check if n is a power of 3.
 */
#include <iostream>

bool isPowerOfThree(int n) {
    if (n <= 0) return false;
    while (n % 3 == 0) n /= 3;
    return n == 1;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Power of Three\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "27 -> " << (isPowerOfThree(27) ? "true" : "false") << "\n";
    std::cout << "0 -> " << (isPowerOfThree(0) ? "true" : "false") << "\n";
    std::cout << "9 -> " << (isPowerOfThree(9) ? "true" : "false") << "\n";
    std::cout << "45 -> " << (isPowerOfThree(45) ? "true" : "false") << "\n";
}