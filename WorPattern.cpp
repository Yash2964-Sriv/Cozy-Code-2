/**
 * Basic DSA - Word Pattern (LeetCode 290)
 * Check if str follows the pattern (bijection between pattern chars and words).
 */
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <sstream>

std::vector<std::string> split(const std::string& s) {
    std::vector<std::string> out;
    std::istringstream iss(s);
    std::string w;
    while (iss >> w) out.push_back(w);
    return out;
}

bool wordPattern(std::string pattern, std::string s) {
    auto words = split(s);
    if (words.size() != pattern.size()) return false;
    std::unordered_map<char, std::string> map;
    std::unordered_set<std::string> used;
    for (size_t i = 0; i < pattern.size(); i++) {
        if (map.count(pattern[i])) {
            if (map[pattern[i]] != words[i]) return false;
        } else {
            if (used.count(words[i])) return false;
            map[pattern[i]] = words[i];
            used.insert(words[i]);
        }
    }
    return true;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Word Pattern\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "abba, \"dog cat cat dog\" -> "
              << (wordPattern("abba", "dog cat cat dog") ? "true" : "false") << "\n";
    std::cout << "abba, \"dog cat cat fish\" -> "
              << (wordPattern("abba", "dog cat cat fish") ? "true" : "false") << "\n";
    std::cout << "aaaa, \"dog cat cat dog\" -> "
              << (wordPattern("aaaa", "dog cat cat dog") ? "true" : "false") << "\n";
}