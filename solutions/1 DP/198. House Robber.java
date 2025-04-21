//https://leetcode.com/problems/house-robber

// First Approach: Dynamic Programming
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        return dp[n - 1];
    }
}

// Second Approach: Dynamic Programming (Space Optimized)
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0], nums[1]);

        int prev1 = Math.max(nums[0], nums[1]); // dp[i - 1]
        int prev2 = nums[0]; // dp[i - 2]

        for(int i = 2; i < n; i++) {
            int tmp = prev1;
            prev1 = Math.max(nums[i] + prev2, prev1);
            prev2 = tmp;
        }

        return prev1;
    }
}
