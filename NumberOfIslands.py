"""
Basic DSA - Number of Islands
Count connected components of '1' cells in a grid of '1' (land) and '0' (water).
Four-directionally connected cells belong to the same island.
"""


def num_islands(grid):
    """
    DFS flood fill; marks visited land as '0' to avoid extra memory.
    Time Complexity: O(rows * cols)
    Space Complexity: O(rows * cols) recursion stack worst case
    """
    if not grid:
        return 0

    rows, cols = len(grid), len(grid[0])

    def dfs(r, c):
        if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] != "1":
            return
        grid[r][c] = "0"
        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)

    count = 0
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == "1":
                count += 1
                dfs(r, c)
    return count


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Number of Islands")
    print("=" * 60)

    def clone(g):
        return [list(row) for row in g]

    tests = [
        (
            [
                ["1", "1", "1", "1", "0"],
                ["1", "1", "0", "1", "0"],
                ["1", "1", "0", "0", "0"],
                ["0", "0", "0", "0", "0"],
            ],
            1,
        ),
        (
            [
                ["1", "1", "0", "0", "0"],
                ["1", "1", "0", "0", "0"],
                ["0", "0", "1", "0", "0"],
                ["0", "0", "0", "1", "1"],
            ],
            3,
        ),
        ([], 0),
    ]

    for grid, expected in tests:
        got = num_islands(clone(grid))
        print(f"islands -> {got} (expected {expected})")