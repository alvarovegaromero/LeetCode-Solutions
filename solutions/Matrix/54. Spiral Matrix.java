//https://leetcode.com/problems/spiral-matrix

// Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
// Space Complexity: O(n) since we are using the output list to store the result
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();

        int rowTop = 0, rowBottom = matrix.length - 1;
        int columnLeft = 0, columnRight = matrix[0].length - 1;

        while (rowTop <= rowBottom && columnLeft <= columnRight) {
            // Traverse top row from left to right
            for(int i = columnLeft; i <= columnRight; i++) {
                results.add(matrix[rowTop][i]);
            }
            rowTop++;

            // Traverse last column from the bottom to the top
            for(int j = rowTop; j <= rowBottom; j++) {
                results.add(matrix[j][columnRight]);
            }
            columnRight--;

            // Traverse last row from right to left
            if (rowTop <= rowBottom) {
                for (int i = columnRight; i >= columnLeft; i--) {
                    results.add(matrix[rowBottom][i]);
                }
                rowBottom--;
            }

            // Traverse first column from top to the bottom
            if (columnLeft <= columnRight) {
                for (int j = rowBottom; j >= rowTop; j--) {
                    results.add(matrix[j][columnLeft]);
                }
                columnLeft++;
            }
        }

        return results;
    }
}

// Other solution using a variable for the direction to follow
// Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
// Space Complexity: O(m * n) as we are using a visited matrix to keep track of the visited cells
class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int dir = 0; // current direction
        int r = 0, c = 0;

        for (int i = 0; i < rows * cols; i++) {
            result.add(matrix[r][c]);
            visited[r][c] = true;

            int nextR = r + directions[dir][0];
            int nextC = c + directions[dir][1];

            if (nextR < 0 || nextR >= rows || nextC < 0 || nextC >= cols || visited[nextR][nextC]) {
                dir = (dir + 1) % 4;
                nextR = r + directions[dir][0];
                nextC = c + directions[dir][1];
            }

            r = nextR;
            c = nextC;
        }

        return result;
    }
}