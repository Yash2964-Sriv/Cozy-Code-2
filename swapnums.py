
"""
Basic DSA Problems - Two More Fundamental Questions
Simple and essential DSA problems for beginners
"""


# Problem 1: Swap Two Numbers
# Swap two numbers using different methods

def swap_with_temp(a, b):
    """
    Swap two numbers using temporary variable
    Time Complexity: O(1)
    Space Complexity: O(1)
    """
    temp = a
    a = b
    b = temp
    return a, b


def swap_without_temp_arithmetic(a, b):
    """
    Swap two numbers without temporary variable (using arithmetic)
    Time Complexity: O(1)
    Space Complexity: O(1)
    """
    a = a + b
    b = a - b
    a = a - b
    return a, b


def swap_without_temp_xor(a, b):
    """
    Swap two numbers without temporary variable (using XOR)
    Time Complexity: O(1)
    Space Complexity: O(1)
    """
    a = a ^ b
    b = a ^ b
    a = a ^ b
    return a, b


# Problem 2: Find All Factors of a Number
# Find all factors (divisors) of a given number

def find_factors(n):
    """
    Find all factors of a number
    Time Complexity: O(n)
    Space Complexity: O(√n) for storing factors
    """
    if n == 0:
        return []
    
    n = abs(n)
    factors = []
    
    for i in range(1, n + 1):
        if n % i == 0:
            factors.append(i)
    
    return factors


def find_factors_optimized(n):
    """
    Find all factors of a number (optimized - only iterate up to √n)
    Time Complexity: O(√n)
    Space Complexity: O(√n)
    """
    if n == 0:
        return []
    
    n = abs(n)
    factors = []
    
    # Iterate only up to √n
    i = 1
    while i * i <= n:
        if n % i == 0:
            factors.append(i)
            # If i != n/i, then n/i is also a factor
            if i != n // i:
                factors.append(n // i)
        i += 1
    
    # Sort factors for better readability
    factors.sort()
    return factors


def count_factors(n):
    """
    Count the number of factors of a number
    Time Complexity: O(√n)
    Space Complexity: O(1)
    """
    if n == 0:
        return 0
    
    n = abs(n)
    count = 0
    
    i = 1
    while i * i <= n:
        if n % i == 0:
            count += 1
            if i != n // i:
                count += 1
        i += 1
    
    return count


# Test cases
if __name__ == "__main__":
    print("=" * 60)
    print("Problem 1: Swap Two Numbers")
    print("=" * 60)
    
    # Test Case 1
    a1, b1 = 10, 20
    print(f"Before swap: a = {a1}, b = {b1}")
    a_swapped1, b_swapped1 = swap_with_temp(a1, b1)
    print(f"After swap (with temp): a = {a_swapped1}, b = {b_swapped1}")
    
    # Test Case 2 - Without temp (arithmetic)
    a2, b2 = 15, 25
    print(f"\nBefore swap: a = {a2}, b = {b2}")
    a_swapped2, b_swapped2 = swap_without_temp_arithmetic(a2, b2)
    print(f"After swap (arithmetic): a = {a_swapped2}, b = {b_swapped2}")
    
    # Test Case 3 - Without temp (XOR)
    a3, b3 = 7, 13
    print(f"\nBefore swap: a = {a3}, b = {b3}")
    a_swapped3, b_swapped3 = swap_without_temp_xor(a3, b3)
    print(f"After swap (XOR): a = {a_swapped3}, b = {b_swapped3}")
    
    # Test Case 4 - Negative numbers
    a4, b4 = -5, 10
    print(f"\nBefore swap: a = {a4}, b = {b4}")
    a_swapped4, b_swapped4 = swap_without_temp_xor(a4, b4)
    print(f"After swap (XOR): a = {a_swapped4}, b = {b_swapped4}")
    
    # Test Case 5 - Same numbers
    a5, b5 = 42, 42
    print(f"\nBefore swap: a = {a5}, b = {b5}")
    a_swapped5, b_swapped5 = swap_without_temp_xor(a5, b5)
    print(f"After swap (XOR): a = {a_swapped5}, b = {b_swapped5}")
    
    print("\n" + "=" * 60)
    print("Problem 2: Find All Factors of a Number")
    print("=" * 60)
    
    # Test Case 1
    num1 = 12
    factors1 = find_factors(num1)
    factors_opt1 = find_factors_optimized(num1)
    count1 = count_factors(num1)
    print(f"Number: {num1}")
    print(f"Factors (Brute Force): {factors1}")
    print(f"Factors (Optimized): {factors_opt1}")
    print(f"Number of factors: {count1}")
    
    # Test Case 2
    num2 = 24
    factors2 = find_factors(num2)
    factors_opt2 = find_factors_optimized(num2)
    count2 = count_factors(num2)
    print(f"\nNumber: {num2}")
    print(f"Factors (Brute Force): {factors2}")
    print(f"Factors (Optimized): {factors_opt2}")
    print(f"Number of factors: {count2}")
    
    # Test Case 3 - Prime number
    num3 = 17
    factors3 = find_factors(num3)
    factors_opt3 = find_factors_optimized(num3)
    count3 = count_factors(num3)
    print(f"\nNumber: {num3}")
    print(f"Factors (Brute Force): {factors3}")
    print(f"Factors (Optimized): {factors_opt3}")
    print(f"Number of factors: {count3}")
    
    # Test Case 4 - Perfect square
    num4 = 16
    factors4 = find_factors(num4)
    factors_opt4 = find_factors_optimized(num4)
    count4 = count_factors(num4)
    print(f"\nNumber: {num4}")
    print(f"Factors (Brute Force): {factors4}")
    print(f"Factors (Optimized): {factors_opt4}")
    print(f"Number of factors: {count4}")
    
    # Test Case 5 - Single factor (1)
    num5 = 1
    factors5 = find_factors(num5)
    factors_opt5 = find_factors_optimized(num5)
    count5 = count_factors(num5)
    print(f"\nNumber: {num5}")
    print(f"Factors (Brute Force): {factors5}")
    print(f"Factors (Optimized): {factors_opt5}")
    print(f"Number of factors: {count5}")
    
    # Test Case 6 - Large number
    num6 = 100
    factors6 = find_factors(num6)
    factors_opt6 = find_factors_optimized(num6)
    count6 = count_factors(num6)
    print(f"\nNumber: {num6}")
    print(f"Factors (Brute Force): {factors6}")
    print(f"Factors (Optimized): {factors_opt6}")
    print(f"Number of factors: {count6}")
