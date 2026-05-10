+"""
Basic DSA - LRU Cache
Least Recently Used cache with fixed capacity: get and put in O(1) average time.
"""

from collections import OrderedDict


class LRUCache:
    """
    OrderedDict maintains insertion order; move_to_end marks key as most recently used.
    Time Complexity: O(1) average for get/put
    Space Complexity: O(capacity)
    """

    def __init__(self, capacity):
        self._cap = capacity
        self._data = OrderedDict()

    def get(self, key):
        if key not in self._data:
            return -1
        self._data.move_to_end(key)
        return self._data[key]

    def put(self, key, value):
        if key in self._data:
            self._data.move_to_end(key)
        self._data[key] = value
        if len(self._data) > self._cap:
            self._data.popitem(last=False)


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: LRU Cache")
    print("=" * 60)

    cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    print(f"get(1) -> {cache.get(1)} (expected 1)")
    cache.put(3, 3)
    print(f"get(2) -> {cache.get(2)} (expected -1)")
    cache.put(4, 4)
    print(f"get(1) -> {cache.get(1)} (expected -1)")
    print(f"get(3) -> {cache.get(3)} (expected 3)")
    print(f"get(4) -> {cache.get(4)} (expected 4)")