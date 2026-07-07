/**
 * Basic DSA - Divisor Game (LeetCode 1025)
 * Start with n>0; players alternate subtracting a proper divisor. Alice moves first.
 */
#include <iostream>
#include <string>

bool divisorGame(int n) {
    return n % 2 == 0;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Divisor Game\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "n=2 -> " << (divisorGame(2) ? "true" : "false") << "\n";
    std::cout << "n=3 -> " << (divisorGame(3) ? "true" : "false") << "\n";
}