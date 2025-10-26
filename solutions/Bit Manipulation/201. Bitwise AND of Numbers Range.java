//https://leetcode.com/problems/bitwise-and-of-numbers-range

// First approach - Brute Force
// Time Complexity: O(right - left)
// Space Complexity: O(1)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left == right)
            return left;

        int result = left;

        for(int i = left + 1; i <= right; i++) {
            result &= i;
        }

        return result;
    }
}

// Second approach - Bit Manipulation - Finding Common Prefix
// Prefix bits are the ones that remain the same for both left and right
// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Move right until left equals right - Remove the last bit of both 
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // Then shift back to the left - Add the zeros at the end
        return left << shift;
    }
}