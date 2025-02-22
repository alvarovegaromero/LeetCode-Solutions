//https://leetcode.com/problems/product-of-array-except-self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int [] output = new int [size];
        output[0] = 1;

        // Dynamic Approach - Keep product of the left side
        for(int i = 1; i < size; i++)
            output[i] = output[i - 1] * nums[i - 1]; 

        int rightPart = 1;

        // Keep product of the right side and add it to the output
        for(int i = size - 1; i >= 0; i--) {
            output[i] *= rightPart;
            rightPart *= nums[i];
        }

        return output;
    }
}