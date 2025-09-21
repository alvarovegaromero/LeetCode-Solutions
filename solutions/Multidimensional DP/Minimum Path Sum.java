//https://leetcode.com/problems/minimum-path-sum

// Time Complexity: O(m*n) where m is number of rows and n is number of columns
// Space Complexity: O(m*n)
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        int sum = 0;
        for(int i = 0; i < rows; i++) {
            sum += grid[i][0]; // first col, only achieved by going down
            dp[i][0] = sum;
        }

        sum = grid[0][0]; // first pos already processed before
        for(int i = 1; i < cols; i++) {
            sum += grid[0][i]; // first row, only achieved by going right
            dp[0][i] = sum;
        }

        // For every position, the min path will be:
        // min(posAbove, posLeft) + currentPos
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][cols-1];
    }
}