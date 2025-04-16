//https://leetcode.com/problems/zigzag-conversion


// First Approach
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        StringBuilder[] linesToPrint = new StringBuilder[numRows];

        for(int i = 0; i < linesToPrint.length; i++)
            linesToPrint[i] = new StringBuilder();

        // Algorithm
        boolean isGoingUp = true; //initially from 1 to numRows
        int currentLineAssignator = 0; // [0, numRows - 1]
        for (int i = 0; i < s.length(); i++) {
            linesToPrint[currentLineAssignator].append(s.charAt(i));

            if(isGoingUp) {
                currentLineAssignator++;

                if(currentLineAssignator == (numRows- 1))
                    isGoingUp = false;
            } else {
                currentLineAssignator--;

                if(currentLineAssignator == 0)
                    isGoingUp = true;
            }
        }

        // Combine results
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : linesToPrint)
            result.append(sb);

        return result.toString();   
    }
}

// Second Approach - Optimized and more legible
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;

        StringBuilder[] rows = initializeRows(numRows);

        int currentRow = 0;
        int direction = 1;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            if (currentRow == 0) 
                direction = 1;
            else if (currentRow == rows.length - 1) 
                direction = -1;

            currentRow += direction;
        }
        
        return joinRows(rows, s.length());
    }

    private StringBuilder[] initializeRows(int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();
        
        return rows;
    }

    private String joinRows(StringBuilder[] rows, int totalLength) {
        StringBuilder result = new StringBuilder(totalLength);
        
        for (StringBuilder row : rows)
            result.append(row);
        
        return result.toString();
    }
}
