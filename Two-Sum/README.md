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
