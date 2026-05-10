"""
Basic DSA - Word Break
Return True if s can be segmented into a space-separated sequence of one or more dictionary words.
"""


def word_break(s, word_list):
    """
    DP: dp[i] means s[:i] can be segmented.
    Time Complexity: O(n^3) naive substring checks; word set lookup is O(1)
    Space Complexity: O(n)
    """
    words = set(word_list)
    n = len(s)
    dp = [False] * (n + 1)
    dp[0] = True

    for i in range(1, n + 1):
        for j in range(i):
            if dp[j] and s[j:i] in words:
                dp[i] = True
                break

    return dp[n]


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Word Break")
    print("=" * 60)

    tests = [
        ("leetcode", ["leet", "code"], True),
        ("applepenapple", ["apple", "pen"], True),
        ("catsandog", ["cats", "dog", "sand", "and", "cat"], False),
        ("", ["a"], True),
    ]

    for s, words, expected in tests:
        got = word_break(s, words)
        print(f"s={s!r} -> {got} (expected {expected})")