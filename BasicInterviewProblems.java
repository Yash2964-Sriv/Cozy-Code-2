import java.util.*;

/**
 * Basic DSA Interview Problems
 * Collection of fundamental DSA problems covering stacks, queues, trees,
 * binary search, two pointers, and sliding window techniques
 */
public class BasicInterviewProblems {
    
    // ==================== STACK PROBLEMS ====================
    
    // Problem 1: Valid Parentheses
    // Check if parentheses in string are valid using stack
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
        
        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != mapping.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
    
    // Problem 2: Min Stack
    // Design a stack that supports push, pop, top, and getMin in O(1)
    /**
     * Time Complexity: O(1) for all operations
     * Space Complexity: O(n)
     */
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }
        
        public void pop() {
            if (!stack.isEmpty()) {
                int val = stack.pop();
                if (val == minStack.peek()) {
                    minStack.pop();
                }
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
    }
    
    // Problem 3: Daily Temperatures
    // Find next greater temperature for each day
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        
        return result;
    }
    
    // ==================== QUEUE PROBLEMS ====================
    
    // Problem 4: Implement Queue using Stacks
    // Design a queue using two stacks
    /**
     * Time Complexity: O(1) amortized
     * Space Complexity: O(n)
     */
    static class MyQueue {
        private Stack<Integer> inputStack;
        private Stack<Integer> outputStack;
        
        public MyQueue() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }
        
        public void push(int x) {
            inputStack.push(x);
        }
        
        public int pop() {
            moveToOutput();
            return outputStack.pop();
        }
        
        public int peek() {
            moveToOutput();
            return outputStack.peek();
        }
        
        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
        
        private void moveToOutput() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
        }
    }
    
    // Problem 5: Sliding Window Maximum
    // Find maximum in each sliding window
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove indices outside window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            // Remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offerLast(i);
            
            // Add to result when window is complete
            if (i >= k - 1) {
                result.add(nums[dq.peekFirst()]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    // ==================== BINARY SEARCH PROBLEMS ====================
    
    // Problem 6: Binary Search
    // Search target in sorted array
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    // Problem 7: First Bad Version
    // Find first bad version using binary search
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int firstBadVersion(int n, boolean[] versions) {
        int left = 1, right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (versions[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // Problem 8: Search Insert Position
    // Find index where target should be inserted
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    // ==================== TWO POINTER PROBLEMS ====================
    
    // Problem 9: Two Sum (Sorted Array)
    // Find two numbers that add up to target
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int[] twoSumSorted(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{};
    }
    
    // Problem 10: Remove Duplicates from Sorted Array
    // Remove duplicates in-place
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int writeIndex = 1;
        
        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[readIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        
        return writeIndex;
    }
    
    // Problem 11: Valid Palindrome
    // Check if string is palindrome using two pointers
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    // Problem 12: Container With Most Water
    // Find two lines that form container with most water
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        
        while (left < right) {
            int width = right - left;
            int currentArea = Math.min(height[left], height[right]) * width;
            maxWater = Math.max(maxWater, currentArea);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
    
    // ==================== SLIDING WINDOW PROBLEMS ====================
    
    // Problem 13: Maximum Average Subarray
    // Find contiguous subarray with maximum average
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        double maxSum = currentSum;
        
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum / k;
    }
    
    // Problem 14: Minimum Window Substring
    // Find minimum window containing all characters of pattern
    /**
     * Time Complexity: O(|s| + |t|)
     * Space Complexity: O(|s| + |t|)
     */
    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }
        
        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }
        
        int required = dictT.size();
        int left = 0, right = 0;
        int formed = 0;
        
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    
    // Problem 15: Longest Substring Without Repeating Characters
    // Find length of longest substring without repeating characters
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(min(n, m))
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (charMap.containsKey(c) && charMap.get(c) >= start) {
                start = charMap.get(c) + 1;
            }
            
            charMap.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
    
    // ==================== HASH TABLE PROBLEMS ====================
    
    // Problem 16: Two Sum
    // Find two numbers that add up to target
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        
        return new int[]{};
    }
    
    // Problem 17: Contains Duplicate
    // Check if array contains duplicates
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
    
    // Problem 18: Group Anagrams
    // Group strings that are anagrams
    /**
     * Time Complexity: O(n * k log k)
     * Space Complexity: O(n * k)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            if (!anagramMap.containsKey(sorted)) {
                anagramMap.put(sorted, new ArrayList<>());
            }
            anagramMap.get(sorted).add(s);
        }
        
        return new ArrayList<>(anagramMap.values());
    }
    
    // ==================== TREE PROBLEMS (Basic) ====================
    
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    // Problem 19: Maximum Depth of Binary Tree
    // Find maximum depth of binary tree
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    // Problem 20: Same Tree
    // Check if two trees are identical
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null) {
            return false;
        }
        
        return p.val == q.val && 
               isSameTree(p.left, q.left) && 
               isSameTree(p.right, q.right);
    }
    
    // Problem 21: Invert Binary Tree
    // Invert a binary tree
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
    
    // Problem 22: Symmetric Tree
    // Check if tree is symmetric
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && 
               isMirror(left.left, right.right) && 
               isMirror(left.right, right.left);
    }
    
    // Helper methods for printing
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println("Problem 1 - Valid Parentheses:");
        System.out.println(validParentheses("()[]{}")); // true
        
        System.out.println("\nProblem 2 - Min Stack:");
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min: " + minStack.getMin()); // -3
        minStack.pop();
        System.out.println("Top: " + minStack.top()); // 0
        System.out.println("Min: " + minStack.getMin()); // -2
        
        System.out.println("\nProblem 3 - Daily Temperatures:");
        printArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        
        System.out.println("\nProblem 6 - Binary Search:");
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 3)); // 2
        
        System.out.println("\nProblem 8 - Search Insert Position:");
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        
        System.out.println("\nProblem 9 - Two Sum (Sorted):");
        printArray(twoSumSorted(new int[]{2, 7, 11, 15}, 9)); // [1, 2]
        
        System.out.println("\nProblem 12 - Container With Most Water:");
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        
        System.out.println("\nProblem 16 - Two Sum:");
        printArray(twoSum(new int[]{2, 7, 11, 15}, 9)); // [0, 1]
        
        System.out.println("\nProblem 17 - Contains Duplicate:");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1})); // true
    }
}