//https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;

        if(k == 0)
            return;

        reverse(nums, 0, size - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, size - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

/*
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        int[] numsTempCopy = new int[k];

        if(k == 0)
            return;

        for(int i = 0; i < k ; i++)
            numsCopy[i] = nums[i + size - k];

        for (int i = size - k - 1; i >= 0; i--)
            nums[i + k] = nums[i];

        for(int i = 0 ; i < k ; i++)
            nums[i] = numsCopy[i];
    }
*/