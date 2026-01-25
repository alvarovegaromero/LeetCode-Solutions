//https://leetcode.com/problems/flatten-binary-tree-to-linked-list

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(n) as heap will grow up to n
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        TreeNode right = root.right;
        TreeNode left = root.left;
        
        // Set left to null as required by the problem
        root.left = null;

        // Recursively flatten left and right subtrees
        this.flatten(left);
        this.flatten(right);

        // Connect flatenned left subtree to root
        root.right = left;

        // Find the end of the left subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        // Connext flatenned right subtree
        current.right = right;
    }
}