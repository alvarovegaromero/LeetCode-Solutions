//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution {

    public int removeDuplicates(int[] nums) {
        final int MAX_REPETITION_PER_NUMBER = 2;

        int validNumbersIndex = 1;
        int currentNumberRepetition = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[validNumbersIndex++] = nums[i];
                currentNumberRepetition = 1; 
            } else if(currentNumberRepetition < MAX_REPETITION_PER_NUMBER) {
                nums[validNumbersIndex++] = nums[i];
                currentNumberRepetition++; 
            }
        }

        return validNumbersIndex;
    }
}
