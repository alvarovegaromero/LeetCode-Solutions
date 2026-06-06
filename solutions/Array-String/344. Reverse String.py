#https://leetcode.com/problems/reverse-string

# Time complexity: O(n)
# Space complexity: O(1)
class Solution(object):
    def reverseString(self, s):
        """
        :type s: List[str]
        :rtype: None Do not return anything, modify s in-place instead.
        """
        
        left, right = 0, len(s) - 1

        while left < right:
            s[left], s[right] = s[right], s[left]

            left += 1
            right -= 1