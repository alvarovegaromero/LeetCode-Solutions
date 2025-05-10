//https://leetcode.com/problems/remove-linked-list-elements

// First Approach - Dummy Node
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        if(head.next == null)
            return head.val == val ? null : head;

        ListNode dummy = new ListNode(-1, head);
        ListNode current = head, prev = dummy;
        
        while(current != null) {
            if(current.val == val)
                prev.next = current.next;
            else
                prev = current;

            current = current.next;
        }

        return dummy.next;
    }
}

// Second Approach - Dummy Optimized
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy;

        while(current.next != null) {
            if(current.next.val == val)
                current.next = current.next.next;
            else
                current = current.next;
        }

        return dummy.next;
    }
}

// Third Approach - Iterative
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;

        while(head != null && head.val == val)
            head = head.next;

        ListNode current = head;
        while(current != null && current.next != null) {
            if(current.next.val == val)
                current.next = current.next.next;
            else
                current = current.next;
        }

        return head;
    }
}


// Fourth Approach - Recursive
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}