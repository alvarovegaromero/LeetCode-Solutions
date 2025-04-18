//https://leetcode.com/problems/same-tree

// First Approach
// Time Complexity: O(n) - Space Complexity: O(h) h=height
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null && q != null)
            return false;
        else if(q == null && p != null)
            return false;
        else if(p.val != q.val)
            return false;

        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}

// Second Approach
// Time Complexity: O(n) - Space Complexity: O(h)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}