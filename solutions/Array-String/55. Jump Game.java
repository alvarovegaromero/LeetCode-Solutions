//https://leetcode.com/problems/jump-game/

class Solution {
    public boolean canJump(int[] nums) {
        int maxPosReachable = 0;

        for(int i = 0; i < nums.length; i ++) {
            if(i > maxPosReachable) 
                return false;

            maxPosReachable = Math.max(maxPosReachable, i + nums[i]);
        }

       return true;
    }
}