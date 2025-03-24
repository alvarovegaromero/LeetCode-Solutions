//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(0, nums.length - 1, nums);
    }

    TreeNode insert(int left, int right, int[] nums) {
        if(left > right)
            return null;

        int mid = (left + right) / 2;

        return new TreeNode(nums[mid],
                            insert(left, mid - 1, nums),
                            insert(mid + 1, right, nums));
    }
}