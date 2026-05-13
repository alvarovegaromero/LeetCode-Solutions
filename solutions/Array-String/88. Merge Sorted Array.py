# https://leetcode.com/problems/merge-sorted-array

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """

        """
            Time Complexity: O(n+m)
            Space Complexity: O(1)

            Optimized Way of working:
                - if nums2 empty -> nums1 already sorted

                - Two pointer for each array at pos (end - 1)
                    - Compare values of each array until the pointers run out of space
                        - If nums1 is the smaller -> i-- and add it
                        - If nums 2 is the smaller -> j-- and add it
                    - 
        """

        if n == 0:
            return nums1

        i = m - 1
        j = n - 1
        k = m + n - 1 # pos for storing value

        while i >= 0 and j >= 0:
            if nums1[i] < nums2[j]:
                nums1[k] = nums2[j]
                j -= 1
            else:
                nums1[k] = nums1[i]
                i -= 1
            k -= 1

        while j >= 0:
            nums1[k] = nums2[j]
            k -= 1
            j -= 1
