/**
 * Basic DSA - Design Twitter (LeetCode 355)
 * postTweet appends with a global clock; getNewsFeed merges each followed user's timeline via a max-heap (latest 10).
 */
#include <iostream>
#include <queue>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>

struct Twitter {
    int time = 0;
    std::unordered_map<int, std::unordered_set<int>> following;
    std::unordered_map<int, std::vector<std::pair<int, int>>> tweets; // user -> (time, tweetId)

    void postTweet(int userId, int tweetId) {
        tweets[userId].push_back({time++, tweetId});
    }

    void follow(int followerId, int followeeId) { following[followerId].insert(followeeId); }

    void unfollow(int followerId, int followeeId) { following[followerId].erase(followeeId); }

    std::vector<int> getNewsFeed(int userId) {
        using Node = std::tuple<int, int, int, int>; // time, tweetId, userId, index
        auto cmp = [](const Node& a, const Node& b) { return std::get<0>(a) < std::get<0>(b); };
        std::priority_queue<Node, std::vector<Node>, decltype(cmp)> pq(cmp);

        auto seed = [&](int uid) {
            if (tweets[uid].empty())
                return;
            int idx = static_cast<int>(tweets[uid].size()) - 1;
            pq.push({tweets[uid][static_cast<size_t>(idx)].first, tweets[uid][static_cast<size_t>(idx)].second, uid,
                     idx});
        };
        seed(userId);
        for (int uid : following[userId])
            seed(uid);

        std::vector<int> out;
        while (!pq.empty() && static_cast<int>(out.size()) < 10) {
            Node top = pq.top();
            pq.pop();
            out.push_back(std::get<1>(top));
            int uid = std::get<2>(top);
            int idx = std::get<3>(top);
            if (idx > 0) {
                --idx;
                pq.push({tweets[uid][static_cast<size_t>(idx)].first, tweets[uid][static_cast<size_t>(idx)].second, uid,
                         idx});
            }
        }
        return out;
    }
};

void printFeed(const std::vector<int>& v) {
    std::cout << "[";
    for (size_t i = 0; i < v.size(); ++i) {
        if (i) std::cout << ",";
        std::cout << v[i];
    }
    std::cout << "]\n";
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Design Twitter\n";
    std::cout << std::string(60, '=') << "\n";

    Twitter tw;
    tw.postTweet(1, 5);
    printFeed(tw.getNewsFeed(1));
    tw.follow(1, 2);
    tw.postTweet(2, 6);
    printFeed(tw.getNewsFeed(1));
    tw.unfollow(1, 2);
    printFeed(tw.getNewsFeed(1));
}