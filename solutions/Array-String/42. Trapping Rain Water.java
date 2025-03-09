//https://leetcode.com/problems/trapping-rain-water

// First Solution - Time Efficiency: O(n) - Space Efficiency O(n)
class Solution {
    public int trap(int[] height) {
        int waterTrapped = 0; 
        int size = height.length;
        
        int[] leftMaxHeight = new int[size];
        int rightMaxHeight;

        leftMaxHeight[0] = height[0];
        rightMaxHeight = height[size - 1];

        for(int i = 1; i < size ; i++)
            leftMaxHeight[i] = Math.max(height[i], leftMaxHeight[i - 1]);

        for(int i = size - 2; i >= 0; i--) {
            rightMaxHeight = Math.max(height[i], rightMaxHeight);
            waterTrapped += Math.min(leftMaxHeight[i], rightMaxHeight) - height[i];
        }
 
        return waterTrapped;
    }
}

// Second Solution - Time Efficiency: O(n) - Space Efficiency O(1)
class Solution {
    public int trap(int[] height) {
        int waterTrapped = 0; 
        int leftPointer = 0;
        int leftMaxHeight = height[leftPointer];
        int rightPointer = height.length - 1;
        int rightMaxHeight = height[height.length - 1];

        while (leftPointer < rightPointer) {
            if (leftMaxHeight < rightMaxHeight) {
                leftPointer++;
                leftMaxHeight = Math.max(leftMaxHeight, height[leftPointer]);
                waterTrapped += leftMaxHeight - height[leftPointer];
            } else {
                rightPointer--;
                rightMaxHeight = Math.max(rightMaxHeight, height[rightPointer]);
                waterTrapped += rightMaxHeight - height[rightPointer];
            }
        }
 
        return waterTrapped;
    }
}