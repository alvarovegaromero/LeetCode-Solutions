//https://leetcode.com/problems/majority-element

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int candidateCount = 1;

        for(int i = 1; i < nums.length; i++) {
            if(candidateCount == 0)
                candidate = nums[i];
            
            if(nums[i] == candidate)
                candidateCount++;
            else
                candidateCount--;
        }

        return candidate;
    }
}