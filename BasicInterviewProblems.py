"""
Basic DSA Interview Problems
Collection of fundamental DSA problems covering stacks, queues, trees, 
binary search, two pointers, and sliding window techniques
"""

from collections import deque
import heapq


# ==================== STACK PROBLEMS ====================

# Problem 1: Valid Parentheses
# Check if parentheses in string are valid using stack
def valid_parentheses(s):
    """
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}
    
    for char in s:
        if char in mapping:
            top = stack.pop() if stack else '#'
            if mapping[char] != top:
                return False
        else:
            stack.append(char)
    
    return len(stack) == 0


# Problem 2: Min Stack
# Design a stack that supports push, pop, top, and getMin in O(1)
class MinStack:
    """
    Time Complexity: O(1) for all operations
    Space Complexity: O(n)
    """
    def __init__(self):
        self.stack = []
        self.min_stack = []
    
    def push(self, val):
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
    
    def pop(self):
        if self.stack:
            val = self.stack.pop()
            if val == self.min_stack[-1]:
                self.min_stack.pop()
            return val
    
    def top(self):
        return self.stack[-1] if self.stack else None
    
    def getMin(self):
        return self.min_stack[-1] if self.min_stack else None


# Problem 3: Daily Temperatures
# Find next greater temperature for each day
def daily_temperatures(temperatures):
    """
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    stack = []
    result = [0] * len(temperatures)
    
    for i, temp in enumerate(temperatures):
        while stack and temperatures[stack[-1]] < temp:
            idx = stack.pop()
            result[idx] = i - idx
        stack.append(i)
    
    return result


# ==================== QUEUE PROBLEMS ====================

# Problem 4: Implement Queue using Stacks
# Design a queue using two stacks
class MyQueue:
    """
    Time Complexity: O(1) amortized
    Space Complexity: O(n)
    """
    def __init__(self):
        self.input_stack = []
        self.output_stack = []
    
    def push(self, x):
        self.input_stack.append(x)
    
    def pop(self):
        self._move_to_output()
        return self.output_stack.pop()
    
    def peek(self):
        self._move_to_output()
        return self.output_stack[-1]
    
    def empty(self):
        return len(self.input_stack) == 0 and len(self.output_stack) == 0
    
    def _move_to_output(self):
        if not self.output_stack:
            while self.input_stack:
                self.output_stack.append(self.input_stack.pop())


# Problem 5: Sliding Window Maximum
# Find maximum in each sliding window
def max_sliding_window(nums, k):
    """
    Time Complexity: O(n)
    Space Complexity: O(k)
    """
    dq = deque()
    result = []
    
    for i in range(len(nums)):
        # Remove indices outside window
        while dq and dq[0] <= i - k:
            dq.popleft()
        
        # Remove smaller elements from back
        while dq and nums[dq[-1]] < nums[i]:
            dq.pop()
        
        dq.append(i)
        
        # Add to result when window is complete
        if i >= k - 1:
            result.append(nums[dq[0]])
    
    return result


# ==================== BINARY SEARCH PROBLEMS ====================

# Problem 6: Binary Search
# Search target in sorted array
def binary_search(nums, target):
    """
    Time Complexity: O(log n)
    Space Complexity: O(1)
    """
    left, right = 0, len(nums) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    
    return -1


# Problem 7: First Bad Version
# Find first bad version using binary search
def first_bad_version(n, isBadVersion):
    """
    Time Complexity: O(log n)
    Space Complexity: O(1)
    """
    left, right = 1, n
    
    while left < right:
        mid = left + (right - left) // 2
        if isBadVersion(mid):
            right = mid
        else:
            left = mid + 1
    
    return left


# Problem 8: Search Insert Position
# Find index where target should be inserted
def search_insert(nums, target):
    """
    Time Complexity: O(log n)
    Space Complexity: O(1)
    """
    left, right = 0, len(nums) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    
    return left


# ==================== TWO POINTER PROBLEMS ====================

# Problem 9: Two Sum (Sorted Array)
# Find two numbers that add up to target
def two_sum_sorted(numbers, target):
    """
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    left, right = 0, len(numbers) - 1
    
    while left < right:
        current_sum = numbers[left] + numbers[right]
        if current_sum == target:
            return [left + 1, right + 1]
        elif current_sum < target:
            left += 1
        else:
            right -= 1
    
    return []


# Problem 10: Remove Duplicates from Sorted Array
# Remove duplicates in-place
def remove_duplicates(nums):
    """
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    if not nums:
        return 0
    
    write_index = 1
    
    for read_index in range(1, len(nums)):
        if nums[read_index] != nums[read_index - 1]:
            nums[write_index] = nums[read_index]
            write_index += 1
    
    return write_index


# Problem 11: Valid Palindrome
# Check if string is palindrome using two pointers
def is_palindrome(s):
    """
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    left, right = 0, len(s) - 1
    
    while left < right:
        while left < right and not s[left].isalnum():
            left += 1
        while left < right and not s[right].isalnum():
            right -= 1
        
        if s[left].lower() != s[right].lower():
            return False
        
        left += 1
        right -= 1
    
    return True


# Problem 12: Container With Most Water
# Find two lines that form container with most water
def max_area(height):
    """
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    left, right = 0, len(height) - 1
    max_water = 0
    
    while left < right:
        width = right - left
        current_area = min(height[left], height[right]) * width
        max_water = max(max_water, current_area)
        
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1
    
    return max_water


# ==================== SLIDING WINDOW PROBLEMS ====================

# Problem 13: Maximum Average Subarray
# Find contiguous subarray with maximum average
def find_max_average(nums, k):
    """
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    current_sum = sum(nums[:k])
    max_sum = current_sum
    
    for i in range(k, len(nums)):
        current_sum = current_sum - nums[i - k] + nums[i]
        max_sum = max(max_sum, current_sum)
    
    return max_sum / k


# Problem 14: Minimum Window Substring
# Find minimum window containing all characters of pattern
def min_window(s, t):
    """
    Time Complexity: O(|s| + |t|)
    Space Complexity: O(|s| + |t|)
    """
    if not s or not t:
        return ""
    
    dict_t = {}
    for char in t:
        dict_t[char] = dict_t.get(char, 0) + 1
    
    required = len(dict_t)
    left, right = 0, 0
    formed = 0
    
    window_counts = {}
    ans = float("inf"), None, None
    
    while right < len(s):
        char = s[right]
        window_counts[char] = window_counts.get(char, 0) + 1
        
        if char in dict_t and window_counts[char] == dict_t[char]:
            formed += 1
        
        while left <= right and formed == required:
            char = s[left]
            
            if right - left + 1 < ans[0]:
                ans = (right - left + 1, left, right)
            
            window_counts[char] -= 1
            if char in dict_t and window_counts[char] < dict_t[char]:
                formed -= 1
            
            left += 1
        
        right += 1
    
    return "" if ans[0] == float("inf") else s[ans[1]:ans[2] + 1]


# Problem 15: Longest Substring Without Repeating Characters
# Find length of longest substring without repeating characters
def length_of_longest_substring(s):
    """
    Time Complexity: O(n)
    Space Complexity: O(min(n, m))
    """
    char_map = {}
    max_length = 0
    start = 0
    
    for end in range(len(s)):
        if s[end] in char_map and char_map[s[end]] >= start:
            start = char_map[s[end]] + 1
        
        char_map[s[end]] = end
        max_length = max(max_length, end - start + 1)
    
    return max_length


# ==================== HASH TABLE PROBLEMS ====================

# Problem 16: Two Sum
# Find two numbers that add up to target
def two_sum(nums, target):
    """
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    num_map = {}
    
    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_map:
            return [num_map[complement], i]
        num_map[num] = i
    
    return []


# Problem 17: Contains Duplicate
# Check if array contains duplicates
def contains_duplicate(nums):
    """
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    seen = set()
    for num in nums:
        if num in seen:
            return True
        seen.add(num)
    return False


# Problem 18: Group Anagrams
# Group strings that are anagrams
def group_anagrams(strs):
    """
    Time Complexity: O(n * k log k)
    Space Complexity: O(n * k)
    """
    anagram_map = {}
    
    for s in strs:
        sorted_s = ''.join(sorted(s))
        if sorted_s not in anagram_map:
            anagram_map[sorted_s] = []
        anagram_map[sorted_s].append(s)
    
    return list(anagram_map.values())


# ==================== TREE PROBLEMS (Basic) ====================

# Definition for a binary tree node
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# Problem 19: Maximum Depth of Binary Tree
# Find maximum depth of binary tree
def max_depth(root):
    """
    Time Complexity: O(n)
    Space Complexity: O(h) where h is height
    """
    if not root:
        return 0
    
    return 1 + max(max_depth(root.left), max_depth(root.right))


# Problem 20: Same Tree
# Check if two trees are identical
def is_same_tree(p, q):
    """
    Time Complexity: O(n)
    Space Complexity: O(h)
    """
    if not p and not q:
        return True
    
    if not p or not q:
        return False
    
    return (p.val == q.val and 
            is_same_tree(p.left, q.left) and 
            is_same_tree(p.right, q.right))


# Problem 21: Invert Binary Tree
# Invert a binary tree
def invert_tree(root):
    """
    Time Complexity: O(n)
    Space Complexity: O(h)
    """
    if not root:
        return None
    
    root.left, root.right = root.right, root.left
    invert_tree(root.left)
    invert_tree(root.right)
    
    return root


# Problem 22: Symmetric Tree
# Check if tree is symmetric
def is_symmetric(root):
    """
    Time Complexity: O(n)
    Space Complexity: O(h)
    """
    def is_mirror(left, right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        return (left.val == right.val and 
                is_mirror(left.left, right.right) and 
                is_mirror(left.right, right.left))
    
    return is_mirror(root, root) if root else True


# ==================== TEST CASES ====================

if __name__ == "__main__":
    print("Problem 1 - Valid Parentheses:")
    print(valid_parentheses("()[]{}"))  # True
    
    print("\nProblem 2 - Min Stack:")
    min_stack = MinStack()
    min_stack.push(-2)
    min_stack.push(0)
    min_stack.push(-3)
    print(f"Min: {min_stack.getMin()}")  # -3
    min_stack.pop()
    print(f"Top: {min_stack.top()}")  # 0
    print(f"Min: {min_stack.getMin()}")  # -2
    
    print("\nProblem 3 - Daily Temperatures:")
    print(daily_temperatures([73, 74, 75, 71, 69, 72, 76, 73]))
    
    print("\nProblem 5 - Sliding Window Maximum:")
    print(max_sliding_window([1, 3, -1, -3, 5, 3, 6, 7], 3))
    
    print("\nProblem 6 - Binary Search:")
    print(binary_search([1, 2, 3, 4, 5], 3))  # 2
    
    print("\nProblem 8 - Search Insert Position:")
    print(search_insert([1, 3, 5, 6], 5))  # 2
    
    print("\nProblem 9 - Two Sum (Sorted):")
    print(two_sum_sorted([2, 7, 11, 15], 9))  # [1, 2]
    
    print("\nProblem 10 - Remove Duplicates:")
    nums = [1, 1, 2]
    print(f"New length: {remove_duplicates(nums)}")  # 2
    
    print("\nProblem 12 - Container With Most Water:")
    print(max_area([1, 8, 6, 2, 5, 4, 8, 3, 7]))  # 49
    
    print("\nProblem 13 - Maximum Average Subarray:")
    print(find_max_average([1, 12, -5, -6, 50, 3], 4))  # 12.75
    
    print("\nProblem 16 - Two Sum:")
    print(two_sum([2, 7, 11, 15], 9))  # [0, 1]
    
    print("\nProblem 17 - Contains Duplicate:")
    print(contains_duplicate([1, 2, 3, 1]))  # True
    
    print("\nProblem 18 - Group Anagrams:")
    print(group_anagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))