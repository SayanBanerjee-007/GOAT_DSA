# Single Number

[LeetCode](https://leetcode.com/problems/single-number/description/)

## Difficulty Level

- **Easy**

## Topics Covered

- Array
- Bit Manipulation

## Problem Statement

Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

## Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-3 * 10^4 <= nums[i] <= 3 * 10^4`
- Each element in the array appears twice except for one element which appears only once.

## Example

**Input:**

```plaintext
nums = [2, 2, 1]
```

**Output:**

```plaintext
1
```

**Explanation:**

The single number is `1`.

## Overview of Single Number Approaches

| Approach             | Time Complexity | Space Complexity | Description                                                                                                                       |
| -------------------- | --------------- | ---------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| **Sorting**          | O(n log n)      | O(1) or O(n)     | Sorts the array and checks for non-matching adjacent elements to find the unique number.                                          |
| **Hash Table**       | O(n)            | O(n)             | Uses a set to track numbers and identify the unique one. Removes duplicates as they are encountered.                              |
| **Math & Set**       | O(n)            | O(n)             | Uses a set to store unique elements and calculates the difference between the sum of all elements and the sum of unique elements. |
| **Set**              | O(n)            | O(n)             | Uses a set to add numbers; if a number is already present, it is removed. The final element in the set is the unique number.      |
| **Bit Manipulation** | O(n)            | O(1)             | Uses XOR operation, which cancels out duplicates and leaves the unique number due to properties of XOR.                           |

## Detailed Descriptions of Single Number Problem Approaches

### 1. Sorting Approach

- **Approach**: The array is sorted first, which takes `O(n log n)` time. After sorting, we iterate through the array and compare each pair of adjacent elements to find the unique number.
- **Time Complexity**: O(n log n)
- **Space Complexity**: O(1) (or O(n) depending on the sorting algorithm used)
- **Use Case**: This approach is suitable when you are allowed to modify the input array and when sorting overhead is acceptable. It is easy to implement and understand but less efficient for large datasets due to the sorting step.

### 2. Hash Table Approach

- **Approach**: Use a hash map to count the frequency of each number in the array. Then, iterate through the array again to find the number with a frequency of `1`.
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Use Case**: Ideal for cases where you can afford additional space to store the frequencies. This method is straightforward and ensures that the solution is found efficiently in linear time.

### 3. Math & Set Approach

- **Approach**: Utilize a set to store unique numbers while calculating the sum of all numbers in the array. Calculate the sum of the set and apply the formula `2 * sum(set) - sum(array)` to find the unique number.
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Use Case**: Useful when you want to use simple arithmetic and set operations to find the unique number. It’s a bit less common and may be more complex for some users compared to other methods.

### 4. Set Approach

- **Approach**: Use a set to track seen numbers. If a number is already in the set, remove it; otherwise, add it. At the end of the iteration, the remaining number in the set is the unique number.
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Use Case**: This method is simple and easy to understand. It is best suited for cases where extra space usage is acceptable and you want to use basic data structures for clear code.

### 5. Bit Manipulation Approach

- **Approach**: Use the XOR bitwise operation. XOR of two identical numbers results in `0`, and XOR of any number with `0` results in the number itself. By XORing all elements in the array, duplicate numbers cancel each other out, leaving only the unique number.
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Use Case**: This is the most efficient approach for both time and space. It’s ideal for scenarios where performance is critical, and minimal space is desired. The XOR operation is quick and avoids the overhead of extra data structures.

## Conclusion

Each approach has its own advantages and use cases:

- **Sorting** is simple but has a higher time complexity due to sorting.
- **Hash Table** provides an easy and direct way to find the unique number but requires additional space.
- **Math & Set** combines basic arithmetic with set operations for an interesting solution.
- **Set** is straightforward and great for scenarios where space is not a constraint.
- **Bit Manipulation** is the most efficient, suitable for large datasets and minimal space requirements.

Choose the approach based on your problem constraints, whether that be time complexity, space availability, or ease of implementation.
