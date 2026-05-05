"""
Basic DSA - Coin Change
Return the fewest number of coins needed to make up amount using coins of given denominations.
If amount cannot be made, return -1. You may use each coin type unlimited times.
"""


def coin_change(coins, amount):
    """
    Unbounded knapsack style DP on amounts 0..amount.
    Time Complexity: O(amount * len(coins))
    Space Complexity: O(amount)
    """
    dp = [float("inf")] * (amount + 1)
    dp[0] = 0

    for x in range(1, amount + 1):
        for c in coins:
            if c <= x:
                dp[x] = min(dp[x], dp[x - c] + 1)

    return int(dp[amount]) if dp[amount] != float("inf") else -1


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Coin Change")
    print("=" * 60)

    tests = [
        ([1, 2, 5], 11, 3),
        ([2], 3, -1),
        ([1], 0, 0),
        ([1], 1, 1),
        ([186, 419, 83, 408], 6249, 20),
    ]

    for coins, amount, expected in tests:
        got = coin_change(coins, amount)
        print(f"coins={coins}, amount={amount} -> {got} (expected {expected})")