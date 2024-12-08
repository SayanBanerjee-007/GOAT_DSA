# Fibonacci Number

[Leetcode](https://leetcode.com/problems/fibonacci-number/description/)

## Difficulty Level

- **Easy**

## Topics Covered

- Recursion
- Dynamic Programming (DP)
- Matrix Exponentiation
- Math
- Memoization

## Problem Statement

Given a non-negative integer `n`, find the `n`th Fibonacci number. The Fibonacci sequence is defined as:

- F(0) = 0, F(1) = 1
- F(n) = F(n - 1) + F(n - 2) for n >= 2

Given `n`, return the `n`th Fibonacci number. 0-indexed.

## Constraints

- `0 <= n <= 30`

## Example

**Input:**

```plaintext
n = 2
```

**Output:**

```plaintext
1
```

**Explanation:**

Because `F(2) = F(1) + F(0) = 1 + 0 = 1`.

## Overview of Fibonacci Calculation Approaches

| Approach                                    | Time Complexity (TC) | Space Complexity (SC) | Description                                                                                                                                                       |
| ------------------------------------------- | -------------------- | --------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Naive Recursion**                         | O(2^n)               | O(n)                  | A straightforward recursive solution that calls itself twice for each value of `n`, leading to exponential time complexity due to repeated calculations.          |
| **Memoization (Top-Down DP)**               | O(n)                 | O(n)                  | An optimized version of recursion that stores already computed values in a cache (e.g., map) to avoid redundant calculations, significantly improving efficiency. |
| **Tabulation (Bottom-Up DP)**               | O(n)                 | O(n)                  | Iteratively calculates Fibonacci numbers from the base case up to `n` using an array to store intermediate results.                                               |
| **Tabulation Space Optimized or Iterative** | O(n)                 | O(1)                  | A space-efficient version of the tabulation approach that only keeps track of the last two Fibonacci numbers instead of storing all intermediate values.          |
| **Matrix Exponentiation**                   | O(log(n))            | O(1)                  | Uses the properties of matrix multiplication to compute Fibonacci numbers in logarithmic time by raising the transformation matrix to the power of `n`.           |
| **Binet's Formula**                         | O(1)                 | O(1)                  | A direct formula using the golden ratio (phi) and the square root of 5 to calculate the nth Fibonacci number in constant time.                                    |

## Detailed Descriptions

### 1. **Naive Recursion**

- **Approach**: Recursively calls `fib(n - 1)` and `fib(n - 2)` until `n < 2`.
- **Complexity**: Exponential time complexity (O(2^n)) due to the large number of redundant calls. Space complexity is linear (O(n)) due to the call stack depth.
- **Use Case**: Demonstrates a simple and clear recursive approach but is inefficient for large `n`.

### 2. **Memoization (Top-Down DP)**

- **Approach**: Uses a recursive function with a cache (e.g., a hash map) to store already calculated Fibonacci numbers.
- **Complexity**: Time complexity is reduced to O(n) by avoiding repeated calculations. Space complexity is O(n) due to the cache and call stack.
- **Use Case**: Suitable for problems where recursion is needed but performance is important.

### 3. **Tabulation (Bottom-Up DP)**

- **Approach**: Constructs the Fibonacci sequence iteratively from `0` to `n` using an array to store intermediate values.
- **Complexity**: Linear time and space complexity (O(n)). Efficient for sequential calculations and when `n` is large.
- **Use Case**: Optimal for calculating Fibonacci numbers in a straightforward manner where `n` is known and manageable.

### 4. **Tabulation Space Optimized or Iterative**

- **Approach**: Similar to the standard tabulation but only stores the last two Fibonacci numbers at a time.
- **Complexity**: Linear time complexity (O(n)), but space complexity is reduced to O(1).
- **Use Case**: Best for when only the nth Fibonacci number is needed, with limited memory.

### 5. **Matrix Exponentiation**

- **Approach**: Uses matrix properties to compute Fibonacci numbers using the transformation matrix `[[1, 1], [1, 0]]`. Raises the matrix to the power of `n-1` to obtain the result.
- **Complexity**: Time complexity is logarithmic (O(log(n))) due to fast exponentiation. Space complexity is O(1).
- **Use Case**: Ideal for very large values of `n` where the logarithmic time complexity is necessary.

### 6. **Binet's Formula**

- **Approach**: Uses the explicit formula `F(n) = (phi^n - (1-phi)^n) / sqrt(5)`, where `phi` is the golden ratio.
- **Complexity**: Constant time complexity (O(1)) and space complexity (O(1)). Can handle very large `n` but may suffer from floating-point precision issues.
- **Use Case**: Useful for quickly calculating Fibonacci numbers when precision is not an issue and `n` is large.

---
