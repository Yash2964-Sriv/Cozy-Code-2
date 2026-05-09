"""
Basic DSA - Spiral Matrix
Return all elements of a matrix in clockwise spiral order.
"""


def spiral_order(matrix):
    """
    Layer by layer: shrink top, bottom, left, right boundaries.
    Time Complexity: O(rows * cols)
    Space Complexity: O(1) extra excluding output list
    """
    if not matrix or not matrix[0]:
        return []

    rows, cols = len(matrix), len(matrix[0])
    top, bottom = 0, rows - 1
    left, right = 0, cols - 1
    result = []

    while top <= bottom and left <= right:
        for c in range(left, right + 1):
            result.append(matrix[top][c])
        top += 1

        for r in range(top, bottom + 1):
            result.append(matrix[r][right])
        right -= 1

        if top <= bottom:
            for c in range(right, left - 1, -1):
                result.append(matrix[bottom][c])
            bottom -= 1

        if left <= right:
            for r in range(bottom, top - 1, -1):
                result.append(matrix[r][left])
            left += 1

    return result


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Spiral Matrix")
    print("=" * 60)

    m1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    e1 = [1, 2, 3, 6, 9, 8, 7, 4, 5]
    print(f"matrix={m1} -> {spiral_order(m1)} (expected {e1})")

    m2 = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
    e2 = [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    print(f"matrix={m2} -> {spiral_order(m2)} (expected {e2})")