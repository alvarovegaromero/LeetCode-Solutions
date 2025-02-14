//https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int nearestPosInInterval = 0, farthestPosIntInterval = 0, jumps = 0;
        int farthestPosReachable;

        while(farthestPosIntInterval < (nums.length - 1)) {
            farthestPosReachable = 0;
            
            for(int i = nearestPosInInterval ; i <= farthestPosIntInterval; i++) 
                farthestPosReachable = Math.max(farthestPosReachable, i + nums[i]);
            
            nearestPosInInterval = farthestPosIntInterval + 1; // each pos, at least has 1 jump
            jumps++;
            farthestPosIntInterval = farthestPosReachable;
        }

        return jumps;
    }
}