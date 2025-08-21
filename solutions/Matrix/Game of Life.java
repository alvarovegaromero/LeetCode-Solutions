//https://leetcode.com/problems/game-of-life

// First approach - Copy the board and calculate the next state
// Time Complexity: O(m * n)
// Space Complexity: O(m * n) - a copy of the board to calculate is needed
class Solution {
    public void gameOfLife(int[][] board) {
        int liveNeighbours;

        int rows = board.length;
        int cols = board[0].length;

        int[][] copyBoard = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                liveNeighbours = getLiveNeighbours(copyBoard, i, j);

                if(copyBoard[i][j] == 1) { //live cell
                    if(liveNeighbours < 2 || liveNeighbours > 3)
                        board[i][j] = 0;
                } else { // died cell
                    if(liveNeighbours == 3)
                        board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveNeighbours(int[][] board, int row, int col) {
        int liveNeighbours = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) 
                    continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols) {
                    liveNeighbours += board[newRow][newCol];
                }
            }
        }

       return liveNeighbours;
    }
}

// Optimized - Avoid creation of a copy by creating two new states and skip
// These states will represent the transition: 
// - 2 represents a cell that was a 0 and will become a 1
// - -1 represents a cell that was a 1 and will become a 0
// Time Complexity: O(m * n)
// Space Complexity: O(1) - no additional space is used now
class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbours = getLiveNeighbours(board, i, j);

                if (board[i][j] == 1) { // live cell
                    if (liveNeighbours < 2 || liveNeighbours > 3)
                        board[i][j] = -1; // -1 represents a cell that was a 1 and will become a 0
                } else { // died cell
                    if (liveNeighbours == 3)
                        board[i][j] = 2; // 2 represents a cell that was a 0 and will become a 1
                }
            }
        }

        // Finalize by changing the temporary states
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 1;
                else if (board[i][j] == -1)
                    board[i][j] = 0;
            }
        }
    }

    private int getLiveNeighbours(int[][] board, int row, int col) {
        int liveNeighbours = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                int newRow = row + i;
                int newCol = col + j;

                // Check boundaries
                    if (newRow >= 0 && newRow < rows && 
                        newCol >= 0 && newCol < cols) {
                        // Only add cells that are 1 or -1 (LC that will die)
                        liveNeighbours += 
                            (board[newRow][newCol] == 1 || 
                            board[newRow][newCol] == -1) ? 1 : 0;
                }
            }
        }

        return liveNeighbours;
    }
}