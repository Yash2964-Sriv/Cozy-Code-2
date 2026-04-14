/**
 * Basic DSA - Interleaving String (LeetCode 97)
 * Check if s3 is formed by interleaving s1 and s2.
 */
#include <iostream>
#include <string>
#include <vector>

bool isInterleave(std::string s1, std::string s2, std::string s3) {
    int n = s1.size(), m = s2.size();
    if (n + m != (int)s3.size()) return false;
    std::vector<bool> dp(m + 1, false);
    dp[0] = true;
    for (int j = 1; j <= m; j++) dp[j] = dp[j-1] && s2[j-1] == s3[j-1];
    for (int i = 1; i <= n; i++) {
        dp[0] = dp[0] && s1[i-1] == s3[i-1];
        for (int j = 1; j <= m; j++)
            dp[j] = (dp[j] && s1[i-1] == s3[i+j-1]) || (dp[j-1] && s2[j-1] == s3[i+j-1]);
    }
    return dp[m];
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Interleaving String\n";
    std::cout << std::string(60, '=') << "\n";

    std::cout << "s1=aabcc, s2=dbbca, s3=aadbbcbcac -> "
              << (isInterleave("aabcc", "dbbca", "aadbbcbcac") ? "true" : "false") << "\n";

    std::cout << "s1=aabcc, s2=dbbca, s3=aadbbbaccc -> "
              << (isInterleave("aabcc", "dbbca", "aadbbbaccc") ? "true" : "false") << "\n";

    std::cout << "s1=, s2=, s3= -> " << (isInterleave("", "", "") ? "true" : "false") << "\n";
}