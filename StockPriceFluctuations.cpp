/**
 * Basic DSA - Stock Price Fluctuation (LeetCode 2034)
 * Time-ordered prices; current is latest timestamp. Multiset tracks all prices for O(log n) min/max.
 */
#include <iostream>
#include <map>
#include <set>

struct StockPrice {
    std::map<int, int> rec;
    std::multiset<int> prices;

    void update(int timestamp, int price) {
        if (rec.count(timestamp))
            prices.erase(prices.find(rec[timestamp]));
        rec[timestamp] = price;
        prices.insert(price);
    }

    int current() const { return rec.rbegin()->second; }

    int maximum() const { return *prices.rbegin(); }

    int minimum() const { return *prices.begin(); }
};

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Stock Price Fluctuation\n";
    std::cout << std::string(60, '=') << "\n";

    StockPrice sp;
    sp.update(1, 10);
    sp.update(2, 5);
    std::cout << "current  -> " << sp.current() << "\n";
    std::cout << "maximum  -> " << sp.maximum() << "\n";
    std::cout << "minimum  -> " << sp.minimum() << "\n";
    sp.update(1, 3);
    std::cout << "after update(1,3) max -> " << sp.maximum() << "\n";
    std::cout << "after update(1,3) min -> " << sp.minimum() << "\n";
}