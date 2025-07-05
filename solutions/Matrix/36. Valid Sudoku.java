//https://leetcode.com/problems/valid-sudoku

// Time Complexity: O(1) - Space Complexity: O(1) 
// as Sudoku's rows and colums are limited to 9.
// If len of colums and rows would be N, the time efficiency would be O(n^2)
// and space efficiency would be O(n) (save n elements per iterations)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Standard Sudoku board size
        final int NUM_ROWS = 9; // board.length
        final int NUM_COLS = 9; // board[i].length
        final int NUM_ROWS_PER_SUB_BOX = 3;
        final int NUM_COLS_PER_SUB_BOX = 3;

        // Check rows
        for(char[] row : board) {
            Set<Character> numbersRow = new HashSet<>();

            for(char element : row) {
                if(element != '.') {
                    if(numbersRow.contains(element))
                        return false; 
                    else 
                        numbersRow.add(element);
                }
            }
        }

        // Check cols
        for(int j = 0; j < NUM_COLS; j++) { // NUM_ROWS
            Set<Character> numbersCol = new HashSet<>();

            for(int i = 0; i < NUM_ROWS; i++) { 
                char element = board[i][j];
                if(element != '.') {
                    if(numbersCol.contains(element))
                        return false;
                    else 
                        numbersCol.add(element);
                }
            }
        }
        
        // Check sub-boxes
        for (int startRow = 0; startRow < NUM_ROWS; startRow += NUM_ROWS_PER_SUB_BOX) {  // Iterate over row blocks
            for (int startCol = 0; startCol < NUM_COLS; startCol += NUM_COLS_PER_SUB_BOX) {  // Iterate over cols blocks
                Set<Character> numbersBox = new HashSet<>();

                for (int i = 0; i < NUM_ROWS_PER_SUB_BOX; i++) {  // Iterate within the sub-box
                    for (int j = 0; j < NUM_COLS_PER_SUB_BOX; j++) {
                        char element = board[startRow + i][startCol + j]; 
                        if (element != '.') {
                            if (numbersBox.contains(element))
                                return false;
                            else
                                numbersBox.add(element);
                        }
                    }
                }
            }
        }

        return true;
    }
}