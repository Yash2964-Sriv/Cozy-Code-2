/**
 * Basic DSA - Excel Sheet Column Number (LeetCode 171)
 * Column title uses A=1,...,Z=26, then AA, AB,... (base-26 without a zero digit).
 */
#include <iostream>
#include <string>

int titleToNumber(const std::string& s) {
    int ans = 0;
    for (char c : s)
        ans = ans * 26 + (c - 'A' + 1);
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Excel Sheet Column Number\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "A -> " << titleToNumber("A") << "\n";
    std::cout << "AB -> " << titleToNumber("AB") << "\n";
    std::cout << "ZY -> " << titleToNumber("ZY") << "\n";
}