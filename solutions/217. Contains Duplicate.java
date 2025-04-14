//https://leetcode.com/problems/contains-duplicate

// First Approach - Brute Force
// Time Complexity: O(n^2) - Space Complexity: O(1)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }
}

// Second Approach - Using HashSet
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> previousValuesSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            // We found a duplicate
            if(previousValuesSet.contains(nums[i]))
                return true;

            previousValuesSet.add(nums[i]);
        }

        return false;
    }
}