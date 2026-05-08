/**
 * Basic DSA - Isomorphic Strings (LeetCode 205)
 * Check if s and t are isomorphic (character mapping).
 */
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>

bool isIsomorphic(std::string s, std::string t) {
    if (s.size() != t.size()) return false;
    std::unordered_map<char, char> map;
    std::unordered_set<char> used;
    for (size_t i = 0; i < s.size(); i++) {
        if (map.count(s[i])) {
            if (map[s[i]] != t[i]) return false;
        } else {
            if (used.count(t[i])) return false;
            map[s[i]] = t[i];
            used.insert(t[i]);
        }
    }
    return true;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Isomorphic Strings\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "egg, add -> " << (isIsomorphic("egg", "add") ? "true" : "false") << "\n";
    std::cout << "foo, bar -> " << (isIsomorphic("foo", "bar") ? "true" : "false") << "\n";
    std::cout << "paper, title -> " << (isIsomorphic("paper", "title") ? "true" : "false") << "\n";
}