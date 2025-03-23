//https://leetcode.com/problems/number-of-1-bits

class Solution {
    public int hammingWeight(int n) {
        int counter = 0;

        // Kernighan's algorithm
        while(n > 0) {
            n = n & (n - 1); // eliminate least important bit
            counter++;
        }

        return counter;
    }
}