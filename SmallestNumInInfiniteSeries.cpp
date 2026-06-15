#include <set>

class SmallestInfiniteSet {
private:
    int nextSmallest = 1;
    std::set<int> addedBack;

public:
    SmallestInfiniteSet() = default;

    int popSmallest() {
        if (!addedBack.empty()) {
            const int smallest = *addedBack.begin();
            addedBack.erase(addedBack.begin());
            return smallest;
        }

        return nextSmallest++;
    }

    void addBack(int num) {
        if (num < nextSmallest) {
            addedBack.insert(num);
        }
    }
};
