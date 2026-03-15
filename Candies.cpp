/**
 * Basic DSA - Candy (LeetCode 135)
 * Min candies: each child gets at least 1; higher rating gets more than neighbors.
 */
#include <iostream>
#include <vector>
#include <algorithm>


int candy(std::vector<int>& ratings) {
    int n = (int)ratings.size();
    std::vector<int> candies(n, 1);
    for (int i = 1; i < n; i++)
        if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
    for (int i = n - 2; i >= 0; i--)
        if (ratings[i] > ratings[i + 1]) candies[i] = std::max(candies[i], candies[i + 1] + 1);
    int sum = 0;
    for (int c : candies) sum += c;
    return sum;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Candy\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {1, 0, 2};
    std::cout << "[1,0,2] -> " << candy(a1) << "\n";

    std::vector<int> a2 = {1, 2, 2};
    std::cout << "[1,2,2] -> " << candy(a2) << "\n";

    std::vector<int> a3 = {1, 3, 2, 2, 1};
    std::cout << "[1,3,2,2,1] -> " << candy(a3) << "\n";
}