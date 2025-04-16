//https://leetcode.com/problems/string-to-integer-atoi

// First Approach
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public int myAtoi(String s) {
        // Remove leading and trailing whitespaces
        s = s.trim();

        if(s.length() == 0)
            return 0;

        // See if - or + 
        int index = 0;
        boolean isNegative = false;
        if(s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (s.charAt(index) == '+')
            index++;

        // Skip leading 0s
        while(index < s.length() && s.charAt(index) == '0')
            index++;

        int result = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Handle possible overflow
            if (result > (Integer.MAX_VALUE / 10) || 
                (result == (Integer.MAX_VALUE / 10) && digit > 7))
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            result = (result * 10) + digit;

            index++;
        }

        return isNegative ? -result : result;
    }
}

// Second Approach - Cleaner Code and avoiding using trim, 
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public int myAtoi(String s) {
        int index = 0, n = s.length();
        // Skip only leading spaces
        while (index < n && s.charAt(index) == ' ') 
            index++;

        if (index == n) 
            return 0;

        // Handle optional sign
        boolean isNegative = false;
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        int result = 0;
        final int MAX_DIV_10 = Integer.MAX_VALUE / 10;
        
        while (index < n && isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Overflow check
            if (result > MAX_DIV_10 || (result == MAX_DIV_10 && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return isNegative ? -result : result;
    }
    
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
