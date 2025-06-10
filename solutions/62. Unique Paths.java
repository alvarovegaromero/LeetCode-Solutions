//https://leetcode.com/problems/unique-paths

// First Solution - Dynamic Programming
// Space Complexity: O(n*m) - Time Complexity: O(n*m)
class Solution {
    public int uniquePaths(int m, int n) {
        // m rows - n cols
        // Dynamic Programming solution
        int[][] matrixDP = new int[m][n];

        // Only one movement needed for first col and first row (only right/down)
        for(int i = 0; i < m; i++)
           matrixDP[i][0] = 1; 

        for(int i = 1; i < n; i++)
            matrixDP[0][i] = 1;

        // Paths to matrix[i][j] are sum of the path for the cell above 
        // and cell to the left
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                matrixDP[i][j] = matrixDP[i - 1][j] + matrixDP[i][j - 1];
            }
        }

        return matrixDP[m - 1][n - 1];
    }
}

// Second Solution - Optimized Space Complexity
// Space Complexity: O(n) - Time Complexity: O(n*m)
class Solution {
    public int uniquePaths(int m, int n) {
        // Only one row is needed to store the current row's results
        int[] dp = new int[n];

        // Initialize the first row - Only one way
        for(int i = 0; i < n; i++)
            dp[i] = 1;

        // Calculate paths for each cell in the current row
        // using the previous row's results stored in dp
        // dp[j] will hold the number of unique paths to cell (i, j)
        // dp[j - 1] will hold the number of unique paths to cell (i, j - 1)
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                dp[j] += dp[j - 1];

        return dp[n - 1];
    }
}
