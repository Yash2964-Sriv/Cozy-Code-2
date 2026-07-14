/**
 * Basic DSA - Remove K Digits (LeetCode 402)
 * Greedy monotone stack: drop larger preceding digits while k removals remain to minimize number.
 */
#include <iostream>
#include <string>

std::string removeKdigits(std::string num, int k) {
    std::string st;
    st.reserve(num.size());
    for (char c : num) {
        while (k > 0 && !st.empty() && st.back() > c) {
            st.pop_back();
            --k;
        }
        st.push_back(c);
    }
    while (k > 0 && !st.empty()) {
        st.pop_back();
        --k;
    }
    size_t i = 0;
    while (i + 1 < st.size() && st[i] == '0')
        ++i;
    return st.empty() ? "0" : st.substr(i);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Remove K Digits\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "1432219, k=3 -> " << removeKdigits("1432219", 3) << "\n";
    std::cout << "10200, k=1   -> " << removeKdigits("10200", 1) << "\n";
    std::cout << "10, k=2      -> " << removeKdigits("10", 2) << "\n";
}