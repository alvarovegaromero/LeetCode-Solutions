# https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        """
        Time Complexity: O(n)
        Space Complexity: O(1)

        K -> num of unique numbers = next valid index to store
        Array sorted -> Compare if num added checking prev value store 
        """

        k = 1 # first number will always be unique

        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[k] = nums[i]
                k += 1

        return k