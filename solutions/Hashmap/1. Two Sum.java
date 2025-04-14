//https://leetcode.com/problems/two-sum

// First approach - Nested loops
// Time complexity: O(n^2) - Space complexity: O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++)
                if(nums[i] + nums[j] == target)
                    return new int []{i, j};

        return new int []{};
    }
}

// Second Approach - Find complement number and get its index from map
// Time complexity: O(n) - Space complexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int complement;

        for(int i = 0; i < nums.length; i++)
            numIndexMap.put(nums[i], i);

        for(int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (numIndexMap.containsKey(complement) && numIndexMap.get(complement) != i) {
                return new int []{i, numIndexMap.get(complement)};
            }
        }

        return new int []{};
    }
}

// Third approach 
// One Pass HashMap avoiding the need of checking if complement is 
// not the same index as current number
// Time complexity: O(n) - Space complexity: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int complement;

        for(int i = 0; i < nums.length; i++) {
            complement = target - nums[i];

            if (numIndexMap.containsKey(complement)) 
                return new int []{i, numIndexMap.get(complement)};
            
            numIndexMap.put(nums[i], i);
        }

        return new int []{};
    }
}