//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> llists = new ArrayList<>();

        if(root == null)
            return llists;

        int currentLevel = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<Integer> currentLevelNodes;
        int nodesInCurrentLevel;
        TreeNode current;

        while(!queue.isEmpty()) {
            currentLevelNodes = new ArrayList<>();
            nodesInCurrentLevel = queue.size();

            for(int i = 0; i < nodesInCurrentLevel; i++) {
                current = queue.poll();
                currentLevelNodes.add(current.val);

                if(current.left != null)
                    queue.add(current.left);
                
                if(current.right != null)
                    queue.add(current.right);
            }

            if(currentLevel % 2 != 0) 
                Collections.reverse(currentLevelNodes);

            llists.add(currentLevelNodes);
            currentLevel++;
        }

        return llists;
    }
}