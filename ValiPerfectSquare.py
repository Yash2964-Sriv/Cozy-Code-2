"""
Basic DSA - Valid Perfect Square
Return True if num is a perfect square, otherwise False (without using sqrt).
"""


def is_perfect_square(num):
    """
    Binary search on 1..num.
    Time Complexity: O(log num)
    Space Complexity: O(1)
    """
    if num < 0:
        return False
    if num < 2:
        return True

    left, right = 1, num
    while left <= right:
        mid = left + (right - left) // 2
        sq = mid * mid
        if sq == num:
            return True
        if sq < num:
            left = mid + 1
        else:
            right = mid - 1
    return False


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Valid Perfect Square")
    print("=" * 60)

    tests = [
        (16, True),
        (14, False),
        (1, True),
        (0, True),
        (808201, True),  # 899^2
    ]

    for n, expected in tests:
        got = is_perfect_square(n)
        print(f"num={n} -> {got} (expected {expected})")