//https://leetcode.com/problems/jump-game/

// Time Complexity: O(n)
// Space Complexity: O(1)
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

// Other approach using goal shrinking
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
