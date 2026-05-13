# https://leetcode.com/problems/remove-element

class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """

        """
            Time Complexity: O(n)
            Space Complexity: O(1)

            k -> number of numbers != val = index of next valid number
            if num[i] != val --> store it in num[k] 
        """

        k = 0

        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1
                
        return k
        