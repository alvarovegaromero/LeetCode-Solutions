//https://leetcode.com/problems/minimum-size-subarray-sum

// First Approach
// Time Complexity: O(n^2) - Space Complexity: O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 1)
            return nums[0] >= target ? 1 : 0;

        int left = 0;
        int right = 0;
        int minLengthAnswer = Integer.MAX_VALUE;

        while(right < nums.length) {
            if(getSum(nums, left, right) >= target) {
                minLengthAnswer = Math.min(minLengthAnswer, right - left + 1);

                if(minLengthAnswer == 1) // Found optimal answer
                    return 1;
                    
                left++;
            } else {
                right++;
            }
        }

        if(minLengthAnswer != Integer.MAX_VALUE)
            return minLengthAnswer;

        return 0;
    }

    public int getSum(int[] nums, int left, int right) {
        int sum = 0;

        // Right will always be lower than nums.length
        for(int i = left; i <= right; i++)
            sum += nums[i];

        return sum;
    }
}

// Second Approach - Optimized
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, currentSum = 0;
        int minLengthAnswer = Integer.MAX_VALUE;

        while(right < nums.length) {
            currentSum += nums[right];
            right++;

            while (currentSum >= target) {
                minLengthAnswer = Math.min(minLengthAnswer, right - left);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLengthAnswer == Integer.MAX_VALUE ? 0 : minLengthAnswer;
    }
}