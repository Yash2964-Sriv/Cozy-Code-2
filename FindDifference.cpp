/**
 * Basic DSA - Find the Difference (LeetCode 389)
 * Find the letter added to t that is not in s.
 */
#include <iostream>
#include <string>

char findTheDifference(std::string s, std::string t) {
    char x = 0;
    for (char c : s) x ^= c;
    for (char c : t) x ^= c;
    return x;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Find the Difference\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "\"abcd\", \"abcde\" -> " << findTheDifference("abcd", "abcde") << "\n";
    std::cout << "\"\", \"y\" -> " << findTheDifference("", "y") << "\n";
    std::cout << "\"a\", \"aa\" -> " << findTheDifference("a", "aa") << "\n";
}