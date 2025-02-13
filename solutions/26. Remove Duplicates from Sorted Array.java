//https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueNumbersIndex = 1; // first number will be always unique - avoid 1 loop

        for(int i = 1; i < nums.length; i++)
            if(nums[i] != nums[i - 1])
                nums[uniqueNumbersIndex++] = nums[i];

        return uniqueNumbersIndex;
    }
}