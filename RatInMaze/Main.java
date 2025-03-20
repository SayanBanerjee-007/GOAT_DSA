package RatInMaze;

import java.util.ArrayList;

class Solution {

    // Time Complexity: O(4^(m*n)),
    // because on every cell we need to try 4 different directions.
    // Space Complexity: O(m*n),
    // Maximum Depth of the recursion tree(auxiliary space).

    public void generatePath(
            ArrayList<String> result,
            ArrayList<ArrayList<Integer>> mat,
            int n, int row, int col,
            int[][] visited, StringBuilder sb) {

        // Base case: reached destination
        if (row == n - 1 && col == n - 1) {
            result.add(sb.toString());
            return;
        }

        // // No need of this conditions as the below if-else are
        // // already checking for this case
        // if ((row == 0 || visited[row - 1][col] == 1) &&
        // (row == n - 1 || visited[row + 1][col] == 1) &&
        // (col == 0 || visited[row][col - 1] == 1) &&
        // (col == n - 1 || visited[row][col + 1] == 1)) {
        // return;
        // }

        // Try down
        if (row + 1 < n && visited[row + 1][col] == 0 && mat.get(row + 1).get(col) == 1) {
            visited[row + 1][col] = 1;
            sb.append("D");
            generatePath(result, mat, n, row + 1, col, visited, sb);
            sb.setLength(sb.length() - 1);
            visited[row + 1][col] = 0;
        }

        // Try left
        if (col - 1 >= 0 && visited[row][col - 1] == 0 && mat.get(row).get(col - 1) == 1) {
            visited[row][col - 1] = 1;
            sb.append("L");
            generatePath(result, mat, n, row, col - 1, visited, sb);
            sb.setLength(sb.length() - 1);
            visited[row][col - 1] = 0;
        }

        // Try right
        if (col + 1 < n && visited[row][col + 1] == 0 && mat.get(row).get(col + 1) == 1) {
            visited[row][col + 1] = 1;
            sb.append("R");
            generatePath(result, mat, n, row, col + 1, visited, sb);
            sb.setLength(sb.length() - 1);
            visited[row][col + 1] = 0;
        }

        // Try up
        if (row - 1 >= 0 && visited[row - 1][col] == 0 && mat.get(row - 1).get(col) == 1) {
            visited[row - 1][col] = 1;
            sb.append("U");
            generatePath(result, mat, n, row - 1, col, visited, sb);
            sb.setLength(sb.length() - 1);
            visited[row - 1][col] = 0;
        }
    }

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        ArrayList<String> result = new ArrayList<>();

        // Check if starting and ending positions are valid
        if (mat.get(0).get(0) == 0 || mat.get(n - 1).get(n - 1) == 0)
            return result;

        int visited[][] = new int[n][n];
        visited[0][0] = 1; // Mark starting position as visited

        generatePath(result, mat, n, 0, 0, visited, new StringBuilder());
        return result;
    }
}

class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(0);
        row1.add(0);
        row1.add(0);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        row2.add(0);
        row2.add(1);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(1);
        row3.add(0);
        row3.add(0);
        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(0);
        row4.add(1);
        row4.add(1);
        row4.add(1);
        mat.add(row1);
        mat.add(row2);
        mat.add(row3);
        mat.add(row4);
        ArrayList<String> result = solution.findPath(mat);
        System.out.println(result);
    }
}
