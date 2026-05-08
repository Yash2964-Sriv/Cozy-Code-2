

/**
 * Basic DSA - Add Binary (LeetCode 67)
 * Add two binary strings, return binary sum.
 */
#include <iostream>
#include <string>
#include <algorithm>

std::string addBinary(std::string a, std::string b) {
    std::string out;
    int i = (int)a.size() - 1, j = (int)b.size() - 1, carry = 0;
    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;
        if (i >= 0) sum += a[i--] - '0';
        if (j >= 0) sum += b[j--] - '0';
        out += (sum % 2) + '0';
        carry = sum / 2;
    }
    std::reverse(out.begin(), out.end());
    return out;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Add Binary\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "11 + 1 -> " << addBinary("11", "1") << "\n";
    std::cout << "1010 + 1011 -> " << addBinary("1010", "1011") << "\n";
    std::cout << "0 + 0 -> " << addBinary("0", "0") << "\n";
}