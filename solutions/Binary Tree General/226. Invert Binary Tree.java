//https://leetcode.com/problems/invert-binary-tree

// First Approach
// Time Complexity: O(n) - Space Complexity: O(h) - h=height
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }
}

// Second Approach - Optimized Solution
// Time Complexity: O(n) - Space Complexity: O(h) - h=height
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}