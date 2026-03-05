/**
 * Basic DSA - Valid Parentheses (LeetCode 20)
 * Check if brackets in string are properly matched.
 */
#include <iostream>
#include <string>
#include <stack>

bool isValid(std::string s) {
    std::stack<char> st;
    for (char c : s) {
        if (c == '(' || c == '{' || c == '[')
            st.push(c);
        else {
            if (st.empty()) return false;
            char open = st.top();
            st.pop();
            if ((c == ')' && open != '(') || (c == '}' && open != '{') || (c == ']' && open != '['))
                return false;
        }
    }
    return st.empty();
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Valid Parentheses\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "\"()\" -> " << (isValid("()") ? "true" : "false") << "\n";
    std::cout << "\"()[]{}\" -> " << (isValid("()[]{}") ? "true" : "false") << "\n";
    std::cout << "\"(]\" -> " << (isValid("(]") ? "true" : "false") << "\n";
    std::cout << "\"([)]\" -> " << (isValid("([)]") ? "true" : "false") << "\n";
}