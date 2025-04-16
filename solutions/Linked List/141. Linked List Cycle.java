//https://leetcode.com/problems/linked-list-cycle


// First Approach - Floyd's Cycle Detection Algorithm (Tortoise and Hare)
// Time Complexity: O(n) - Space Complexity: O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            slow = slow.next;

            if(fast.next != null && fast.next.next != null)
                fast = fast.next.next;
            else
                return false;
        }

        return true;
    }
}

// Second Approach - Optimized
// Time Complexity: O(n) - Space Complexity: O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
