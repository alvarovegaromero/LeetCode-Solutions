//https://leetcode.com/problems/kth-smallest-element-in-a-bst

// Time Efficiency: average O(k + depth) - O(N) in worst case
// Space Efficiency: average O(log(N)) balanced tree - O(N) worst case
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        int counter = 0;
        TreeNode current = root;

        // Inorder but with stack to avoid overflow in big trees
        while(current != null || !myStack.isEmpty()) {
            // First go to left most node and save nodes in the path
            while(current != null) {
                myStack.push(current);
                current = current.left;
            }

            current = myStack.pop();
            counter++;

            if(counter == k)
                return current.val;

            // Go to right subtree
            current = current.right; 
        }

        // Unreachable return. Needed
        return 0;
    }
}