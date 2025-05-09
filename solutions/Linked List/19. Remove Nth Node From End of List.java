//https://leetcode.com/problems/remove-nth-node-from-end-of-list

// First Approach - Two Passes
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) 
            return null;

        ListNode current = head, prev;
        int size = 0;

        // Get size of the List (var sz does not exist)
        while(current != null) {
            current = current.next;
            size++;
        }

        int indexToDelete = size - n;
        if(indexToDelete == 0)
            return head.next;

        int currentIndex = 0;
        prev = null;
        current = head;

        while(current != null) {
            if(currentIndex == indexToDelete) {
                prev.next = current.next;
                return head;
            }

            prev = current;
            current = current.next;
            currentIndex++;
        }

        // If valid input is given, unreachable
        return head;
    }
}

// Second Approach - Two Passes (Optimized)
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // First node to be removed
        if (n == size)
            return head.next;

        current = head;
        // Move to the node before the one we want to remove
        for (int i = 1; i < size - n; i++)
            current = current.next;

        current.next = current.next.next;

        return head;
    }
}

// Third Approach - One Pass using distance (n) between two pointers
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head, second = head;

        for (int i = 0; i < n; i++)
            first = first.next;
        
        // If n is equal to the size of the list, we need to remove the head
        if (first == null)
            return head.next;
        
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return head;
    }
}

// Fourth Approach - Two Pointers with Dummy Node
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases such as removing the head or list with one node
        ListNode dummy = new ListNode(-1, head); // dummy.next = head

        ListNode first = dummy;
        ListNode second = dummy;

        // Move the first pointer n + 1 steps to gap of n nodes between first & second and dummy
        for (int i = 0; i <= n; i++)
            first = first.next;

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        return dummy.next;
    }
}
