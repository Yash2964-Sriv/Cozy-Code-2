/**
 * Basic DSA - Detect Capital (LeetCode 520)
 * Check if word uses capitals correctly (all caps, all lowercase, or only first capital).
 */
#include <iostream>
#include <string>
#include <cctype>

bool detectCapitalUse(std::string word) {
    int caps = 0;
    for (char c : word) if (std::isupper(c)) caps++;
    return caps == 0 || caps == (int)word.size() || (caps == 1 && std::isupper(word[0]));
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Detect Capital\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "USA -> " << (detectCapitalUse("USA") ? "true" : "false") << "\n";
    std::cout << "FlaG -> " << (detectCapitalUse("FlaG") ? "true" : "false") << "\n";
    std::cout << "Google -> " << (detectCapitalUse("Google") ? "true" : "false") << "\n";
    std::cout << "leetcode -> " << (detectCapitalUse("leetcode") ? "true" : "false") << "\n";
}
