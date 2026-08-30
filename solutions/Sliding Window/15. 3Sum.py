class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        """
        Time Complexity: O(n^2)
        Space Complexity: O(n) - if u consider "results" array
        """

        def twoSum(nums, target, init_pos):
            left, right = init_pos, len(nums) - 1

            results = []

            while left < right:
                current_sum = nums[left] + nums[right]

                if current_sum == target:
                    results.append([nums[left], nums[right]])
                    left += 1
                    right -= 1

                    while left < right and nums[left] == nums[left - 1]:
                        left += 1

                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                
                elif current_sum < target:
                    left += 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                
                else:
                    right -= 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1

            return results

        nums.sort()

        i = 0
        results = []

        while i < len(nums):

            # Positive numbers can not sum 0
            if nums[i] > 0:
                break
            
            dupla_result = twoSum(nums, -nums[i], i + 1)
            if dupla_result:
                for dupla in dupla_result:
                    results.append([nums[i], dupla[0], dupla[1]])
                
            i += 1
            while i < len(nums) and nums[i] == nums[i - 1]:
                i += 1

        return results
        