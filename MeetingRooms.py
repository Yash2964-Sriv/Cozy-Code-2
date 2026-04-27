"""
Basic DSA - Meeting Rooms (Can Attend All Meetings)
Given a list of meeting time intervals, determine if a person could attend all meetings.
"""


def can_attend_meetings(intervals):
    """
    Sort by start time; any overlap means cannot attend all.
    Time Complexity: O(n log n)
    Space Complexity: O(1) extra (excluding sort)
    """
    intervals = sorted(intervals, key=lambda x: x[0])
    for i in range(1, len(intervals)):
        if intervals[i][0] < intervals[i - 1][1]:
            return False
    return True


if __name__ == "__main__":
    print("=" * 60)
    print("Problem: Meeting Rooms (Can Attend All Meetings)")
    print("=" * 60)

    print(can_attend_meetings([[0, 30], [5, 10], [15, 20]]))  # False
    print(can_attend_meetings([[7, 10], [2, 4]]))  # True