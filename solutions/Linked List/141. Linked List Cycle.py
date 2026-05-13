# https://leetcode.com/problems/linked-list-cycle

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """

        """
        Time Complexity:
        Space Complexity:

        Idea: 2 pointers fast (+2) and slow (+1)
        - If they are the same before reaching the end (null)
        -> Cycle = true
        """

        slow = fast = head

        while fast and fast.next: 
            fast = fast.next.next
            slow = slow.next

            if fast == slow:
                return True
        
    
        return False