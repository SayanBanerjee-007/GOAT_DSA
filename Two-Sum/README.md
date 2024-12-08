# Two Sum

[LeetCode](https://leetcode.com/problems/two-sum/description/)

## Difficulty Level

- **Easy**

## Topics Covered

- Array
- Hash Table

## Problem Statement

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

## Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`

## Example

**Input:**

```plaintext
nums = [2, 7, 11, 15], target = 9
```

**Output:**

```plaintext
[0, 1]
```

**Explanation:**

Because `nums[0] + nums[1] == 9`, we return `[0, 1]`.

## Overview of Two Sum Approaches

| Approach                   | Time Complexity | Space Complexity | Description                                                                                                                    |
| -------------------------- | --------------- | ---------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| Brute Force                | O(n²)           | O(1)             | Checks every possible pair in the array to find the sum. Simple but inefficient for large arrays.                              |
| Two-Pointer (Sorted Array) | O(n log n)      | O(n)             | Sorts the array and uses two pointers to find the sum. Requires sorting, which increases time complexity.                      |
| Two-Pass Hash Table        | O(n)            | O(n)             | Populates a hash table with elements in the first pass and finds the complement in the second pass.                            |
| One-Pass Hash Table        | O(n)            | O(n)             | Uses a single pass through the array, storing elements and checking for complements on the fly. Optimal for most cases.        |
| Set Approach               | O(n)            | O(n)             | Uses a set to store elements and checks if the complement exists while iterating. May require additional code to find indices. |

## Detailed Descriptions of Two Sum Problem Approaches

## 1. Brute Force Approach

### Approach:

This is the simplest solution where we check every possible pair of elements in the array to see if they add up to the target. It involves nested loops that compare each pair of numbers.

### Complexity:

- **Time Complexity**: O(n²) because of the nested loops iterating over the array.
- **Space Complexity**: O(1) as no extra space is required.

### Use Case:

Best for educational purposes and when `n` is small. It demonstrates the brute-force method clearly but is inefficient for larger inputs.

---

## 2. Two-Pointer Approach (Sorted Array)

### Approach:

This approach works if the array is sorted (or can be sorted). We use two pointers, one starting at the beginning and the other at the end of the array, and move them toward each other. If the sum of the numbers at the two pointers is less than the target, we move the left pointer to the right. If the sum is greater, we move the right pointer to the left. If the sum matches the target, we return the indices.

### Complexity:

- **Time Complexity**: O(n log n) due to sorting the array, followed by an O(n) traversal.
- **Space Complexity**: O(n) for storing the sorted array.

### Use Case:

Effective for finding pairs in a sorted array where sorting is acceptable. This is often used when we have to work with sorted data.

---

## 3. Two-Pass Hash Table Approach

### Approach:

We use a hash table to store the elements and their indices in two passes. In the first pass, we populate the hash table with the array elements and their indices. In the second pass, we check if the complement of each element (i.e., `target - nums[i]`) exists in the hash table.

### Complexity:

- **Time Complexity**: O(n) because we iterate through the array twice.
- **Space Complexity**: O(n) for storing the hash table.

### Use Case:

Useful when we need to find pairs efficiently and are okay with a two-pass approach. This method ensures that the solution is found quickly even with larger arrays.

---

## 4. One-Pass Hash Map Approach

### Approach:

In this optimized approach, we iterate through the array once and use a hash map to store the elements we've seen so far. For each element, we check if its complement (i.e., `target - nums[i]`) exists in the hash map and return the indices immediately upon finding a match.

### Complexity:

- **Time Complexity**: O(n) due to a single pass through the array with constant-time hash map operations.
- **Space Complexity**: O(n) for storing the hash map.

### Use Case:

Ideal for scenarios where you need to find a solution in a single pass. It is the most efficient method for solving the "Two Sum" problem in terms of time complexity.

---

## 5. Set Approach (Alternative Hashing)

### Approach:

This approach uses a set to store the numbers we have seen so far. As we iterate through the array, we check if the complement of the current element (i.e., `target - nums[i]`) is present in the set. If so, we return the indices of the current element and its complement.

### Complexity:

- **Time Complexity**: O(n) due to a single pass through the array and constant-time set operations.
- **Space Complexity**: O(n) for storing the set of seen numbers.

### Use Case:

Works well when you want to use simple data structures like sets and don't need to return indices directly. It may require extra code for finding the index of the complement.

---
