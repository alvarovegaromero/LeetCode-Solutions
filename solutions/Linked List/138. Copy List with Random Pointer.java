//https://leetcode.com/problems/copy-list-with-random-pointer

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public Node copyRandomList(Node head) {
        // No head - empty list
        if(head == null)
            return null;

        // Map to hold original nodes and their copies
        Map<Node, Node> originalNodeToCopy = new HashMap<>();

        Node current = head;
        while(current != null) {
            // Create a copy of the current node and store it in the map
            originalNodeToCopy.put(current, new Node(current.val));
            
            current = current.next;
        }

        current = head;
        while(current != null) {
            // Set the next and random pointers for the copied nodes
            originalNodeToCopy.get(current).next = originalNodeToCopy.get(current.next);
            originalNodeToCopy.get(current).random = originalNodeToCopy.get(current.random);

            current = current.next;
        }

        return originalNodeToCopy.get(head);
    }
}