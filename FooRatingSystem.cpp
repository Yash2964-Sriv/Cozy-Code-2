/**
 * Basic DSA - Food Rating System (LeetCode 2353)
 * changeRating updates a food score; highestRated returns best food in a cuisine. Per-cuisine min-heap on (-rating, name) with lazy stale pops.
 */
#include <functional>
#include <iostream>
#include <queue>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>

struct FoodRatings {
    std::unordered_map<std::string, std::pair<int, std::string>> info; // food -> (rating, cuisine)
    std::unordered_map<std::string,
                        std::priority_queue<std::pair<int, std::string>, std::vector<std::pair<int, std::string>>,
                                            std::greater<std::pair<int, std::string>>>>
        best;

    FoodRatings(const std::vector<std::string>& foods, const std::vector<std::string>& cuisines,
                const std::vector<int>& ratings) {
        for (size_t i = 0; i < foods.size(); ++i) {
            info[foods[i]] = {ratings[i], cuisines[i]};
            best[cuisines[i]].push({-ratings[i], foods[i]});
        }
    }

    void changeRating(const std::string& food, int newRating) {
        const std::string& cuisine = info[food].second;
        info[food].first = newRating;
        best[cuisine].push({-newRating, food});
    }

    std::string highestRated(const std::string& cuisine) {
        auto& pq = best[cuisine];
        while (-pq.top().first != info[pq.top().second].first)
            pq.pop();
        return pq.top().second;
    }
};

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Food Rating System\n";
    std::cout << std::string(60, '=') << "\n";

    FoodRatings fr({"kimchi", "miso", "sushi", "moussaka", "ramen", "kapustka"},
                   {"korean", "japanese", "japanese", "greek", "japanese", "polish"},
                   {9, 12, 8, 15, 14, 10});
    std::cout << "highest japanese -> " << fr.highestRated("japanese") << "\n";
    fr.changeRating("sushi", 16);
    std::cout << "after sushi=16   -> " << fr.highestRated("japanese") << "\n";
    fr.changeRating("ramen", 16);
    std::cout << "after ramen=16   -> " << fr.highestRated("japanese") << "\n";
}