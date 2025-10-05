//https://leetcode.com/problems/reverse-nodes-in-k-group

// Time Complexity: O(n) where n is the number of nodes in the linked list
// Space Complexity: O(1) 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // if list is empty or k == 1, no reversal needed
        if (head == null || k == 1) return head;

        // Dummy node to handle changes at the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            // Check if there are at least k nodes to reverse
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next; // Not enough nodes left
                }
            }

            // Save the start of the next group
            ListNode nextGroup = tail.next;

            // Reverse the current group
            ListNode[] reversed = reverse(head, tail);
            head = reversed[0];  // new head of the reversed group
            tail = reversed[1];  // new tail of the reversed group

            // Connect previous part with the reversed group
            prev.next = head;
            tail.next = nextGroup;

            // Move pointers for the next iteration
            prev = tail;
            head = tail.next;
        }

        return dummy.next;
    }

    // Helper function: reverse nodes from head to tail
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;

        while (prev != tail) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return new ListNode[]{tail, head}; // return new head and tail
    }
}
