"""
Basic DSA - Find Minimum in Rotated Sorted Array
Given a rotated sorted array of unique integers, return the minimum element.
"""


def find_min(nums):
    """
    Binary search on rotation pivot.
    Time Complexity: O(log n)
    Space Complexity: O(1)
    """
    if not nums:
        return None

    left, right = 0, len(nums) - 1
    while left < right:
        mid = left + (right - left) // 2
        if nums[mid] > nums[right]:
            left = mid + 1
        else:
            right = mid
    return nums[left]


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Find Minimum in Rotated Sorted Array")
    print("=" * 60)

    tests = [
        ([3, 4, 5, 1, 2], 1),
        ([4, 5, 6, 7, 0, 1, 2], 0),
        ([11, 13, 15, 17], 11),
        ([2, 1], 1),
        ([], None),
    ]

    for nums, expected in tests:
        got = find_min(nums)
        print(f"nums={nums} -> {got} (expected {expected})")