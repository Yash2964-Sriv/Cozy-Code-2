/**
 * Basic DSA - Complement of Base 10 Integer (LeetCode 1009)
 * Return complement (flip bits) of integer, assuming no leading zeros.
 */
#include <iostream>

int bitwiseComplement(int n) {
    if (n == 0) return 1;
    unsigned mask = ~0;
    while (mask & n) mask <<= 1;
    return ~n & ~mask;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Complement of Base 10 Integer\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "5 -> " << bitwiseComplement(5) << "\n";
    std::cout << "7 -> " << bitwiseComplement(7) << "\n";
    std::cout << "10 -> " << bitwiseComplement(10) << "\n";
    std::cout << "0 -> " << bitwiseComplement(0) << "\n";
}