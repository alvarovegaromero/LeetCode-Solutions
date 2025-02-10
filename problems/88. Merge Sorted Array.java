//https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexNums1 = m - 1;
        int indexNums2 = n - 1;
        int indexResultArray = n + m - 1;

        while(indexNums2 >= 0) {
            if(indexNums1 >= 0 && nums1[indexNums1] > nums2[indexNums2])
                nums1[indexResultArray--] = nums1[indexNums1--];
            else
                nums1[indexResultArray--] = nums2[indexNums2--];
        }
    }
}