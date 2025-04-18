//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return helper(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int postStart, int postEnd,
                            int inStart, int inEnd) {
        if(postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        
        // Find the index of the root in inorder array.
        // The left subtree is in the range inorder: [inStart, rootInId - 1]
        // The left subtree is in the range postorder: [postStart, postEnd - rightSize - 1]
        int indexRootInorder = inorderMap.get(postorder[postEnd]);
        int rightSize = inEnd - indexRootInorder;

        root.left = helper(postorder, postStart, postEnd - rightSize - 1, inStart, indexRootInorder - 1);
        root.right = helper(postorder, postEnd - rightSize, postEnd - 1, indexRootInorder + 1, inEnd);

        /* Using leftSize: 
        int leftSize = indexRootInorder - inStart;

        root.left = helper(postorder, postStart, postStart + leftSize - 1, inStart, indexRootInorder - 1);
        root.right = helper(postorder, postStart + leftSize, postEnd - 1, indexRootInorder + 1, inEnd);
        */
        return root;
    }
}