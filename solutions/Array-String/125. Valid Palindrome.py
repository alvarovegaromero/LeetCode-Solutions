#https://leetcode.com/problems/valid-palindrome

import re

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """

        s = self._sanitize(s)

        left, right = 0, len(s) - 1

        while left < right:
            if s[left] != s[right]:
                return False
            
            right -= 1
            left += 1

        return True

    # Space Complexity: O(n)
    def _sanitize(self, s):
        s = re.sub(r'[^a-zA-Z0-9]', '', s)

        """
        s = s.replace(" ", "")
        s = s.replace(",", "")
        s = s.replace(".", "")
        s = s.replace(":", "")
        s = s.replace("/", "")
        s = s.replace("@", "")
        """

        return s.lower()
        

#############################

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """

        left, right = 0, len(s) - 1

        while left < right:
            while not s[left].isalnum() and left < right:
                left += 1
            while not s[right].isalnum() and left < right:
                right -= 1

            if s[left].lower() != s[right].lower():
                return False
            
            right -= 1
            left += 1

        return True
        