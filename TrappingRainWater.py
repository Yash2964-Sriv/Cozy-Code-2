"""
Basic DSA - Trapping Rain Water
Given n non-negative integers representing bar heights, compute how much water can be trapped after raining.
"""


def trap(height):
    """
    Two pointers from both ends; track max left and max right.
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    left, right = 0, len(height) - 1
    max_left = max_right = 0
    water = 0

    while left < right:
        if height[left] < height[right]:
            if height[left] >= max_left:
                max_left = height[left]
            else:
                water += max_left - height[left]
            left += 1
        else:
            if height[right] >= max_right:
                max_right = height[right]
            else:
                water += max_right - height[right]
            right -= 1

    return water


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Trapping Rain Water")
    print("=" * 60)

    tests = [
        ([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], 6),
        ([4, 2, 0, 3, 2, 5], 9),
        ([3, 0, 2, 0, 4], 7),
        ([], 0),
    ]

    for h, expected in tests:
        got = trap(h)
        print(f"height={h} -> {got} (expected {expected})")