//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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

// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {

    // Save node value (key) with its index in the array (value)
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) 
            inorderMap.put(inorder[i], i);
        
        return helper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int inStart, int inEnd) {
        if(preStart > preEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        // Find the index of the root in inorder array.
        // The left subtree is in the range inorder: [inStart, rootInId - 1]
        // The left subtree is in the range preorder: [preStart + 1, preStart + leftSize]
        int rootInId = inorderMap.get(preorder[preStart]);
        int leftSize = rootInId - inStart; 

        root.left = helper(preorder, preStart + 1, preStart + leftSize, inStart, rootInId - 1);
        root.right = helper(preorder, preStart + leftSize + 1 , preEnd, rootInId + 1 , inEnd);

        return root;
    }
}