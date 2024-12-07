// Naive Recursion, TC: O(2^n), SC: O(n)
function fibNaiveRecursion(n) {
  if (n < 2) return n
  return fibNaiveRecursion(n - 1) + fibNaiveRecursion(n - 2)
}

// Memoization(Top Down DP), TC: O(n), SC: O(n)
let map = new Map()
function fibMemoization(n) {
  if (n < 2) return n
  if (map.has(n)) return map.get(n)
  let result = fibMemoization(n - 1) + fibMemoization(n - 2)
  map.set(n, result)
  return result
}

// Tabulation(Bottom Up DP), TC: O(n), SC: O(n)
function fibTabulation(n) {
  if (n < 2) return n
  let dp = new Array(n + 1)
  dp[0] = 0
  dp[1] = 1
  for (let i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2]
  }
  return dp[n]
}

// Tabulation Space Optimized(Bottom Up DP) or Iterative, TC: O(n), SC: O(1)
function fibTabulationSpaceOptimizedOrIterative(n) {
  if (n < 2) return n
  let a = 0,
    b = 1
  for (let i = 2; i <= n; i++) {
    c = a + b
    a = b
    b = c
  }
  return c
}

// Matrix Exponentiation, TC: O(log(n)), SC: O(1)
function fibMatrixExponentiation(n) {
  if (n < 2) return n
  let matrix = [
    [1, 1],
    [1, 0],
  ]
  matrix = power(matrix, n - 1)
  return matrix[0][0]
}

function power(matrix, n) {
  let result = [
    [1, 0],
    [0, 1],
  ]
  while (n > 0) {
    if (n % 2 == 1) {
      result = matrixMultiply(result, matrix)
    }
    n = Math.floor(n / 2)
    matrix = matrixMultiply(matrix, matrix)
  }
  return result
}

function matrixMultiply(m1, m2) {
  return [
    [
      m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0],
      m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1],
    ],
    [
      m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0],
      m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1],
    ],
  ]
}

// Binet's Formula, TC: O(1), SC: O(1)
function fibBinetsFormula(n) {
  let sqrt5 = Math.sqrt(5)
  let phi = (1 + sqrt5) / 2
  return Math.round(Math.pow(phi, n) / sqrt5)
}

let n = [0, 1, 2, 3, 4, 5, 6, 7, 8]

console.log('Naive Recursion')
n.forEach(n => console.log(fibNaiveRecursion(n)))

console.log('Memoization(Top Down DP)')
n.forEach(n => console.log(fibMemoization(n)))

console.log('Tabulation(Bottom Up DP)')
n.forEach(n => console.log(fibTabulation(n)))

console.log('Tabulation Space Optimized(Bottom Up DP) or Iterative')
n.forEach(n => console.log(fibTabulationSpaceOptimizedOrIterative(n)))

console.log('Matrix Exponentiation')
n.forEach(n => console.log(fibMatrixExponentiation(n)))

console.log("Binet's Formula")
n.forEach(n => console.log(fibBinetsFormula(n)))

// Output:
// Naive Recursion
// 0
// 1
// 1
// 2
// 3
// 5
// 8
// 13
// 21
// Memoization(Top Down DP)
// 0
// 1
// 1
// 2
// 3
// 5
// 8
// 13
// 21
// Tabulation(Bottom Up DP)
// 0
// 1
// 1
// 2
// 3
// 5
// 8
// 13
// 21
// Tabulation Space Optimized(Bottom Up DP) or Iterative
// 0
// 1
// 1
// 2
// 3
// 5
// 8
// 13
// 21
// Matrix Exponentiation
// 0
// 1
// 1
// 2
// 3
// 5
// 8
// 13
// 21
// Binet's Formula
// 0
// 1
// 1
// 2
// 3
// 5
// 8
// 13
// 21
