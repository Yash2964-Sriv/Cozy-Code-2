/**
 * Basic DSA - Pairs of Songs With Total Durations Divisible by 60 (LeetCode 1010)
 * Count pairs (i, j) with i < j and (time[i] + time[j]) % 60 == 0.
 */
#include <iostream>
#include <string>
#include <vector>

int numPairsDivisibleBy60(std::vector<int>& time) {
    std::vector<int> mod(60);
    int ans = 0;
    for (int t : time) {
        int m = t % 60;
        if (m < 0)
            m += 60;
        ans += mod[(60 - m) % 60];
        ++mod[m];
    }
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Pairs of Songs With Total Durations Divisible by 60\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> v1 = {30, 20, 150, 100, 40};
    std::cout << "[30,20,150,100,40] -> " << numPairsDivisibleBy60(v1) << "\n";

    std::vector<int> v2 = {60, 60, 60};
    std::cout << "[60,60,60] -> " << numPairsDivisibleBy60(v2) << "\n";
}