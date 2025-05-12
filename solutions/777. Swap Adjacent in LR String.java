//https://leetcode.com/problems/swap-adjacent-in-lr-string

// First Approach
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean canTransform(String start, String result) {
        // See if same strings without the "Xs"

        // Remove all Xs from both strings
        // If they are not the same initially, return false
        String startFiltered = start.replace("X", "");
        String resultFiltered = result.replace("X", "");
        if (!startFiltered.equals(resultFiltered)) 
            return false;
        
        int i = 0, j = 0, len = start.length();
        while(i <= len && j <= len) {
            // Skip Xs if needed
            while (i < start.length() && start.charAt(i) == 'X') 
                i++;
            while (j < result.length() && result.charAt(j) == 'X') 
                j++;

            if(i >= len || j >= len)
                break;

            // L or R. Need to be the same if they are the same
            char c1 = start.charAt(i);
            char c2 = result.charAt(j);

            if(c1 != c2)
                return false;

            // Same chars. See if movement is valid
            if((c1 == 'L' && i < j) || (c1 == 'R' && i > j))
                return false;

            i++;
            j++;
        }

        return true;
    }
}

// Second Approach - Optimized
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public boolean canTransform(String start, String result) {
        // See if same strings without the "Xs"
        int i = 0, j = 0, len = start.length();
        while(i <= len && j <= len) {
            // Skip Xs if needed
            while (i < start.length() && start.charAt(i) == 'X') 
                i++;
            while (j < result.length() && result.charAt(j) == 'X') 
                j++;

            // One ended but the other didn't -> false ()
            if ((i == len) != (j == len)) 
                return false;

            // Both ended at same time
            if (i == len && j == len) 
                return true;

            // L or R. Need to be the same if they are the same
            char c1 = start.charAt(i);
            char c2 = result.charAt(j);

            if(c1 != c2)
                return false;

            // Same chars. See if movement is valid
            if((c1 == 'L' && i < j) || (c1 == 'R' && i > j))
                return false;

            i++;
            j++;
        }

        return true;
    }
}