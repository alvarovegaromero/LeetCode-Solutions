//https://leetcode.com/problems/search-a-2d-matrix

// Fist Approach - Binary Search in rows and after, in columns
// Time Complexity: O(log(m) + log(n)) = O(log(n*m)), m number of rows and n number of columns
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix[0].length;
        int left = 0, right = matrix.length - 1, mid;
        int[] row = null;

        while (left <= right) {
            mid = (left + right) / 2;
            if((matrix[mid][0] <= target && matrix[mid][rowSize - 1] >= target)){
                row = matrix[mid];
                break;
            } else if(matrix[mid][0] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        // If the row is not found, return false
        // Might happen when rowSize is 1 and target is not in the matrix
        // or when the target is less than the first element of the matrix
        // or when the target is greater than the last element of the matrix
        if (row == null) 
            return false;

        left = 0;
        right = rowSize - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if(row[mid] == target)
                return true;
            else if(row[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return false;
    }
}

// Second Approach - Binary Search in the matrix
// Time Complexity: O(log(m*n)), m number of rows and n number of columns
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Consider Matrix as a 1D array of size m*n
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // Convert 1D mid to 2D coordinates
            // mid / cols gives the row index
            // mid % cols gives the column index
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target)
                return true;
            else if (midValue < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}