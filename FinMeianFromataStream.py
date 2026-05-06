"""
Basic DSA - Find Median from Data Stream
Maintain a multiset of integers and return the median after each insertion.
"""

import heapq


class MedianFinder:
    """
    Two heaps: max-heap `lo` for the smaller half, min-heap `hi` for the larger half.
    `lo` may have one extra element when the total count is odd.
    """

    def __init__(self):
        self._lo = []  # store negatives for max-heap behavior
        self._hi = []

    def add_num(self, num):
        heapq.heappush(self._lo, -num)
        heapq.heappush(self._hi, -heapq.heappop(self._lo))
        if len(self._hi) > len(self._lo):
            heapq.heappush(self._lo, -heapq.heappop(self._hi))

    def find_median(self):
        if len(self._lo) > len(self._hi):
            return float(-self._lo[0])
        return (-self._lo[0] + self._hi[0]) / 2.0


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Find Median from Data Stream")
    print("=" * 60)

    mf = MedianFinder()
    mf.add_num(1)
    mf.add_num(2)
    print(f"median after 1,2 -> {mf.find_median()} (expected 1.5)")
    mf.add_num(3)
    print(f"median after 1,2,3 -> {mf.find_median()} (expected 2.0)")