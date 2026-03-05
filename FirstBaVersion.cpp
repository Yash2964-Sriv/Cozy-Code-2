/**
 * Basic DSA - First Bad Version (LeetCode 278)
 * Binary search for first bad version.
 */
#include <iostream>

static int BAD_VERSION = 4;

bool isBadVersion(int v) { return v >= BAD_VERSION; }

int firstBadVersion(int n) {
    int lo = 1, hi = n, ans = n;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (isBadVersion(mid)) {
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: First Bad Version\n";
    std::cout << std::string(60, '=') << "\n";

    BAD_VERSION = 4;
    std::cout << "n=5, bad=4 -> " << firstBadVersion(5) << "\n";

    BAD_VERSION = 1;
    std::cout << "n=1, bad=1 -> " << firstBadVersion(1) << "\n";

    BAD_VERSION = 2;
    std::cout << "n=3, bad=2 -> " << firstBadVersion(3) << "\n";
}