//https://leetcode.com/problems/swap-nodes-in-pairs

// Using Dummy Node and Iterative Approach
// Time Complexity: O(n) - Space complexity: O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1, head);

        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            // swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // move prev forward for the next pair
            prev = first;
        }

        return dummy.next;
    }
}
