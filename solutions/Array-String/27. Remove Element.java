//https://leetcode.com/problems/remove-element/

// First approachs
// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        int lastValidIndex = nums.length - 1;
        int k = 0;

        for (int i = 0; i <= lastValidIndex; i++) {
            if (nums[i] == val) {
                // Find a value different than val   
                while (lastValidIndex > i && nums[lastValidIndex] == val) {
                    lastValidIndex--;
                }

                // If valid element found, swap
                if (lastValidIndex > i) {
                    int tmp = nums[i];
                    nums[i] = nums[lastValidIndex];
                    nums[lastValidIndex] = tmp;
                    lastValidIndex--;
                }
            }

            if (nums[i] != val) {
                k++;
            }
        }

        return k;
    }
}
// Two pointers
// Time Complexity: O(n)
// Space Complexity: O(1)
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