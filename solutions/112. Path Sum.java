//https://leetcode.com/problems/path-sum

// Time Complexity: O(n) - Space Complexity: O(h) - h=height 
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        // Leaf
        if (root.left == null && root.right == null)
            return root.val == targetSum;

        return hasPathSum(root.left, targetSum - root.val) || 
                hasPathSum(root.right, targetSum - root.val);
        
    }
}