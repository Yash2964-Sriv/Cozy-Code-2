import java.util.*;

/**
 * Array DSA Interview Problems
 * Collection of common array problems with solutions
 */
public class array_problems {

    // Problem 1: Two Sum  Problem
    // Given an array of integers nums and an integer target,
    // return indices of the two numbers such that they add up to target.
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        return new int[] {};
    }

    // Problem 2: Maximum Subarray (Kadane's Algorithm)
    // Find the contiguous subarray with the largest sum
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxSubarray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // Problem 3: Best Time to Buy and Sell Stock
    // Find the maximum profit from buying and selling stock once
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    // Problem 4: Contains Duplicate
    // Check if array contains any duplicates
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

    // Problem 5: Product of Array Except Self
    // Return an array output such that output[i] is equal to the
    // product of all elements of nums except nums[i]
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1) excluding output array
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        // Calculate left products
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Calculate right products and multiply
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    // Problem 6: Maximum Product Subarray
    // Find the contiguous subarray with the largest product
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProductSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);
            result = Math.max(result, maxProd);
        }

        return result;
    }

    // Problem 7: Find Minimum in Rotated Sorted Array
    // Find the minimum element in a rotated sorted array
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findMinRotated(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    // Problem 8: Search in Rotated Sorted Array
    // Search for target in rotated sorted array
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int searchRotated(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // Problem 9: 3Sum
    // Find all unique triplets that sum to zero
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) excluding output
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total < 0) {
                    left++;
                } else if (total > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return result;
    }

    // Problem 10: Container With Most Water
    // Find two lines that together with x-axis forms a container with most water
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
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

    // Problem 11: Merge Sorted Arrays
    // Merge two sorted arrays in-place (nums1 has enough space)
    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    // Problem 12: Rotate Array
    // Rotate array to the right by k steps
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Problem 13: Find First Repeating Element
    // Given an array of integers, find the first element that appears more than
    // once
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int findFirstRepeating(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find first element with count > 1
        for (int num : nums) {
            if (countMap.get(num) > 1) {
                return num;
            }
        }

        return -1; // No repeating element found
    }

    // Problem 14: Find Missing Number
    // Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
    // find the one that is missing from the array
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // Sum of numbers from 0 to n
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // Problem 15: Single Number
    // Given a non-empty array of integers where every element appears twice except
    // for one,
    // find the single one
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // Problem 16: Majority Element
    // Given an array of size n, find the element that appears more than n/2 times
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Uses Boyer-Moore Voting Algorithm
     */
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    // Problem 17: Count Occurrences of an Element
    // Given an array and a target value, count how many times the target appears in
    // the array
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countOccurrences(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    // Problem 18: Linear Search
    // Given an array and a target value, return the index of the target if found,
    // otherwise -1
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Problem 19: Binary Search (Any Occurrence)
    // Given a sorted array and a target value, return the index of the target if
    // found, otherwise -1
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

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

    // Problem 20: Find Maximum Element
    // Given an array, find the maximum element
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int maximum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maximum) {
                maximum = nums[i];
            }
        }
        return maximum;
    }

    // Problem 21: Check if Array is Sorted (Non-decreasing)
    // Given an array, check if it is sorted in non-decreasing order
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Problem 22: Find Minimum Element
    // Given an array, find the minimum element
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findMinElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int minimum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minimum) {
                minimum = nums[i];
            }
        }
        return minimum;
    }

    // Problem 23: Sum of Array Elements
    // Given an array, find the sum of all elements
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sumArray(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }

    // Problem 24: Reverse Array
    // Given an array, reverse it in-place
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // Problem 25: Count Even Numbers in Array
    // Given an array, count how many numbers are even
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countEvens(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Problem 26: Range of Array (Max - Min)
    // Given an array, find the difference between maximum and minimum elements
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int arrayRange(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int minimum = nums[0];
        int maximum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minimum) {
                minimum = nums[i];
            }
            if (nums[i] > maximum) {
                maximum = nums[i];
            }
        }

        return maximum - minimum;
    }

    // Problem 27: Count Odd Numbers in Array
    // Given an array, count how many numbers are odd
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countOdds(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    // Problem 28: Find Average of Array Elements
    // Given an array, find the average of all elements
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static double findAverage(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (double) sum / nums.length;
    }

    // Problem 29: Find Second Largest Element
    // Given an array, find the second largest element
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findSecondLargest(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element found");
        }

        return secondLargest;
    }

    // Problem 30: Find Second Smallest Element
    // Given an array, find the second smallest element
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findSecondSmallest(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("No second smallest element found");
        }

        return secondSmallest;
    }

    // Problem 31: Remove Duplicates from Sorted Array
    // Given a sorted array, remove duplicates in-place and return the new length
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int writeIndex = 1; // Position to write next unique element

        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            // If current element is different from previous, it's unique
            if (nums[readIndex] != nums[readIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }

        return writeIndex; // Return new length
    }

    // Problem 32: Move Zeros to End
    // Given an array, move all zeros to the end while maintaining the relative
    // order of non-zero elements
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void moveZerosToEnd(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int writeIndex = 0; // Position to write next non-zero element

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        // Fill remaining positions with zeros
        while (writeIndex < nums.length) {
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }

    // Problem 33: Find All Duplicates in Array
    // Given an array of integers, find all elements that appear twice
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findAllDuplicates(int[] nums) {
        java.util.List<Integer> duplicates = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return duplicates;
        }

        java.util.Map<Integer, Integer> frequency = new java.util.HashMap<>();

        // Count frequency of each element
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Find all elements that appear twice
        for (java.util.Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 2) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    // Problem 34: Find Peak Element
    // A peak element is an element that is greater than its neighbors
    // Given an array, find any peak element's index
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        // If array has only one element, it's a peak
        if (nums.length == 1) {
            return 0;
        }

        // Check first element
        if (nums[0] > nums[1]) {
            return 0;
        }

        // Check last element
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        // Check middle elements
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        // If no peak found (shouldn't happen in valid input), return -1
        return -1;
    }

    // Problem 35: Find Maximum Product of Two Elements
    // Given an array, find the maximum product of any two elements
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxProductOfTwo(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Find two largest and two smallest elements
        for (int num : nums) {
            // Update two largest
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            // Update two smallest
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        // Maximum product can be either (max1 * max2) or (min1 * min2) for negative
        // numbers
        return Math.max(max1 * max2, min1 * min2);
    }

    // Problem 36: Check if Array is Palindrome
    // Given an array, check if it reads the same forwards and backwards
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isPalindrome(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true; // Empty array is considered palindrome
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] != nums[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Problem 37: Find All Unique Elements
    // Given an array, find all elements that appear exactly once
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findUniqueElements(int[] nums) {
        java.util.List<Integer> unique = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return unique;
        }

        java.util.Map<Integer, Integer> frequency = new java.util.HashMap<>();

        // Count frequency of each element
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Find all elements that appear exactly once
        for (java.util.Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                unique.add(entry.getKey());
            }
        }

        return unique;
    }

    // Problem 38: Find All Positive Numbers
    // Given an array, find all positive numbers (greater than 0)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findAllPositive(int[] nums) {
        java.util.List<Integer> positive = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return positive;
        }

        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            }
        }

        return positive;
    }

    // Problem 39: Find All Negative Numbers
    // Given an array, find all negative numbers (less than 0)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findAllNegative(int[] nums) {
        java.util.List<Integer> negative = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return negative;
        }

        for (int num : nums) {
            if (num < 0) {
                negative.add(num);
            }
        }

        return negative;
    }

    // Problem 40: Count Zeros in Array
    // Given an array, count how many zeros are present
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countZeros(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        return count;
    }

    // Problem 41: Find Minimum Sum of Two Elements
    // Given an array, find the minimum sum of any two elements
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int minSumOfTwo(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Find two smallest elements
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return min1 + min2;
    }

    // Problem 42: Find Maximum Difference Between Two Elements
    // Given an array, find the maximum difference between two elements (max - min)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxDifference(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max - min;
    }

    // Problem 43: Find Minimum Difference Between Two Elements
    // Given an array, find the minimum absolute difference between any two elements
    /**
     * Time Complexity: O(n log n) - due to sorting
     * Space Complexity: O(1)
     */
    public static int minDifference(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        // Sort the array to find minimum difference between adjacent elements
        java.util.Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        // Find minimum difference between adjacent elements
        for (int i = 1; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    // Problem 44: Find All Elements Greater Than a Value
    // Given an array and a value, find all elements greater than that value
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findElementsGreaterThan(int[] nums, int value) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int num : nums) {
            if (num > value) {
                result.add(num);
            }
        }

        return result;
    }

    // Problem 45: Find All Elements Less Than a Value
    // Given an array and a value, find all elements less than that value
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findElementsLessThan(int[] nums, int value) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int num : nums) {
            if (num < value) {
                result.add(num);
            }
        }

        return result;
    }

    // Problem 46: Find All Elements Equal To a Value
    // Given an array and a value, find all elements equal to that value
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findElementsEqualTo(int[] nums, int value) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int num : nums) {
            if (num == value) {
                result.add(num);
            }
        }

        return result;
    }

    // Problem 47: Find All Elements Between Two Values
    // Given an array and two values (min and max), find all elements between them
    // (inclusive)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findElementsBetween(int[] nums, int min, int max) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Ensure min <= max
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        for (int num : nums) {
            if (num >= min && num <= max) {
                result.add(num);
            }
        }

        return result;
    }

    // Problem 48: Find Sum of All Elements Greater Than a Value
    // Given an array and a value, find the sum of all elements greater than that
    // value
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sumElementsGreaterThan(int[] nums, int value) {
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return sum;
        }

        for (int num : nums) {
            if (num > value) {
                sum += num;
            }
        }

        return sum;
    }

    // Problem 49: Find Sum of All Elements Less Than a Value
    // Given an array and a value, find the sum of all elements less than that value
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sumElementsLessThan(int[] nums, int value) {
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return sum;
        }

        for (int num : nums) {
            if (num < value) {
                sum += num;
            }
        }

        return sum;
    }

    // Problem 50: Find Sum of All Elements Equal To a Value
    // Given an array and a value, find the sum of all elements equal to that value
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sumElementsEqualTo(int[] nums, int value) {
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return sum;
        }

        for (int num : nums) {
            if (num == value) {
                sum += num;
            }
        }

        return sum;
    }

    // Problem 51: Find Sum of All Elements Between Two Values
    // Given an array and two values (min and max), find the sum of all elements
    // between them (inclusive)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sumElementsBetween(int[] nums, int min, int max) {
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return sum;
        }

        // Ensure min <= max
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        for (int num : nums) {
            if (num >= min && num <= max) {
                sum += num;
            }
        }

        return sum;
    }

    // Problem 52: Find Product of All Elements
    // Given an array, find the product of all elements
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static long productOfAllElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        long product = 1;
        for (int num : nums) {
            product *= num;
        }

        return product;
    }

    // Problem 53: Find All Elements at Even Indices
    // Given an array, find all elements at even indices (0, 2, 4, ...)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findElementsAtEvenIndices(int[] nums) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i += 2) {
            result.add(nums[i]);
        }

        return result;
    }

    // Problem 54: Find All Elements at Odd Indices
    // Given an array, find all elements at odd indices (1, 3, 5, ...)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static java.util.List<Integer> findElementsAtOddIndices(int[] nums) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 1; i < nums.length; i += 2) {
            result.add(nums[i]);
        }

        return result;
    }

    // Problem 55: Find Sum of Elements at Even Indices
    // Given an array, find the sum of all elements at even indices (0, 2, 4, ...)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sumElementsAtEvenIndices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    // Problem 56: Find Sum of Elements at Odd Indices
    // Given an array, find the sum of all elements at odd indices (1, 3, 5, ...)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int sumElementsAtOddIndices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    // Problem 57: Find Index of Last Occurrence of Element
    // Given an array and a target, return the index of the last occurrence of
    // target, or -1 if not found
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int lastIndexOf(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Problem 58: Find Index of Minimum Element
    // Given an array, return the index of the smallest element
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int indexOfMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int minIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    // Problem 59: Find Index of Maximum Element
    // Given an array, return the index of the largest element
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int indexOfMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    // Problem 60: Check if Array Contains Value
    // Given an array and a target, return true if target exists in array, false
    // otherwise
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean contains(int[] nums, int target) {
        if (nums == null) {
            return false;
        }
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Problem 61: Find All Indices of an Element
    // Given an array and a target, return list of all indices where target appears
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k), k = number of occurrences
     */
    public static java.util.List<Integer> findAllIndices(int[] nums, int target) {
        java.util.List<Integer> indices = new java.util.ArrayList<>();
        if (nums == null) {
            return indices;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indices.add(i);
            }
        }
        return indices;
    }

    // Problem 62: Replace All Occurrences of a Value
    // Given an array, replace all occurrences of oldVal with newVal in-place
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void replaceAll(int[] nums, int oldVal, int newVal) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == oldVal) {
                nums[i] = newVal;
            }
        }
    }

    // Problem 63: Create Array Filled with Value
    // Given length and value, return a new array of that length filled with the
    // value
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] createFilledArray(int length, int value) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be non-negative");
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = value;
        }
        return result;
    }

    // Problem 64: Copy Array
    // Given an array, return a new array with the same elements (shallow copy)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] copyArray(int[] nums) {
        if (nums == null) {
            return null;
        }
        return Arrays.copyOf(nums, nums.length);
    }

    // Problem 65: Swap Two Elements in Array
    // Given an array and two indices, swap the elements at those indices in-place
    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static void swap(int[] nums, int i, int j) {
        if (nums == null || i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
            throw new IllegalArgumentException("Invalid array or indices");
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Problem 66: Find Maximum in Range
    // Given an array and range [start, end] (inclusive), return the maximum element
    // in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static int maxInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int max = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    // Problem 67: Find Minimum in Range
    // Given an array and range [start, end] (inclusive), return the minimum element in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static int minInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int min = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    // Problem 68: Find Sum in Range
    // Given an array and range [start, end] (inclusive), return the sum of elements in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static int sumInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    // Problem 69: Find Average in Range
    // Given an array and range [start, end] (inclusive), return the average of elements in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static double averageInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int sum = 0;
        int count = end - start + 1;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return (double) sum / count;
    }

    // Problem 70: Count Distinct Elements
    // Given an array, return the count of unique (distinct) elements
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int countDistinct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }

    // Problem 71: Check if Array Has All Unique Elements
    // Given an array, return true if all elements are distinct, false otherwise
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean hasAllUnique(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return false;
            }
        }
        return true;
    }

    // Problem 72: Rotate Array Left by K Positions
    // Given an array and k, rotate the array left by k positions (elements wrap around)
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void rotateLeft(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }
        int n = nums.length;
        k = ((k % n) + n) % n; // handle negative k
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }

    // Problem 73: Find Third Largest Element
    // Given an array, return the third largest distinct element
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findThirdLargest(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 elements");
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num != first) {
                third = second;
                second = num;
            } else if (num > third && num != second && num != first) {
                third = num;
            }
        }
        if (third == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Array does not have 3 distinct elements");
        }
        return third;
    }

    // Problem 74: Find Third Smallest Element
    // Given an array, return the third smallest distinct element
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findThirdSmallest(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 elements");
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < first) {
                third = second;
                second = first;
                first = num;
            } else if (num < second && num != first) {
                third = second;
                second = num;
            } else if (num < third && num != second && num != first) {
                third = num;
            }
        }
        if (third == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Array does not have 3 distinct elements");
        }
        return third;
    }

    // Problem 75: Check if Array is Sorted in Descending Order
    // Given an array, return true if each element is >= the next, false otherwise
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isSortedDescending(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Problem 76: Find Largest Even Element
    // Given an array, return the largest even element, or Integer.MIN_VALUE if no even element exists
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findLargestEven(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int maxEven = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num % 2 == 0 && num > maxEven) {
                maxEven = num;
            }
        }
        return maxEven;
    }

    // Problem 77: Find Smallest Odd Element
    // Given an array, return the smallest odd element, or Integer.MAX_VALUE if no odd element exists
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findSmallestOdd(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int minOdd = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 != 0 && num < minOdd) {
                minOdd = num;
            }
        }
        return minOdd;
    }

    // Problem 78: Find Smallest Even Element
    // Given an array, return the smallest even element, or Integer.MAX_VALUE if no even element exists
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findSmallestEven(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int minEven = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 0 && num < minEven) {
                minEven = num;
            }
        }
        return minEven;
    }

    // Problem 79: Find Largest Odd Element
    // Given an array, return the largest odd element, or Integer.MIN_VALUE if no odd element exists
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findLargestOdd(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int maxOdd = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num % 2 != 0 && num > maxOdd) {
                maxOdd = num;
            }
        }
        return maxOdd;
    }

    // Problem 80: Find Product in Range
    // Given an array and range [start, end] (inclusive), return the product of elements in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static long productInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        long product = 1;
        for (int i = start; i <= end; i++) {
            product *= nums[i];
        }
        return product;
    }

    // Problem 81: Find Index of Maximum in Range
    // Given an array and range [start, end] (inclusive), return the index of the maximum element in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static int indexOfMaxInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int maxIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    // Problem 82: Find Index of Minimum in Range
    // Given an array and range [start, end] (inclusive), return the index of the minimum element in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static int indexOfMinInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int minIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    // Problem 83: Count Even Numbers in Range
    // Given an array and range [start, end] (inclusive), return the count of even elements in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static int countEvensInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Problem 84: Count Odd Numbers in Range
    // Given an array and range [start, end] (inclusive), return the count of odd elements in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static int countOddsInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    // Problem 85: Check if All Elements in Range are Positive
    // Given an array and range [start, end] (inclusive), return true if all elements in that range are > 0
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static boolean allPositiveInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        for (int i = start; i <= end; i++) {
            if (nums[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    // Problem 86: Check if All Elements in Range are Negative
    // Given an array and range [start, end] (inclusive), return true if all elements in that range are < 0
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static boolean allNegativeInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        for (int i = start; i <= end; i++) {
            if (nums[i] >= 0) {
                return false;
            }
        }
        return true;
    }

    // Problem 87: Count Zeros in Range
    // Given an array and range [start, end] (inclusive), return the count of zeros in that range
    /**
     * Time Complexity: O(end - start + 1)
     * Space Complexity: O(1)
     */
    public static int countZerosInRange(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid array or range");
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        return count;
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Test cases
    public static void main(String[] args) {
        // Test Two Sum
        System.out.println("Problem 1 - Two Sum:");
        printArray(twoSum(new int[] { 2, 7, 11, 15 }, 9)); // Output: [0, 1]

        // Test Maximum Subarray
        System.out.println("\nProblem 2 - Maximum Subarray:");
        System.out.println(maxSubarray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })); // Output: 6

        // Test Max Profit
        System.out.println("\nProblem 3 - Best Time to Buy and Sell Stock:");
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // Output: 5

        // Test Contains Duplicate
        System.out.println("\nProblem 4 - Contains Duplicate:");
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 })); // Output: true

        // Test Product Except Self
        System.out.println("\nProblem 5 - Product of Array Except Self:");
        printArray(productExceptSelf(new int[] { 1, 2, 3, 4 })); // Output: [24, 12, 8, 6]

        // Test Max Product Subarray
        System.out.println("\nProblem 6 - Maximum Product Subarray:");
        System.out.println(maxProductSubarray(new int[] { 2, 3, -2, 4 })); // Output: 6

        // Test Find Min Rotated
        System.out.println("\nProblem 7 - Find Minimum in Rotated Sorted Array:");
        System.out.println(findMinRotated(new int[] { 3, 4, 5, 1, 2 })); // Output: 1

        // Test Search Rotated
        System.out.println("\nProblem 8 - Search in Rotated Sorted Array:");
        System.out.println(searchRotated(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // Output: 4

        // Test 3Sum
        System.out.println("\nProblem 9 - 3Sum:");
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 })); // Output: [[-1, -1, 2], [-1, 0, 1]]

        // Test Max Area
        System.out.println("\nProblem 10 - Container With Most Water:");
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // Output: 49

        // Test Merge Sorted Arrays
        System.out.println("\nProblem 11 - Merge Sorted Arrays:");
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        mergeSortedArrays(nums1, 3, new int[] { 2, 5, 6 }, 3);
        printArray(nums1); // Output: [1, 2, 2, 3, 5, 6]

        // Test Rotate Array
        System.out.println("\nProblem 12 - Rotate Array:");
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        rotateArray(nums, 3);
        printArray(nums); // Output: [5, 6, 7, 1, 2, 3, 4]

        // Test Find First Repeating
        System.out.println("\nProblem 13 - Find First Repeating Element:");
        System.out.println(findFirstRepeating(new int[] { 10, 5, 3, 4, 3, 5, 6 })); // Output: 5

        // Test Find Missing Number
        System.out.println("\nProblem 14 - Find Missing Number:");
        System.out.println(findMissingNumber(new int[] { 3, 0, 1 })); // Output: 2

        // Test Single Number
        System.out.println("\nProblem 15 - Single Number:");
        System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 })); // Output: 4

        // Test Majority Element
        System.out.println("\nProblem 16 - Majority Element:");
        System.out.println(majorityElement(new int[] { 3, 2, 3 })); // Output: 3

        // Test Count Occurrences
        System.out.println("\nProblem 17 - Count Occurrences of Element:");
        System.out.println(countOccurrences(new int[] { 1, 2, 2, 3, 2, 4 }, 2)); // Output: 3

        // Test Linear Search
        System.out.println("\nProblem 18 - Linear Search:");
        System.out.println(linearSearch(new int[] { 4, 2, 7, 1, 9 }, 7)); // Output: 2

        // Test Binary Search
        System.out.println("\nProblem 19 - Binary Search (Any Occurrence):");
        System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5, 6 }, 4)); // Output: 3

        // Test Find Maximum Element
        System.out.println("\nProblem 20 - Find Maximum Element:");
        System.out.println(findMax(new int[] { 3, 1, 7, 0, 5 })); // Output: 7

        // Test Check if Array is Sorted
        System.out.println("\nProblem 21 - Check if Array is Sorted:");
        System.out.println(isSorted(new int[] { 1, 2, 2, 3, 5 })); // Output: true

        // Test Find Minimum Element
        System.out.println("\nProblem 22 - Find Minimum Element:");
        System.out.println(findMinElement(new int[] { 3, 1, 7, 0, 5 })); // Output: 0

        // Test Sum of Array Elements
        System.out.println("\nProblem 23 - Sum of Array Elements:");
        System.out.println(sumArray(new int[] { 1, 2, 3, 4, 5 })); // Output: 15

        // Test Reverse Array
        System.out.println("\nProblem 24 - Reverse Array:");
        int[] nums24 = { 1, 2, 3, 4, 5 };
        reverseArray(nums24);
        printArray(nums24); // Output: [5, 4, 3, 2, 1]

        // Test Count Even Numbers in Array
        System.out.println("\nProblem 25 - Count Even Numbers in Array:");
        System.out.println(countEvens(new int[] { 1, 2, 3, 4, 6 })); // Output: 3

        // Test Range of Array (Max - Min)
        System.out.println("\nProblem 26 - Range of Array (Max - Min):");
        System.out.println(arrayRange(new int[] { 3, 1, 7, 0, 5 })); // Output: 7

        // Test Count Odd Numbers in Array
        System.out.println("\nProblem 27 - Count Odd Numbers in Array:");
        System.out.println(countOdds(new int[] { 1, 2, 3, 4, 5 })); // Output: 3

        // Test Find Average of Array Elements
        System.out.println("\nProblem 28 - Find Average of Array Elements:");
        System.out.println(findAverage(new int[] { 1, 2, 3, 4, 5 })); // Output: 3.0

        // Test Find Second Largest Element
        System.out.println("\nProblem 29 - Find Second Largest Element:");
        System.out.println(findSecondLargest(new int[] { 3, 1, 7, 0, 5 })); // Output: 5

        // Test Find Second Smallest Element
        System.out.println("\nProblem 30 - Find Second Smallest Element:");
        System.out.println(findSecondSmallest(new int[] { 3, 1, 7, 0, 5 })); // Output: 1

        // Test Remove Duplicates from Sorted Array
        System.out.println("\nProblem 31 - Remove Duplicates from Sorted Array:");
        int[] nums31 = { 1, 1, 2, 2, 3, 4, 4, 5 };
        int newLength = removeDuplicates(nums31);
        System.out.println("New length: " + newLength); // Output: 5
        System.out.print("Array after removal: ");
        printArray(nums31); // Output: [1, 2, 3, 4, 5, ...]

        // Test Move Zeros to End
        System.out.println("\nProblem 32 - Move Zeros to End:");
        int[] nums32 = { 0, 1, 0, 3, 12 };
        moveZerosToEnd(nums32);
        printArray(nums32); // Output: [1, 3, 12, 0, 0]

        // Test Find All Duplicates in Array
        System.out.println("\nProblem 33 - Find All Duplicates in Array:");
        System.out.println(findAllDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 })); // Output: [2, 3]

        // Test Find Peak Element
        System.out.println("\nProblem 34 - Find Peak Element:");
        System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 })); // Output: 2

        // Test Find Maximum Product of Two Elements
        System.out.println("\nProblem 35 - Find Maximum Product of Two Elements:");
        System.out.println(maxProductOfTwo(new int[] { 1, 2, 3, 4, 5 })); // Output: 20

        // Test Check if Array is Palindrome
        System.out.println("\nProblem 36 - Check if Array is Palindrome:");
        System.out.println(isPalindrome(new int[] { 1, 2, 3, 2, 1 })); // Output: true
        System.out.println(isPalindrome(new int[] { 1, 2, 3, 4, 5 })); // Output: false

        // Test Find All Unique Elements
        System.out.println("\nProblem 37 - Find All Unique Elements:");
        System.out.println(findUniqueElements(new int[] { 1, 2, 2, 3, 4, 4, 5 })); // Output: [1, 3, 5]

        // Test Find All Positive Numbers
        System.out.println("\nProblem 38 - Find All Positive Numbers:");
        System.out.println(findAllPositive(new int[] { -1, 2, -3, 4, 0, 5, -6 })); // Output: [2, 4, 5]

        // Test Find All Negative Numbers
        System.out.println("\nProblem 39 - Find All Negative Numbers:");
        System.out.println(findAllNegative(new int[] { -1, 2, -3, 4, 0, 5, -6 })); // Output: [-1, -3, -6]

        // Test Count Zeros in Array
        System.out.println("\nProblem 40 - Count Zeros in Array:");
        System.out.println(countZeros(new int[] { 0, 1, 0, 3, 0, 5, 0 })); // Output: 4

        // Test Find Minimum Sum of Two Elements
        System.out.println("\nProblem 41 - Find Minimum Sum of Two Elements:");
        System.out.println(minSumOfTwo(new int[] { 5, 2, 8, 1, 9 })); // Output: 3

        // Test Find Maximum Difference Between Two Elements
        System.out.println("\nProblem 42 - Find Maximum Difference Between Two Elements:");
        System.out.println(maxDifference(new int[] { 7, 2, 9, 5, 1 })); // Output: 8

        // Test Find Minimum Difference Between Two Elements
        System.out.println("\nProblem 43 - Find Minimum Difference Between Two Elements:");
        System.out.println(minDifference(new int[] { 7, 2, 9, 5, 1 })); // Output: 1

        // Test Find All Elements Greater Than a Value
        System.out.println("\nProblem 44 - Find All Elements Greater Than a Value:");
        System.out.println(findElementsGreaterThan(new int[] { 1, 5, 3, 8, 2, 7 }, 4)); // Output: [5, 8, 7]

        // Test Find All Elements Less Than a Value
        System.out.println("\nProblem 45 - Find All Elements Less Than a Value:");
        System.out.println(findElementsLessThan(new int[] { 1, 5, 3, 8, 2, 7 }, 4)); // Output: [1, 3, 2]

        // Test Find All Elements Equal To a Value
        System.out.println("\nProblem 46 - Find All Elements Equal To a Value:");
        System.out.println(findElementsEqualTo(new int[] { 1, 5, 3, 5, 2, 5 }, 5)); // Output: [5, 5, 5]

        // Test Find All Elements Between Two Values
        System.out.println("\nProblem 47 - Find All Elements Between Two Values:");
        System.out.println(findElementsBetween(new int[] { 1, 5, 3, 8, 2, 7, 4 }, 3, 6)); // Output: [5, 3, 4]

        // Test Find Sum of All Elements Greater Than a Value
        System.out.println("\nProblem 48 - Find Sum of All Elements Greater Than a Value:");
        System.out.println(sumElementsGreaterThan(new int[] { 1, 5, 3, 8, 2, 7 }, 4)); // Output: 20

        // Test Find Sum of All Elements Less Than a Value
        System.out.println("\nProblem 49 - Find Sum of All Elements Less Than a Value:");
        System.out.println(sumElementsLessThan(new int[] { 1, 5, 3, 8, 2, 7 }, 4)); // Output: 6

        // Test Find Sum of All Elements Equal To a Value
        System.out.println("\nProblem 50 - Find Sum of All Elements Equal To a Value:");
        System.out.println(sumElementsEqualTo(new int[] { 1, 5, 3, 5, 2, 5 }, 5)); // Output: 15

        // Test Find Sum of All Elements Between Two Values
        System.out.println("\nProblem 51 - Find Sum of All Elements Between Two Values:");
        System.out.println(sumElementsBetween(new int[] { 1, 5, 3, 8, 2, 7, 4 }, 3, 6)); // Output: 12

        // Test Find Product of All Elements
        System.out.println("\nProblem 52 - Find Product of All Elements:");
        System.out.println(productOfAllElements(new int[] { 1, 2, 3, 4 })); // Output: 24

        // Test Find All Elements at Even Indices
        System.out.println("\nProblem 53 - Find All Elements at Even Indices:");
        System.out.println(findElementsAtEvenIndices(new int[] { 10, 20, 30, 40, 50, 60 })); // Output: [10, 30, 50]

        // Test Find All Elements at Odd Indices
        System.out.println("\nProblem 54 - Find All Elements at Odd Indices:");
        System.out.println(findElementsAtOddIndices(new int[] { 10, 20, 30, 40, 50, 60 })); // Output: [20, 40, 60]

        // Test Find Sum of Elements at Even Indices
        System.out.println("\nProblem 55 - Find Sum of Elements at Even Indices:");
        System.out.println(sumElementsAtEvenIndices(new int[] { 10, 20, 30, 40, 50, 60 })); // Output: 90

        // Test Find Sum of Elements at Odd Indices
        System.out.println("\nProblem 56 - Find Sum of Elements at Odd Indices:");
        System.out.println(sumElementsAtOddIndices(new int[] { 10, 20, 30, 40, 50, 60 })); // Output: 120

        // Test Find Index of Last Occurrence of Element
        System.out.println("\nProblem 57 - Find Index of Last Occurrence of Element:");
        System.out.println(lastIndexOf(new int[] { 2, 5, 3, 5, 7, 5, 9 }, 5)); // Output: 5

        // Test Find Index of Minimum Element
        System.out.println("\nProblem 58 - Find Index of Minimum Element:");
        System.out.println(indexOfMin(new int[] { 3, 1, 7, 0, 5 })); // Output: 3

        // Test Find Index of Maximum Element
        System.out.println("\nProblem 59 - Find Index of Maximum Element:");
        System.out.println(indexOfMax(new int[] { 3, 1, 7, 0, 5 })); // Output: 2

        // Test Check if Array Contains Value
        System.out.println("\nProblem 60 - Check if Array Contains Value:");
        System.out.println(contains(new int[] { 1, 5, 3, 8, 2 }, 8)); // Output: true
        System.out.println(contains(new int[] { 1, 5, 3, 8, 2 }, 4)); // Output: false

        // Test Find All Indices of an Element
        System.out.println("\nProblem 61 - Find All Indices of an Element:");
        System.out.println(findAllIndices(new int[] { 2, 5, 3, 5, 7, 5, 9 }, 5)); // Output: [1, 3, 5]

        // Test Replace All Occurrences of a Value
        System.out.println("\nProblem 62 - Replace All Occurrences of a Value:");
        int[] nums62 = { 1, 2, 2, 3, 2, 4 };
        replaceAll(nums62, 2, 9);
        printArray(nums62); // Output: [1, 9, 9, 3, 9, 4]

        // Test Create Array Filled with Value
        System.out.println("\nProblem 63 - Create Array Filled with Value:");
        printArray(createFilledArray(5, 7)); // Output: [7, 7, 7, 7, 7]

        // Test Copy Array
        System.out.println("\nProblem 64 - Copy Array:");
        printArray(copyArray(new int[] { 1, 2, 3, 4, 5 })); // Output: [1, 2, 3, 4, 5]

        // Test Swap Two Elements in Array
        System.out.println("\nProblem 65 - Swap Two Elements in Array:");
        int[] nums65 = { 10, 20, 30, 40, 50 };
        swap(nums65, 0, 4);
        printArray(nums65); // Output: [50, 20, 30, 40, 10]

        // Test Find Maximum in Range
        System.out.println("\nProblem 66 - Find Maximum in Range:");
        System.out.println(maxInRange(new int[] { 3, 1, 7, 0, 5, 9, 2 }, 1, 5)); // Output: 9

        // Test Find Minimum in Range
        System.out.println("\nProblem 67 - Find Minimum in Range:");
        System.out.println(minInRange(new int[] { 3, 1, 7, 0, 5, 9, 2 }, 1, 5)); // Output: 0

        // Test Find Sum in Range
        System.out.println("\nProblem 68 - Find Sum in Range:");
        System.out.println(sumInRange(new int[] { 1, 2, 3, 4, 5, 6 }, 1, 4)); // Output: 14

        // Test Find Average in Range
        System.out.println("\nProblem 69 - Find Average in Range:");
        System.out.println(averageInRange(new int[] { 1, 2, 3, 4, 5, 6 }, 1, 4)); // Output: 3.5

        // Test Count Distinct Elements
        System.out.println("\nProblem 70 - Count Distinct Elements:");
        System.out.println(countDistinct(new int[] { 1, 2, 2, 3, 4, 4, 4, 5 })); // Output: 5

        // Test Check if Array Has All Unique Elements
        System.out.println("\nProblem 71 - Check if Array Has All Unique Elements:");
        System.out.println(hasAllUnique(new int[] { 1, 2, 3, 4, 5 })); // Output: true
        System.out.println(hasAllUnique(new int[] { 1, 2, 2, 3, 4 })); // Output: false

        // Test Rotate Array Left by K Positions
        System.out.println("\nProblem 72 - Rotate Array Left by K Positions:");
        int[] nums72 = { 1, 2, 3, 4, 5 };
        rotateLeft(nums72, 2);
        printArray(nums72); // Output: [3, 4, 5, 1, 2]

        // Test Find Third Largest Element
        System.out.println("\nProblem 73 - Find Third Largest Element:");
        System.out.println(findThirdLargest(new int[] { 3, 2, 1, 5, 4 })); // Output: 3

        // Test Find Third Smallest Element
        System.out.println("\nProblem 74 - Find Third Smallest Element:");
        System.out.println(findThirdSmallest(new int[] { 5, 2, 8, 1, 9, 3 })); // Output: 3

        // Test Check if Array is Sorted in Descending Order
        System.out.println("\nProblem 75 - Check if Array is Sorted in Descending Order:");
        System.out.println(isSortedDescending(new int[] { 5, 4, 3, 2, 1 })); // Output: true
        System.out.println(isSortedDescending(new int[] { 5, 3, 4, 2, 1 })); // Output: false

        // Test Find Largest Even Element
        System.out.println("\nProblem 76 - Find Largest Even Element:");
        System.out.println(findLargestEven(new int[] { 1, 3, 6, 2, 8, 5, 4 })); // Output: 8

        // Test Find Smallest Odd Element
        System.out.println("\nProblem 77 - Find Smallest Odd Element:");
        System.out.println(findSmallestOdd(new int[] { 4, 7, 2, 9, 5, 3, 8 })); // Output: 3

        // Test Find Smallest Even Element
        System.out.println("\nProblem 78 - Find Smallest Even Element:");
        System.out.println(findSmallestEven(new int[] { 5, 6, 8, 2, 9, 4 })); // Output: 2

        // Test Find Largest Odd Element
        System.out.println("\nProblem 79 - Find Largest Odd Element:");
        System.out.println(findLargestOdd(new int[] { 2, 5, 8, 9, 3, 7, 4 })); // Output: 9

        // Test Find Product in Range
        System.out.println("\nProblem 80 - Find Product in Range:");
        System.out.println(productInRange(new int[] { 1, 2, 3, 4, 5 }, 1, 3)); // Output: 24

        // Test Find Index of Maximum in Range
        System.out.println("\nProblem 81 - Find Index of Maximum in Range:");
        System.out.println(indexOfMaxInRange(new int[] { 3, 1, 7, 0, 5, 9, 2 }, 1, 5)); // Output: 5

        // Test Find Index of Minimum in Range
        System.out.println("\nProblem 82 - Find Index of Minimum in Range:");
        System.out.println(indexOfMinInRange(new int[] { 3, 1, 7, 0, 5, 9, 2 }, 1, 5)); // Output: 3

        // Test Count Even Numbers in Range
        System.out.println("\nProblem 83 - Count Even Numbers in Range:");
        System.out.println(countEvensInRange(new int[] { 2, 3, 4, 5, 6, 7 }, 1, 4)); // Output: 2

        // Test Count Odd Numbers in Range
        System.out.println("\nProblem 84 - Count Odd Numbers in Range:");
        System.out.println(countOddsInRange(new int[] { 2, 3, 4, 5, 6, 7 }, 1, 4)); // Output: 2

        // Test Check if All Elements in Range are Positive
        System.out.println("\nProblem 85 - Check if All Elements in Range are Positive:");
        System.out.println(allPositiveInRange(new int[] { 1, 2, 3, 4, 5 }, 0, 4)); // Output: true
        System.out.println(allPositiveInRange(new int[] { 1, -2, 3, 4 }, 0, 3)); // Output: false

        // Test Check if All Elements in Range are Negative
        System.out.println("\nProblem 86 - Check if All Elements in Range are Negative:");
        System.out.println(allNegativeInRange(new int[] { -1, -2, -3 }, 0, 2)); // Output: true
        System.out.println(allNegativeInRange(new int[] { -1, 2, -3 }, 0, 2)); // Output: false

        // Test Count Zeros in Range
        System.out.println("\nProblem 87 - Count Zeros in Range:");
        System.out.println(countZerosInRange(new int[] { 1, 0, 2, 0, 3, 0 }, 0, 5)); // Output: 3
    }
}