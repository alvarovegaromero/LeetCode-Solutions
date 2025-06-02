//https://leetcode.com/problems/divide-two-integers

// First Solution without handling overflow
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0;
        boolean negativeResult = false;

        if((dividend < 0) ^ (divisor < 0))
            negativeResult = true;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while(dividend >= divisor) {
            result++;
            dividend -= divisor;
        }

        return negativeResult ? -result : result;
    }
}

// Second solution handling overflow
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public int divide(int dividend, int divisor) {
        // Overflow case: only one case to handle manually
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Use long to safely take absolute value of Integer.MIN_VALUE
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        boolean negative = (dividend < 0) ^ (divisor < 0);

        int result = 0;
        while (a >= b) {
            a -= b;
            result++;
        }

        return negative ? -result : result;
    }
}

// Third solution using bit manipulation
// Time Complexity: O(log n) - Space Complexity: O(1)
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Use long to handle absolute values safely
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        boolean negative = (dividend < 0) ^ (divisor < 0);
        int result = 0;

        // Iterate from the highest bit to the lowest bit
        // We can shift bits to find how many times divisor fits into dividend
        // We start from the highest bit (31 for 32-bit integers)
        // and check if divisor shifted left by i bits is less than or equal to dividend
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                a -= (b << i);
                result += (1 << i);
            }
        }

        return negative ? -result : result;
    }
}