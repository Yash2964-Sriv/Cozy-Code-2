"""
Basic DSA - House Robber
You cannot rob two adjacent houses; maximize the total money robbed.
"""


def rob(nums):
    """
    Dynamic programming with O(1) state: (skip_prev_best, take_prev_best) rolled into two vars.
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    skip = take = 0
    for x in nums:
        skip, take = take, max(take, skip + x)
    return max(skip, take)


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: House Robber")
    print("=" * 60)

    tests = [
        ([1, 2, 3, 1], 4),
        ([2, 7, 9, 3, 1], 12),
        ([2, 1, 1, 2], 4),
        ([5], 5),
        ([], 0),
    ]

    for nums, expected in tests:
        got = rob(nums)
        print(f"nums={nums} -> {got} (expected {expected})")