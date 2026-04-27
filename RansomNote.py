
"""
Basic DSA - Ransom Note
Return True if ransom_note can be constructed from magazine (each letter can be used once).
"""


def can_construct(ransom_note, magazine):
    """
    Count letters in magazine then consume for ransom_note.
    Time Complexity: O(n + m)
    Space Complexity: O(1) for fixed alphabet, otherwise O(k)
    """
    counts = {}
    for ch in magazine:
        counts[ch] = counts.get(ch, 0) + 1

    for ch in ransom_note:
        if counts.get(ch, 0) == 0:
            return False
        counts[ch] -= 1
    return True


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Ransom Note")
    print("=" * 60)

    print(can_construct("a", "b"))      # False
    print(can_construct("aa", "ab"))    # False
    print(can_construct("aa", "aab"))   # True