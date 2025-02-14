//https://leetcode.com/problems/remove-element/

class Solution {
    public int removeElement(int[] nums, int val) {
        int indexValidNums = 0;
        int size = nums.length;
        
        for(int i = 0 ; i < size ; i++){
            if(nums[i] != val) {
                nums[indexValidNums] = nums[i];
                indexValidNums++;
            }
        }

        return indexValidNums;
    }
}