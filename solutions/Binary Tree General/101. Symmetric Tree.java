//https://leetcode.com/problems/symmetric-tree

// Recursive approach
// Time Complexity: O(n) - Space Complexity: O(h) h=height
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkBothSides(root.left, root.right);
    }

    private boolean checkBothSides(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return left == right;
        if(left.val != right.val)
            return false;

        return checkBothSides(left.left, right.right) && 
                checkBothSides(left.right, right.left);
    }
}

// Iterative approach using Dequeue
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //Deque<TreeNode> queue = new ArrayDeque<>(); // Not valid as can't add null values
        Deque<TreeNode> queue = new LinkedList<>();

        queue.addLast(root.left);
        queue.addLast(root.right);
        while(!queue.isEmpty()) {
            TreeNode left = queue.pollFirst();
            TreeNode right = queue.pollFirst();

            if(left == null && right == null)
                continue;

            // Only one is null -> False
            if(left == null || right == null)
                return false;

            if(left.val != right.val)
                return false;

            queue.addLast(left.left);
            queue.addLast(right.right);

            queue.addLast(left.right);
            queue.addLast(right.left);
        }

        return true;
    }
}

// Iterative using Queue
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //Deque<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null)
                continue;

            // Only one is null -> False
            if(left == null || right == null)
                return false;

            if(left.val != right.val)
                return false;

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}