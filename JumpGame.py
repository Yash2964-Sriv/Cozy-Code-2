"""
Basic DSA - Jump Game
You start at index 0 of an array nums where nums[i] is your maximum jump length from i.
Return True if you can reach the last index, otherwise False.
"""


def can_jump(nums):
    """
    Track the farthest index reachable from processed positions.
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    reach = 0
    for i, x in enumerate(nums):
        if i > reach:
            return False
        reach = max(reach, i + x)
    return True


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Jump Game")
    print("=" * 60)

    tests = [
        ([2, 3, 1, 1, 4], True),
        ([3, 2, 1, 0, 4], False),
        ([0], True),
        ([2, 0], True),
        ([0, 1], False),
    ]

    for nums, expected in tests:
        got = can_jump(nums)
        print(f"nums={nums} -> {got} (expected {expected})")