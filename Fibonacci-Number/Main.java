import java.util.HashMap;
import java.util.Map;

class Main {
    // Naive Recursion, TC: O(2^n), SC: O(n)
    public static int fibNaiveRecursion(int n) {
        if (n < 2) {
            return n;
        }
        return fibNaiveRecursion(n - 1) + fibNaiveRecursion(n - 2);
    }

    // Memoization(Top Down DP), TC: O(n), SC: O(n)
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibMemoization(int n) {
        if (n < 2) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fibMemoization(n - 1) + fibMemoization(n - 2);
        memo.put(n, result);
        return result;
    }

    // Tabulation(Bottom Up DP), TC: O(n), SC: O(n)
    public static int fibTabulation(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Tabulation Space Optimized(Bottom Up DP) or Iterative, TC: O(n), SC: O(1)
    public static int fibTabulationSpaceOptimizedOrIterative(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // Matrix Exponentiation, TC: O(log(n)), SC: O(1)
    public static int fibMatrixExponentiation(int n) {
        if (n < 2) {
            return n;
        }
        int[][] matrix = { { 1, 1 }, { 1, 0 } };
        matrix = power(matrix, n - 1);
        return matrix[0][0];
    }

    private static int[][] power(int[][] matrix, int n) {
        int[][] result = { { 1, 0 }, { 0, 1 } };
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, matrix);
            }
            n /= 2;
            matrix = multiply(matrix, matrix);
        }
        return result;
    }

    private static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int a = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
        int b = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
        int c = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
        int d = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];
        return new int[][] { { a, b }, { c, d } };
    }

    // Binet's Formula, TC: O(1), SC: O(1)
    public static int fibBinetsFormula(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        return (int) Math.round(Math.pow(phi, n) / sqrt5);
    }

    public static void main(String[] args) {
        int numbers[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println("Naive Recursion");
        for (int num : numbers) {
            System.out.println("fibNaiveRecursion(" + num + ") = " + fibNaiveRecursion(num));
        }

        System.out.println("\nMemoization(Top Down DP)");
        for (int num : numbers) {
            System.out.println("fibMemoization(" + num + ") = " + fibMemoization(num));
        }

        System.out.println("\nTabulation(Bottom Up DP)");
        for (int num : numbers) {
            System.out.println("fibTabulation(" + num + ") = " + fibTabulation(num));
        }

        System.out.println("\nTabulation Space Optimized(Bottom Up DP) or Iterative");
        for (int num : numbers) {
            System.out.println("fibTabulationSpaceOptimizedOrIterative(" + num + ") = "
                    + fibTabulationSpaceOptimizedOrIterative(num));
        }

        System.out.println("\nMatrix Exponentiation");
        for (int num : numbers) {
            System.out.println("fibMatrixExponentiation(" + num + ") = " + fibMatrixExponentiation(num));
        }

        System.out.println("\nBinet's Formula");
        for (int num : numbers) {
            System.out.println("fibBinetsFormula(" + num + ") = " + fibBinetsFormula(num));
        }
    }
}

// Output:
// Naive Recursion
// fibNaiveRecursion(0) = 0
// fibNaiveRecursion(1) = 1
// fibNaiveRecursion(2) = 1
// fibNaiveRecursion(3) = 2
// fibNaiveRecursion(4) = 3
// fibNaiveRecursion(5) = 5
// fibNaiveRecursion(6) = 8
// fibNaiveRecursion(7) = 13
// fibNaiveRecursion(8) = 21
// fibNaiveRecursion(9) = 34

// Memoization(Top Down DP)
// fibMemoization(0) = 0
// fibMemoization(1) = 1
// fibMemoization(2) = 1
// fibMemoization(3) = 2
// fibMemoization(4) = 3
// fibMemoization(5) = 5
// fibMemoization(6) = 8
// fibMemoization(7) = 13
// fibMemoization(8) = 21
// fibMemoization(9) = 34

// Tabulation(Bottom Up DP)
// fibTabulation(0) = 0
// fibTabulation(1) = 1
// fibTabulation(2) = 1
// fibTabulation(3) = 2
// fibTabulation(4) = 3
// fibTabulation(5) = 5
// fibTabulation(6) = 8
// fibTabulation(7) = 13
// fibTabulation(8) = 21
// fibTabulation(9) = 34

// Tabulation Space Optimized(Bottom Up DP) or Iterative
// fibTabulationSpaceOptimizedOrIterative(0) = 0
// fibTabulationSpaceOptimizedOrIterative(1) = 1
// fibTabulationSpaceOptimizedOrIterative(2) = 1
// fibTabulationSpaceOptimizedOrIterative(3) = 2
// fibTabulationSpaceOptimizedOrIterative(4) = 3
// fibTabulationSpaceOptimizedOrIterative(5) = 5
// fibTabulationSpaceOptimizedOrIterative(6) = 8
// fibTabulationSpaceOptimizedOrIterative(7) = 13
// fibTabulationSpaceOptimizedOrIterative(8) = 21
// fibTabulationSpaceOptimizedOrIterative(9) = 34

// Matrix Exponentiation
// fibMatrixExponentiation(0) = 0
// fibMatrixExponentiation(1) = 1
// fibMatrixExponentiation(2) = 1
// fibMatrixExponentiation(3) = 2
// fibMatrixExponentiation(4) = 3
// fibMatrixExponentiation(5) = 5
// fibMatrixExponentiation(6) = 8
// fibMatrixExponentiation(7) = 13
// fibMatrixExponentiation(8) = 21
// fibMatrixExponentiation(9) = 34

// Binet's Formula
// fibBinetsFormula(0) = 0
// fibBinetsFormula(1) = 1
// fibBinetsFormula(2) = 1
// fibBinetsFormula(3) = 2
// fibBinetsFormula(4) = 3
// fibBinetsFormula(5) = 5
// fibBinetsFormula(6) = 8
// fibBinetsFormula(7) = 13
// fibBinetsFormula(8) = 21
// fibBinetsFormula(9) = 34
