/**
 * Basic DSA - Split a String in Balanced Strings (LeetCode 1221)
 * 'L' and 'R' only; balanced substring has equal count of L and R. Maximize pieces.
 */
#include <iostream>
#include <string>

int balancedStringSplit(const std::string& s) {
    int bal = 0;
    int ans = 0;
    for (char c : s) {
        bal += (c == 'L') ? 1 : -1;
        if (bal == 0)
            ++ans;
    }
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Split a String in Balanced Strings\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "RLRRLLRLRL -> " << balancedStringSplit("RLRRLLRLRL") << "\n";
    std::cout << "RLLLLRRRLR -> " << balancedStringSplit("RLLLLRRRLR") << "\n";
}