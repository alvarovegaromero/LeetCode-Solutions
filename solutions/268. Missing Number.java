//https://leetcode.com/problems/missing-number

// Time complexity: O(n) - Space complexity: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int totalSum = 0;
        // The sum of the first n natural numbers is calculated as n * (n + 1) / 2.
        int totalSumWithMissing = (nums.length) * (nums.length + 1) / 2;
        
        for(int num: nums) 
            totalSum += num;

        return (totalSumWithMissing - totalSum);
    }
}